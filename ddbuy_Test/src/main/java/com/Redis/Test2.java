package com.Redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        //jedis操作redis   使用连接池连接
        //1.创建连接池对象
        //连接池的配置对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(30);  //设置最大连接数
        //连接池对象
        JedisPool jedisPool = new JedisPool("localhost", 6379);

        //2.创建Jedis对象
        Jedis jedis = jedisPool.getResource();

        //3.使用Jedis对象方法操作Redis
        jedis.set("name", "小张");      //设置键值堆
        jedis.expire("name", 120); //设置存活时间
        String name = jedis.get("name");   //通过键取值
        System.out.println(name);
        Thread.sleep(2000);  //休息两秒钟
        System.out.println(jedis.ttl("name"));  //再看看还剩多久的存活时间

        //4.关闭jdedis
        jedis.close();


    }
}
