package edu.eci.arriendamestamobile.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import edu.eci.arriendamestamobile.data.user.User;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileViewModel extends ViewModel {

    private final MutableLiveData<User> user;


    public ProfileViewModel() {
        user = new MutableLiveData<>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        user.setValue(getTestData());
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
