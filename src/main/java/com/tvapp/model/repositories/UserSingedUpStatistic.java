package com.tvapp.model.repositories;

import dto.UserDto;
import org.springframework.data.redis.core.RedisHash;
import java.util.HashSet;


/**
 * Created by agamoti on 22/05/2017.
 */

@RedisHash
public class UserSingedUpStatistic {

    HashSet<UserDto> singedUpUsers;

    public HashSet<UserDto> getSingedUpUsers() {
        return singedUpUsers;
    }

    public void setLoginUsers( HashSet<UserDto> singedUpUsers) {
        this.singedUpUsers = singedUpUsers;
    }




}
