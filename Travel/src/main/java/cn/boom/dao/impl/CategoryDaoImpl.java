package cn.boom.dao.impl;

import cn.boom.dao.CategoryDao;
import cn.boom.domain.Category;
import cn.boom.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Category> findAll() {

        String sql = " select * from category ";
        List<Category> categorys = null;
        try {
            categorys = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
        } catch (DataAccessException e) {
            return null;
        }

        return categorys;
    }

    @Override
    public Category findById(int id) {
        String sql = " select * from category where cid = ? ";
        Category category = null;
        try {
            category = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Category>(Category.class),id);
        } catch (DataAccessException e) {

        }
        return category;
    }
}
