package com.yzm.redis.client.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class RedissonManager {

    private static Config config = new Config();
    private static Redisson redisson = null;

    static {
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        redisson = (Redisson) Redisson.create(config);
    }

    public static Redisson getRedisson () {
        return redisson;
    }

    public static RedissonClient getRedissonClient(){
        RedissonClient redissonClient = Redisson.create(config);
        return redissonClient;
    }

}
