package com.tvapp;
import com.google.common.collect.Sets;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import  org.springframework.beans.factory.annotation.Value;
import  org.springframework.context.annotation.Bean;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
public class TvApp {
    @Bean
    public JedisCluster jedisCluster(@Value("${spring.redis.pool.max-active}") int redisPoolMaxActive,
                                     @Value("${spring.redis.max.redirects}") int redisMaxRedirects,
                                     @Value("${spring.redis.timeout}") int redisPoolTimeout,
                                     @Value("${spring.redis.pool.min-idle}") int redisPoolMinIdle,
                                     @Value("${spring.redis.pool.max-wait}") int redisPoolMaxWait,
                                     @Value("${spring.redis.pool.max-idle}") int redisPoolMaxIdle,
                                     @Value("${spring.redis.host.and.port}") String[] redisHostAndPort
    ) {
        Set<HostAndPort> redisClusterMasterNodes = new HashSet<>(redisHostAndPort.length);
        Sets.newHashSet(redisHostAndPort).forEach(hostAndPort -> {
            String[] hostAndPortArray = hostAndPort.split(":");
            String host = hostAndPortArray[0];
            int port = Integer.parseInt(hostAndPortArray[1]);
            redisClusterMasterNodes.add(new HostAndPort(host, port));
        });
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(redisPoolMaxIdle);
        poolConfig.setMinIdle(redisPoolMinIdle);
        poolConfig.setMaxTotal(redisPoolMaxActive);
        poolConfig.setMaxWaitMillis(redisPoolMaxWait);

        return new JedisCluster(redisClusterMasterNodes, redisPoolTimeout, redisMaxRedirects, poolConfig);
    }



    public static void main(String[] args) throws Exception {

        SpringApplication.run(TvApp.class, args);
    }
}


