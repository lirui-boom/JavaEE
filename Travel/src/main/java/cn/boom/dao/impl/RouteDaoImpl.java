package cn.boom.dao.impl;

import cn.boom.dao.RouteDao;
import cn.boom.domain.Route;
import cn.boom.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.ArrayList;
import java.util.List;


public class RouteDaoImpl implements RouteDao {

    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int findTotalCount(int cid, String condition) {

        String sql = " select count(*) from route where 1 = 1 ";

        List<Object> params = new ArrayList<Object>();
        if (cid != 0) {
            sql += " and cid = ? ";
            params.add(cid);
        }

        if (condition != null) {
            sql += " and rname like ? ";
            params.add("%" + condition + "%");
        }

        return jdbcTemplate.queryForObject(sql, Integer.class, params.toArray());

    }

    @Override
    public List<Route> findByPage(int cid, int start, int pageSize, String condition) {


        String sql = " select * from route where 1=1 ";
        List<Object> params = new ArrayList<Object>();
        if (cid != 0) {
            sql += " and cid = ? ";
            params.add(cid);
        }

        if (condition != null) {
            sql += " and rname like ? ";
            params.add("%" + condition + "%");
        }

        sql += " limit ?,? ";
        params.add(start);
        params.add(pageSize);

        List<Route> routeList = null;
        try {
            routeList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Route>(Route.class), params.toArray());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
        return routeList;
    }

    @Override
    public Route findById(int rid) {

        String sql = " select * from route where rid = ? ";

        Route route = null;
        try {
            route = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Route>(Route.class), rid);
        } catch (DataAccessException e) {

        }
        return route;
    }
}
