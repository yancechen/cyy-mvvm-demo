package com.yance.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

/**
 * User模型，该模型在整个应用程序中都需要被用到，包括数据库、API接口和View
 *
 * Created by chenyouyu on 2020/11/5 2:43 PM
 */
@Entity(tableName = "user")
public class User {

    @PrimaryKey
    @ColumnInfo(name = "id", typeAffinity = ColumnInfo.INTEGER)
    public int id;

    @ColumnInfo(name = "name", typeAffinity = ColumnInfo.TEXT)
    public String name;

    @ColumnInfo(name = "login", typeAffinity = ColumnInfo.TEXT)
    public String login;

    @ColumnInfo(name = "avatar", typeAffinity = ColumnInfo.TEXT)
    @SerializedName("avatar_url")
    public String avatar;

    @ColumnInfo(name = "followers", typeAffinity = ColumnInfo.INTEGER)
    public int followers;

    @ColumnInfo(name = "following", typeAffinity = ColumnInfo.INTEGER)
    public int following;

    @ColumnInfo(name = "blog", typeAffinity = ColumnInfo.TEXT)
    public String blog;

    @ColumnInfo(name = "bio", typeAffinity = ColumnInfo.TEXT)
    public String bio;

    @ColumnInfo(name = "location", typeAffinity = ColumnInfo.TEXT)
    public String location;

    @ColumnInfo(name = "html_url", typeAffinity = ColumnInfo.TEXT)
    @SerializedName("html_url")
    public String html_url;

    public User(int id, String name, String avatar, int followers, int following, String blog, String bio, String location, String html_url) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.followers = followers;
        this.following = following;
        this.blog = blog;
        this.bio = bio;
        this.location = location;
        this.html_url = html_url;
    }
}
