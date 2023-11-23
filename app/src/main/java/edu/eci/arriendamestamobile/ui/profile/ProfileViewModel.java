package edu.eci.arriendamestamobile.ui.profile;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.logging.Level;

import edu.eci.arriendamestamobile.model.User;
import edu.eci.arriendamestamobile.repository.interfaces.UserApiService;
import edu.eci.arriendamestamobile.repository.utils.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileViewModel extends ViewModel {

    private final MutableLiveData<User> user;
    private final UserApiService userApiService = RetrofitService.getUserInterface();


    public ProfileViewModel() {
        user = new MutableLiveData<>();
        getApiData();
    }

    private void getApiData(){
        Call<User> userCall = userApiService.getUserById("u1");
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                user.setValue(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                user.postValue(null);
            }
        });
    }

    private User getTestData(){
        User test = new User();
        test.setName("TU MADRE");
        return test;
    }

    public LiveData<User> getUser() {
        return user;
    }
}
