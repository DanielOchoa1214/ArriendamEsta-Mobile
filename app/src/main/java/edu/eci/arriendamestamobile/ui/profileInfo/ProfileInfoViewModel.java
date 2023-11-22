package edu.eci.arriendamestamobile.ui.profileInfo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import edu.eci.arriendamestamobile.model.User;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileInfoViewModel extends ViewModel {

    private final MutableLiveData<User> userInfo;


    public ProfileInfoViewModel() {
        userInfo = new MutableLiveData<>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        userInfo.setValue(getTestData());
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
