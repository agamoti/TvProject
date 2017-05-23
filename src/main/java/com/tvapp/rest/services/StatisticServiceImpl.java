package com.tvapp.rest.services;


import com.tvapp.consts.RedisKeys;
import com.tvapp.enums.UserStatistics;
import dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by agamoti on 22/05/2017.
 */
@Service
public class StatisticServiceImpl implements  StatisticService {

    @Autowired
    private JedisCluster jedisCluster;

    @Override
    public void handleStatisticsAction(UserDto userDto, UserStatistics userStatistics) {

        switch (userStatistics) {
            case USER_LOGIN:
                jedisCluster.sadd(RedisKeys.logedinKey, userDto.getId().toString());
                break;
            case USER_LOGOUT:
                jedisCluster.srem(RedisKeys.logedinKey, userDto.getId().toString());
                break;
            case USER_SIGN_UP:
                jedisCluster.sadd(RedisKeys.signedupKey, userDto.getId().toString());
                break;
            default:
                break;
        }
    }

    @Override
    public Set<String> getStatistic(String rKey) {
        Set<String> statistic =  new HashSet<>();
        switch (rKey) {
            case RedisKeys.logedinKey:
                statistic.add(jedisCluster.scard(RedisKeys.logedinKey).toString());
                break;
            case RedisKeys.signedupKey:
                statistic = jedisCluster.smembers(RedisKeys.signedupKey);
                break;
            default:
                break;
        }
        return  statistic;
    }

}
