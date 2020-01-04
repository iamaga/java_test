package com.bjsxt.jedis.dao.impl;

import com.bjsxt.jedis.dao.JedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisSingDaoleImpl implements JedisDao {
    @Autowired
    private JedisPool jedisPool;

    @Override
    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        String value = null;
        try{
            value = jedis.get(key);
        }finally{
            jedis.close();
        }
        return value;
    }

    @Override
    public String set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        String val = null;
        try{
            val = jedis.set(key,value);
        }finally{
            jedis.close();
        }
        return val;
    }

    @Override
    public String hget(String hkey, String key) {
        Jedis jedis = jedisPool.getResource();
        String val = null;
        try{
            val = jedis.hget(hkey,key);
        }finally{
            jedis.close();
        }
        return val;
    }

    @Override
    public long hset(String hkey, String key, String value) {
        Jedis jedis = jedisPool.getResource();
        long val = 0;
        try{
            val = jedis.hset(hkey,key,value);
        }finally{
            jedis.close();
        }
        return val;
    }

    @Override
    public long incr(String key) {
        Jedis jedis = jedisPool.getResource();
        long val = 0;
        try{
            val = jedis.incr(key);
        }finally{
            jedis.close();
        }
        return val;
    }

    @Override
    public long expire(String key, int second) {
        Jedis jedis = jedisPool.getResource();
        long val = 0;
        try{
            val = jedis.expire(key,second);
        }finally{
            jedis.close();
        }
        return val;
    }

    @Override
    public long ttl(String key) {
        Jedis jedis = jedisPool.getResource();
        long val = 0;
        try{
            val = jedis.ttl(key);
        }finally{
            jedis.close();
        }
        return val;
    }

    @Override
    public long del(String key) {
        Jedis jedis = jedisPool.getResource();
        long val = 0;
        try{
            val = jedis.del(key);
        }finally{
            jedis.close();
        }
        return val;
    }

    @Override
    public long hdel(String hkey, String key) {
        Jedis jedis = jedisPool.getResource();
        long val = 0;
        try{
            val = jedis.hdel(hkey,key);
        }finally{
            jedis.close();
        }
        return val;
    }
}
