package com.tvapp.rest.services;

import dto.UserDto;

/**
 * Created by agamoti on 22/05/2017.
 */
public interface StatisticService {

    void login(UserDto userDto);
    void logOut(UserDto userDto);
    void singedUp(UserDto userDto);
}
