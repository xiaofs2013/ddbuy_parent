package com.Redis;

import redis.clients.jedis.Jedis;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        //jedis操作redis
        //1.POM里面记得导入Jedis的依赖
        Jedis jedis = new Jedis("localhost", 6379);  //传入主机名的端口号和Redis的端口号一样

        //2.使用Jedis对象方法操作Redis
        jedis.set("name", "小张");      //设置键值堆
        jedis.expire("name", 120); //设置存活时间
        String name = jedis.get("name");   //通过键取值
        System.out.println(name);
        Thread.sleep(2000);  //休息两秒钟
        System.out.println(jedis.ttl("name"));  //再看看还剩多久的存活时间

        //3.关闭jdedis
        jedis.close();


    }
}
