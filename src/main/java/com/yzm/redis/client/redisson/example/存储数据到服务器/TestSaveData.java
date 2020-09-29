package com.yzm.redis.client.redisson.example.存储数据到服务器;

import com.yzm.redis.client.redisson.RedissonManager;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;

public class TestSaveData {

    public static void main(String[] args) {

        RedissonClient redissonClient = RedissonManager.getRedissonClient();
        RBucket<Object> key = redissonClient.getBucket("a");
        key.set("aa");

    }

}
