package com.yance.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.yance.model.User;

/**
 * User 对应的 Room 数据库
 *
 * Created by chenyouyu on 2020/11/5 2:43 PM
 */
@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "user_db1";

    private static UserDatabase databaseInstance;

    public static synchronized UserDatabase getInstance(Context context) {
        if (databaseInstance == null) {
            databaseInstance = Room.databaseBuilder(context.getApplicationContext(),
                    UserDatabase.class, DATABASE_NAME).build();
        }
        return databaseInstance;
    }

    public abstract UserDao userDao();
}
