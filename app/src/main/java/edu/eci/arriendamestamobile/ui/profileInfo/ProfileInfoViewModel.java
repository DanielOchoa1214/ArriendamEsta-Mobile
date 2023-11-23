package edu.eci.arriendamestamobile.ui.profileInfo;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import edu.eci.arriendamestamobile.model.User;
import edu.eci.arriendamestamobile.repository.interfaces.UserApiService;
import edu.eci.arriendamestamobile.repository.utils.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileInfoViewModel extends ViewModel {

    private final MutableLiveData<User> userInfo;
    private final UserApiService userApiService = RetrofitService.getUserInterface();



    public ProfileInfoViewModel() {
        userInfo = new MutableLiveData<>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        getApiData();
    }

    private void getApiData(){
        Call<User> userCall = userApiService.getUserById("u1");
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                userInfo.setValue(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                userInfo.postValue(null);
            }
        });
    }

    private User getTestData(){
        User test = new User();
        try {
            test.setEmail("abc@xyz.com");
            test.setBirthDate(new SimpleDateFormat("dd/MM/yyyy").parse("12/09/02"));
            test.setGender("Hombre");
            test.setPhoneNumber("1234567890");
        } catch (ParseException ignored){}


        return test;
    }

    public LiveData<User> getUserInfo() {
        return userInfo;
    }
}
