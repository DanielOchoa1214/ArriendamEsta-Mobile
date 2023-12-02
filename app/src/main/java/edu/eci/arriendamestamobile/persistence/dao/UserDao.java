package edu.eci.arriendamestamobile.persistence.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import edu.eci.arriendamestamobile.model.User;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE id LIKE :id LIMIT 1")
    User loadById(String id);

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);
}
