package com.bjsxt.jedis.dao.impl;

import com.bjsxt.jedis.dao.JedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.JedisCluster;

public class JedisClusterDaoleImpl implements JedisDao {
    @Autowired
    private JedisCluster jedisCluster;
    @Override
    public String get(String key) {
        String jes=null;
        try {

            jes = jedisCluster.get(key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return jes;
    }

    @Override
    public String set(String key, String value) {
        String jes=null;
        try {

            jes = jedisCluster.set(key,value);
        }catch (Exception e){
            e.printStackTrace();
        }
        return jes;
    }

    @Override
    public String hget(String hkey, String key) {
        String jes=null;
        try {
            jes = jedisCluster.hget(hkey,key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return jes;
    }

    @Override
    public long hset(String hkey, String key, String value) {
        Long jes=null;
        try {
            jes = jedisCluster.hset(hkey,key,value);
        }catch (Exception e){
            e.printStackTrace();
        }
        return jes;
    }

    @Override
    public long incr(String key) {
        Long jes=null;
        try {
            jes = jedisCluster.incr(key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return jes;
    }

    @Override
    public long expire(String key, int second) {
        Long jes=null;
        try {
            jes = jedisCluster.expire(key,second);
        }catch (Exception e){
            e.printStackTrace();
        }
        return jes;
    }

    @Override
    public long ttl(String key) {
        Long jes=null;
        try {
            jes = jedisCluster.ttl(key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return jes;
    }

    @Override
    public long del(String key) {
        Long jes=null;
        try {
            jes = jedisCluster.del(key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return jes;
    }

    @Override
    public long hdel(String hkey, String key) {
        Long jes=null;
        try {
            jes = jedisCluster.hdel(hkey,key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return jes;
    }
}
