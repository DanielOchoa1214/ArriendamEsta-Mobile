package edu.eci.arriendamestamobile.ui.fragments.profileInfo;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import edu.eci.arriendamestamobile.model.User;
import edu.eci.arriendamestamobile.repository.impl.UserRepository;
import edu.eci.arriendamestamobile.repository.interfaces.UserApiService;
import edu.eci.arriendamestamobile.repository.utils.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileInfoViewModel extends ViewModel {

    private MutableLiveData<User> userInfo = new MutableLiveData<>();
    private final UserRepository repository = UserRepository.getInstance();

    public ProfileInfoViewModel() {
        getUserById("u1");
    }

    public void getUserById(String id){
        userInfo = repository.getUserById(id);
    }

    public LiveData<User> getUserInfo() {
        return userInfo;
    }
}
