package edu.eci.arriendamestamobile.model;

import android.os.Build;
import android.util.Log;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class User {
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String birthDate;
    private String gender;
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

    public long getAge() {
        return age;
    }

    public void setAge(String birthDate) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.age = ChronoUnit.YEARS.between(LocalDate.parse(birthDate.substring(0, 10)), LocalDate.now());
        }
    }
}
