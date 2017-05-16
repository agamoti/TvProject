package com.tvapp.rest;

import com.tvapp.model.entities.User;
import com.tvapp.rest.services.UserService;
import dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by nimrod_t on 5/15/2017.
 */
@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public UserDto signup(@RequestBody UserDto userDto) {
        return userService.signup(userDto);
    }

    @RequestMapping (method = RequestMethod.GET, value =  "/user/{id}")
    private User showUser(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @RequestMapping (method = RequestMethod.POST, value =  "/user/login")
    private void login(@RequestBody UserDto userDto){
        userService.login(userDto);
    }

    @RequestMapping (method = RequestMethod.POST, value =  "/user/logout")
    private void logout(@RequestBody UserDto userDto){
        userService.logout(userDto);
    }
}
