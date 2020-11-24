package com.yance.api;

import com.yance.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @Description: java类作用描述
 * @Author: chenyouyu
 * @CreateDate: 2020/10/30 2:12 PM
 */
public interface Api {
    @GET("users/{login}")
    Call<User> getUser(@Path("login") String login);
}
