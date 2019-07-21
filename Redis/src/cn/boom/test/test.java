package cn.boom.test;

import cn.boom.utils.JedisUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import javax.swing.*;
import java.util.List;

public class test {


    @Test
    public void test_1(){

        Jedis jedis = JedisUtils.getJedis();

        String provinces = jedis.get("provinces");
        System.out.println(provinces);

        jedis.close();

    }
}
