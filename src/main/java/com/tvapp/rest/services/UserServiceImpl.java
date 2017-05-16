package com.tvapp.rest.services;

import com.tvapp.model.entities.User;
import com.tvapp.model.repositories.UserRepository;
import dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nimrod_t on 5/15/2017.
 */
@Service
public class UserServiceImpl implements UserService {
    private List<User>
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto signup(UserDto userDto) {
        User user = convertFromDto(userDto);
        userRepository.save(user);

        return null;
    }

    private User convertFromDto(UserDto userDto) {
        return null;
    }
}
