package edu.eci.arriendamestamobile.persistence.databases;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import edu.eci.arriendamestamobile.model.User;
import edu.eci.arriendamestamobile.persistence.dao.UserDao;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase db;

    public static AppDatabase getInstance(Context context){
        if (db == null) db = Room.databaseBuilder(context, AppDatabase.class, "session-db").build();
        return db;
    }

    public abstract UserDao userDao();
}
