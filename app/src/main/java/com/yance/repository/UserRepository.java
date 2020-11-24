package com.yance.repository;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.yance.api.Api;
import com.yance.db.UserDao;
import com.yance.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by chenyouyu on 2020/11/5 2:43 PM
 */
public class UserRepository {
    private String TAG = this.getClass().getName();
    private UserDao userDao;
    private Api api;

    public UserRepository(UserDao userDao, Api api) {
        this.userDao = userDao;
        this.api = api;
    }

    public LiveData<User> getUser(final String name) {
        refresh(name);
        return userDao.getUserByName(name);
    }

    public void refresh(String userName) {
        api.getUser(userName).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.body() != null) {
                    insertUser(response.body());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    private void insertUser(final User user) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                userDao.insertUser(user);
            }
        });
    }
}
