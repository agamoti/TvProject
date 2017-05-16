package com.tvapp.rest.services;

import com.tvapp.model.entities.User;
import dto.UserDto;

/**
 * Created by nimrod_t on 5/15/2017.
 */
public interface UserService {
    void logout(UserDto userDto);
    void login(UserDto userDto);
    UserDto signup(UserDto userDto);
    User getUserById(Long id);
}
