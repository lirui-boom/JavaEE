package cn.boom.service.impl;

import cn.boom.dao.CategoryDao;
import cn.boom.dao.impl.CategoryDaoImpl;

import cn.boom.domain.Category;
import cn.boom.service.CategoryService;
import cn.boom.utils.JedisUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> findAll() {

        //先从Redis中查询
        Jedis jedis = JedisUtils.getJedis();
        Set<Tuple> tupleSet = jedis.zrangeWithScores("category", 0, -1);
        if (tupleSet == null || tupleSet.size() == 0) {
            //从数据库中查询 添加redis
            //System.out.println("mysql...");
            List<Category> categorys = categoryDao.findAll();
            for (int i = 0; i < categorys.size(); i++) {
                Category category = categorys.get(i);
                jedis.zadd("category", category.getCid(), category.getCname());

            }
            return categorys;

        } else {
            //从Redis中获取
            //System.out.println("redis...");
            List<Category> categorys = new ArrayList<Category>();
            for (Tuple tuple : tupleSet) {
                Category category = new Category();
                category.setCid((int) tuple.getScore());
                category.setCname(tuple.getElement());
                categorys.add(category);
            }

            return categorys;
        }

    }

    @Override
    public Category findById(String cid) {

        return categoryDao.findById(Integer.parseInt(cid));
    }
}
