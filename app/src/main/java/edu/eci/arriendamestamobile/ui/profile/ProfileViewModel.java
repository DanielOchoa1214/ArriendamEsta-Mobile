package edu.eci.arriendamestamobile.ui.profile;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.logging.Level;

import edu.eci.arriendamestamobile.model.User;
import edu.eci.arriendamestamobile.repository.impl.UserRepository;
import edu.eci.arriendamestamobile.repository.interfaces.UserApiService;
import edu.eci.arriendamestamobile.repository.utils.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileViewModel extends ViewModel {

    private MutableLiveData<User> user;
    private final UserRepository repository = UserRepository.getInstance();


    public ProfileViewModel() {
        getUserById("u1");
    }

    public void getUserById(String id){
        user = repository.getUserById(id);
    }

    public LiveData<User> getUser() {
        return user;
    }
}
