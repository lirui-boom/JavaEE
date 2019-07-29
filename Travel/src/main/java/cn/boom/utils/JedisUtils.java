package cn.boom.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.InputStream;
import java.util.Properties;

public class JedisUtils {

    private static JedisPool jedisPool;

    static {
        try {

            InputStream inputStream = JedisUtils.class.getClassLoader().getResourceAsStream("redis.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));
            jedisPoolConfig.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));
            jedisPool = new JedisPool(jedisPoolConfig,properties.getProperty("host"),Integer.parseInt(properties.getProperty("port")));

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("服务端可能没开启");
        }
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}
