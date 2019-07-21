package cn.boom.service;

import cn.boom.dao.ProvinceDao;
import cn.boom.dao.ProvinceDaoImpl;
import cn.boom.domain.Province;
import cn.boom.utils.JedisUtils;
import org.codehaus.jackson.map.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {

    @Override
    public String findProvince_json() {

        Jedis jedis = JedisUtils.getJedis();
        String provinces = jedis.get("provinces");
        if (provinces == null || provinces.length() == 0) {
            ProvinceDao pd = new ProvinceDaoImpl();
            List<Province> provinceLists = pd.findProvinces();
            ObjectMapper mapper = new ObjectMapper();
            try {
                String provinces_json = mapper.writeValueAsString(provinceLists);
                jedis.set("provinces", provinces_json);
                jedis.close();
                System.out.println("查询数据库....");
                return provinces_json;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            jedis.close();
            System.out.println("查询Redis缓存....");
            return provinces;
        }

        return null;
    }

}
