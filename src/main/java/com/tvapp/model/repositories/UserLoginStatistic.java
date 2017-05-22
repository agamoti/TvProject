package com.tvapp.model.repositories;

import dto.UserDto;
import org.springframework.data.redis.core.RedisHash;

import java.sql.Time;
import java.util.Hashtable;

/**
 * Created by agamoti on 22/05/2017.
 */

@RedisHash
public class UserLoginStatistic {
    Hashtable<Long , UserDto> loginUsers;


    public Hashtable<Long , UserDto> getLoginUsers() {
        return loginUsers;
    }
    public void setLoginUsers(Hashtable<Long , UserDto> loginUsers) {
        this.loginUsers = loginUsers;
    }




}
