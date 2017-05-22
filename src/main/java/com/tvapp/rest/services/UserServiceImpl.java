package com.tvapp.rest.services;
import com.tvapp.model.entities.User;
import com.tvapp.model.repositories.UserRepository;
import dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;


/**
 * Created by nimrod_t on 5/15/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StatisticService statisticService;



    @Override
    public void logout(UserDto userDto) {
       User user = userRepository.findOne(userDto.getId());
        user.setLogin(false);
        userRepository.save(user);
        statisticService.logOut(userDto);
    }

    @Override
    public void login(UserDto userDto) {
    User user = userRepository.findOne(userDto.getId());
        if(userDto.getPassword().equals(user.getPassword())) {
            user.setLogin(true);
            userRepository.save(user);
        }
        statisticService.login(userDto);

    }

    @Override
    public UserDto signup(UserDto userDto) {
        User user = convertFromDto(userDto);
        userRepository.save(user);
        userDto.setId(user.getId());
        userDto.setLogin(true);
        statisticService.singedUp(userDto);
        return userDto;
    }

    private User convertFromDto(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setUserName(userDto.getUserName());
        user.setLogin(true);
        return user;
    }

    public User getUserById(Long id){
        return userRepository.findOne(id);
    }
}
