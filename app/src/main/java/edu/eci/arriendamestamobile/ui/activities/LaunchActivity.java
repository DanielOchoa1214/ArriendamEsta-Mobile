package edu.eci.arriendamestamobile.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import edu.eci.arriendamestamobile.persistence.databases.AppDatabase;
import edu.eci.arriendamestamobile.ui.activities.login.LoginActivity;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        AppDatabase db = AppDatabase.getInstance(getApplicationContext());

        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            Log.d("PUTAAAA", db.userDao().getAll().toString());
            if (db.userDao().getAll().isEmpty()) {
                Intent toLogin = new Intent(LaunchActivity.this, LoginActivity.class);
                startActivity(toLogin);
            } else {
                Intent toMain = new Intent(LaunchActivity.this, MainActivity.class);
                startActivity(toMain);
            }
        });
    }
}
