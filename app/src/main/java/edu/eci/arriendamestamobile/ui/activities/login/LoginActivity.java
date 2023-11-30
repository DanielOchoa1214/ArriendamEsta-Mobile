package edu.eci.arriendamestamobile.ui.activities.login;

import android.content.Intent;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import edu.eci.arriendamestamobile.R;
import edu.eci.arriendamestamobile.databinding.ActivityLoginBinding;
import edu.eci.arriendamestamobile.model.User;
import edu.eci.arriendamestamobile.ui.activities.MainActivity;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoginViewModel loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loginViewModel.getLoggedIn().observe(this, loggedIn -> {
            if (loggedIn.getId() != null){
                Intent toMain = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(toMain);
            } else {
                Toast.makeText(this, "Login incorrecto :(", Toast.LENGTH_SHORT).show();
            }
        });

        setLoginListener(loginViewModel);
        setBlackAndWhiteBg();
        setWelcomeLoginBtnListener();
        setLoginBackToWelcomBtn();
        setWelcomeCreateAccountBtnListener();
        setCreateBackToWelcomBtn();
        setGenderContents();
    }

    private void setBlackAndWhiteBg(){
        ImageView bg = binding.loginActivityBg;
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);

        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
        bg.setColorFilter(filter);
    }

    private void setWelcomeLoginBtnListener(){
        binding.toLoginBtn.setOnClickListener(v -> {
            binding.welcomePage.setVisibility(View.GONE);
            binding.loginForm.setVisibility(View.VISIBLE);
        });
    }

    private void setLoginBackToWelcomBtn(){
        binding.loginBack.setOnClickListener(v -> {
            binding.welcomePage.setVisibility(View.VISIBLE);
            binding.loginForm.setVisibility(View.GONE);
        });
    }

    private void setWelcomeCreateAccountBtnListener(){
        binding.toCreateUser.setOnClickListener(v -> {
            binding.welcomePage.setVisibility(View.GONE);
            binding.createUserForm.setVisibility(View.VISIBLE);
        });
    }

    private void setCreateBackToWelcomBtn(){
        binding.createBack.setOnClickListener(v -> {
            binding.welcomePage.setVisibility(View.VISIBLE);
            binding.createUserForm.setVisibility(View.GONE);
        });
    }

    private void setGenderContents(){
        String[] genders = {"HOMBRE", "MUJER", "OTRO"};
        Spinner spin = binding.gender;
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, genders);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
    }

    private void setLoginListener(LoginViewModel viewModel){
        binding.loginBtn.setOnClickListener(v -> {
            User u = new User();
            u.setEmail(binding.loginUser.getText().toString());
            u.setPassword(binding.loginPassword.getText().toString());
            viewModel.login(u);
        });
    }
}
