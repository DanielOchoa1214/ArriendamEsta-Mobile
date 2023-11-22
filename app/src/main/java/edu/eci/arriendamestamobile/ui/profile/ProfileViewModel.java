package edu.eci.arriendamestamobile.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import edu.eci.arriendamestamobile.model.User;
import edu.eci.arriendamestamobile.repository.interfaces.UserApiService;
import edu.eci.arriendamestamobile.repository.utils.RetrofitService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileViewModel extends ViewModel {

    private final MutableLiveData<User> user;
    private final UserApiService userApiService = RetrofitService.getUserInterface();


    public ProfileViewModel() {
        user = new MutableLiveData<>();
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
