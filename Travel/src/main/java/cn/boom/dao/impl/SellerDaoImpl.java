package cn.boom.dao.impl;

import cn.boom.dao.SellerDao;
import cn.boom.domain.Seller;
import cn.boom.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class SellerDaoImpl implements SellerDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public Seller findById(int id) {

        String sql = " select * from seller where sid = ?";
        Seller seller = null;
        try {
            seller = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Seller>(Seller.class), id);
        } catch (DataAccessException e) {

        }
        return seller;
    }
}
