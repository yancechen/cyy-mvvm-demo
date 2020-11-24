package com.yance;

import android.app.Application;

import com.yance.api.Api;
import com.yance.api.RetrofitClient;
import com.yance.db.UserDatabase;

/**
 * Created by chenyouyu on 2020/11/5 2:43 PM
 */
public class MyApplication extends Application {

    private static MyApplication instance;
    private static UserDatabase userDatabase;
    private static Api api;

    public MyApplication() {
        super();
        instance = this;
    }

    public static synchronized MyApplication getInstance() {
        return instance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        userDatabase = UserDatabase.getInstance(this);
        api = RetrofitClient.getInstance().getApi();
    }

    public static Api getApi() {
        return api;
    }

    public static UserDatabase getUserDatabase() {
        return userDatabase;
    }
}
