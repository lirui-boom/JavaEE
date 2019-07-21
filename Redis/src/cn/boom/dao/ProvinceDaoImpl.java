package cn.boom.dao;


import cn.boom.domain.Province;
import cn.boom.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao{

    @Override
    public List<Province> findProvinces() {

        String sql = "select * from provinces";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Province>(Province.class));

    }
}
