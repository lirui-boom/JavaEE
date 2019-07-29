package cn.boom.dao.impl;

import cn.boom.dao.RouteImgDao;
import cn.boom.domain.RouteImg;
import cn.boom.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RouteImgDaoImpl implements RouteImgDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<RouteImg> findByRid(int rid) {
        String sql = " select * from route_img where rid = ?";
        List<RouteImg> routeImgs = null;
        try {
            routeImgs = jdbcTemplate.query(sql, new BeanPropertyRowMapper<RouteImg>(RouteImg.class), rid);
        } catch (DataAccessException e) {
        }
        return routeImgs;
    }
}
