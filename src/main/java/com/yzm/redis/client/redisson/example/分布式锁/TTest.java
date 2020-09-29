package com.yzm.redis.client.redisson.example.分布式锁;

public class TTest {

    public static void main(String[] args) {

        String lock = "123";

        boolean isAcquireLock = DistributedRedissonLock.acquire(lock);

        if (!isAcquireLock) {
            System.out.println("未获取到锁");
        }else {
            System.out.println("获取到了锁，正在处理业务");
            System.out.println("业务处理完，执行释放锁");
            DistributedRedissonLock.release(lock);

        }
        
        boolean isAcquireLock2 = DistributedRedissonLock.acquire(lock);
        if (isAcquireLock2) {
            System.out.println("aaaa");
        }

    }

}
