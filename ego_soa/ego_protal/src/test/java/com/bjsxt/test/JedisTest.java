package com.bjsxt.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.*;

import java.util.HashSet;
import java.util.Set;

public class JedisTest {
    /**
     * Redis 单机版池连
     */
//    @Test
    public void redisSingle(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "111.229.128.207", 6379);
        Jedis jedis = jedisPool.getResource();
        jedis.set("tutu","wht");
        String s = jedis.get("tutu");
        System.out.println(s);
        jedisPool.close();
    }

    /**
     * Redis 集群
     */
//    @Test
    public void redisCluster(){
        Set<HostAndPort> set = new HashSet<>();
        set.add(new HostAndPort("111.229.128.207",7001));
        set.add(new HostAndPort("111.229.128.207",7002));
        set.add(new HostAndPort("111.229.128.207",7003));
        set.add(new HostAndPort("111.229.128.207",7004));
        set.add(new HostAndPort("111.229.128.207",7005));
        set.add(new HostAndPort("111.229.128.207",7006));
        JedisCluster jedisCluster = new JedisCluster(set);
        jedisCluster.set("sxt","aga");
        String s = jedisCluster.get("sxt");
        System.out.println(s);
    }

    /**
     * spring and redis 单机版连接池
     */
//    @Test
    public void jedisAndSpring(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-jedis.xml");
        JedisPool jedisPool = (JedisPool)ac.getBean("jedisPool");
        Jedis jedis = jedisPool.getResource();
        String str = jedis.get("tutu");
        System.out.println(str);
        jedisPool.close();
    }

    /**
     * spring and redis 集群版
     */

//    @Test
    public void jedisClusterAndSpring(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-jedis.xml");
        JedisCluster jedisCluster = (JedisCluster)ac.getBean("jedisCluster");
        String s = jedisCluster.get("sxt");
        System.out.println(s);

    }
}
