package edu.eci.arriendamestamobile.ui.activities.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import edu.eci.arriendamestamobile.model.User;
import edu.eci.arriendamestamobile.repository.impl.AuthRepository;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<User> loggedIn = new MutableLiveData<>(new User());
    private final AuthRepository repository = AuthRepository.getInstance();

    public void login(User user){
        loggedIn.setValue(repository.login(user).getValue());
    }

    public LiveData<User> getLoggedIn(){
        return loggedIn;
    }
}
