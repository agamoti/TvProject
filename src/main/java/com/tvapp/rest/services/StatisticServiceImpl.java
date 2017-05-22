package com.tvapp.rest.services;

import com.tvapp.model.repositories.UserLoginStatistic;
import com.tvapp.model.repositories.UserSingedUpStatistic;
import dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by agamoti on 22/05/2017.
 */
public class StatisticServiceImpl implements  StatisticService {

    @Autowired
    UserLoginStatistic userLoginStatistic;

    @Autowired
    UserSingedUpStatistic userSingedUpStatistic;


    @Override
    public void login(UserDto userDto) {
        userLoginStatistic.getLoginUsers().put(userDto.getId(), userDto);
    }

    @Override
    public void logOut(UserDto userDto) {
        userLoginStatistic.getLoginUsers().remove(userDto.getId());
    }

    @Override
    public void singedUp(UserDto userDto) {
        userSingedUpStatistic.getSingedUpUsers().add(userDto);
    }
}
