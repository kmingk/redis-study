package com.yzm.learnredis.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashMap;
import java.util.Map;

public class RedisTest {

    private JedisPool jedisPool;
    private JedisPoolConfig config;

    @BeforeTest
    public void before(){

        config = new JedisPoolConfig();
        config.setMaxIdle(10);
        config.setMaxWaitMillis(3000);
        config.setMaxTotal(50);
        config.setMinIdle(5);

        jedisPool = new JedisPool(config, "localhost", 6379);
    }


    @AfterTest
    public void after(){
        jedisPool.close();
    }

    // 操作String类型
    @Test
    public void testString(){

        Jedis resource = jedisPool.getResource();

        resource.set("jk", "jv");

        String jv = resource.get("jk");

        System.out.println(jv);


        resource.close();
        jedisPool.close();

    }

    // 操作hash类型
    @Test
    public void hash () {
        Jedis jedis = jedisPool.getResource();

        Map<String, String> map = new HashMap<>();
        map.put("aa", "abc");
        map.put("zz", "qwe");
        jedis.hset("hashjava", "a", "aabb");
        jedis.hset("hashjava", "b", "bbcc");

        jedis.hsetnx("hashjava", "c", "cc");

        jedis.hmset("hashjava", map);

        Boolean hexists = jedis.hexists("hashjava", "aa");
        if (hexists) {
            System.out.println("---" + jedis.hget("hashjava", "aa"));
        }

        jedis.close();
    }

    // 操作list类型
    @Test
    public void list () {
        Jedis jedis = jedisPool.getResource();

        jedis.lpush("listjava", "a", "b", "c");

        String listjava = jedis.rpop("listjava");
        System.out.println("rpop" + listjava);

        jedis.close();


    }

}
