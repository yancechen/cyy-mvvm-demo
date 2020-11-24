package com.yance.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.yance.model.User;

/**
 * 用于访问 User 表的 Dao 文件
 *
 * Created by chenyouyu on 2020/11/5 2:43 PM
 */
@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User user);

    @Delete
    void deleteStudent(User user);

    /**
     * 查询方式返回的是 LiveData 包装过的 User，这样当 Room 中的数据
     * 发生变化时，能够自动通知数据观察者
     *
     * @param login
     * @return
     */
    @Query("SELECT * FROM user WHERE login = :login")
    LiveData<User> getUserByName(String login);
}
