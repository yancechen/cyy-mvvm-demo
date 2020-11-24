package com.yance.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.yance.MyApplication;
import com.yance.db.UserDao;
import com.yance.db.UserDatabase;
import com.yance.model.User;
import com.yance.repository.UserRepository;

/**
 * Created by chenyouyu on 2020/11/5 2:43 PM
 */
public class UserViewModel extends AndroidViewModel {
    private LiveData<User> user;
    private UserRepository userRepository;

    private String userName = "yancechen";

    public UserViewModel(@NonNull Application application) {
        super(application);
        UserDatabase userDatabase = MyApplication.getUserDatabase();
        UserDao userDao = userDatabase.userDao();

        userRepository = new UserRepository(userDao, MyApplication.getApi());
        user = userRepository.getUser(userName);
    }

    public LiveData<User> getUser() {
        return user;
    }

    public void refresh() {
        userRepository.refresh(userName);
    }
}
