package edu.eci.arriendamestamobile.model;

import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Entity
public class User {
    @PrimaryKey
    @NonNull
    private String id = "";
    private String name;
    private String email;
    private String phoneNumber;
    private String birthDate;
    private String gender;
    private String password;

    private int status = 0;

    private long age = -1;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        setAge(birthDate);
        this.birthDate = birthDate;
    }



    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getAge() {
        return age;
    }

    public void setAge(String birthDate) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.age = ChronoUnit.YEARS.between(LocalDate.parse(birthDate.substring(0, 10)), LocalDate.now());
        }
    }

    public void setAge(long age) {
        this.age = age;
    }

    @NonNull
    @Override
    public String toString() {
        return id + " : " + email + " : " + password;
    }
}
