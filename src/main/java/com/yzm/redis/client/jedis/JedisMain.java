package com.yzm.redis.client.jedis;

import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JedisMain {
    public static void main(String[] args) throws Exception{
        Jedis jedis = new Jedis();

        Log log = new Log();
        log.setName("aa");
        log.setAge(11);
        log.setId("player_1");

        Log log1 = new Log();
        log1.setName("bb");
        log1.setAge(22);
        log1.setId("player_2");

        ObjectMapper objectMapper = new ObjectMapper();

//        String logString = objectMapper.writeValueAsString(log);

//        Map<String, Log> map = new HashMap<>();
//        map.put(log.getId(), log);
//        map.put(log1.getId(), log1);

        jedis.zadd("myzset", 2, objectMapper.writeValueAsString(log));
        jedis.zadd("myzset", 3, objectMapper.writeValueAsString(log1));


        Set<String> myzset = jedis.zrangeByScore("myzset", 2, 3);

        for (String item : myzset) {
            System.out.println(item);
            Log readLog = objectMapper.readValue(item, Log.class);
            System.out.println(readLog.toString());
        }

        jedis.close();
    }
}
