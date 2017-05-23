package com.tvapp.rest;


import com.tvapp.consts.RedisKeys;
import com.tvapp.rest.services.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Created by nimrod_t on 5/23/2017.
 */


@RestController
@RequestMapping("/api/v1/statistic")
public class StatisticController {

    @Autowired
    private StatisticService statisticService;

    @RequestMapping(method = RequestMethod.POST, value = "/currentLogin")
    public Set<String> getNumofLogIn(){
        return statisticService.getStatistic(RedisKeys.logedinKey);
    }


    @RequestMapping(method =  RequestMethod.POST, value =  "/numOfUsers")
    public Set<String> getNumOfUsers(){
        return  statisticService.getStatistic(RedisKeys.signedupKey);
    }




}
