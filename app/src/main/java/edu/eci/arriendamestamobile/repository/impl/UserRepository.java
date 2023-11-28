package edu.eci.arriendamestamobile.repository.impl;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import edu.eci.arriendamestamobile.model.User;
import edu.eci.arriendamestamobile.repository.interfaces.UserApiService;
import edu.eci.arriendamestamobile.repository.utils.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private static final UserApiService userApiService = RetrofitService.getUserInterface();
    private final MutableLiveData<User> user = new MutableLiveData<>(placeHolderUser());
    private static UserRepository repository;

    public static UserRepository getInstance(){
        if (repository == null) repository = new UserRepository();
        return repository;
    }

    public MutableLiveData<User> getUserById(String id){
        Call<User> userCall = userApiService.getUserById(id);
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                user.setValue(response.body());
                user.getValue().setAge(response.body().getBirthDate());
                user.setValue(user.getValue());
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("Log.DEBUG", "Me ñañe", t);
            }
        });
        return user;
    }

    private User placeHolderUser() {
        User u = new User();
        u.setName("Tanjiro Kamado");
        u.setEmail("abc@xyz.com");
        u.setBirthDate("2001-09-01");
        u.setGender("Hombre");
        u.setPhoneNumber("1234567890");
        return u;
    }
}
