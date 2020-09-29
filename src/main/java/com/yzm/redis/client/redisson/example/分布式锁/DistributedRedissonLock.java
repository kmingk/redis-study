package com.yzm.redis.client.redisson.example.分布式锁;

import com.yzm.redis.client.redisson.RedissonManager;
import org.redisson.Redisson;
import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;

public class DistributedRedissonLock {

    private static Redisson redisson = RedissonManager.getRedisson();

    private static final String LOCK_TITLE = "redisson_lock_";

    public static boolean acquire(String lockName) {
        // 创建想要获取的锁
        String lock = LOCK_TITLE + lockName;

        // 获取锁对象
        RLock redissonLock = redisson.getLock(lock);

        // 设置过期时间，防止死锁
        redissonLock.lock(2, TimeUnit.MINUTES);

        System.out.println(Thread.currentThread().getName() + "获取的了锁：" + lockName);

        return true;

    }

    public static void release (String lockName) {
        String lock = LOCK_TITLE + lockName;
        RLock redissonLock = redisson.getLock(lock);
        redissonLock.unlock();
        System.out.println(Thread.currentThread().getName() + "释放锁");
    }

}
