package edu.eci.arriendamestamobile.repository.impl;



import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import edu.eci.arriendamestamobile.model.User;
import edu.eci.arriendamestamobile.repository.interfaces.AuthApiService;
import edu.eci.arriendamestamobile.repository.utils.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthRepository {
    private static final AuthApiService authApiService = RetrofitService.getAuthInterface();
    private final MutableLiveData<User> successfulLogin = new MutableLiveData<>(new User());
    private static AuthRepository repository;

    public static AuthRepository getInstance(){
        if(repository == null) repository = new AuthRepository();
        return repository;
    }

    public MutableLiveData<User> login(User loggingIn){
        Call<User> loggingCall = authApiService.login(loggingIn);
        loggingCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    Log.d("Log.DEBUG", "BIEN");
                    successfulLogin.setValue(response.body());
                } else {
                    Log.d("Log.DEBUG", "MAL");
                    successfulLogin.postValue(new User());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("Log.DEBUG", "Me ñañe", t);
                successfulLogin.postValue(new User());
            }
        });
        return successfulLogin;
    }

}
