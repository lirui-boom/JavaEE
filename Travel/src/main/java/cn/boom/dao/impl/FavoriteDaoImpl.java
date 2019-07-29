package cn.boom.dao.impl;

import cn.boom.dao.FavoriteDao;
import cn.boom.domain.Favorite;
import cn.boom.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FavoriteDaoImpl implements FavoriteDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public int findCountByRid(int rid) {

        String sql = " select count(*) from favorite where rid = ? ";

        return jdbcTemplate.queryForObject(sql,Integer.class,rid);
    }

    @Override
    public Favorite findIsCollect(int rid, int uid) {

        String sql = " select * from favorite where rid = ? and uid = ? ";

        Favorite favorite = null;
        try {
            favorite = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Favorite>(Favorite.class),rid,uid);
        } catch (DataAccessException e) {
        }
        return favorite;
    }

    @Override
    public boolean add(int rid, int uid) {

        String sql = " insert into favorite values (?,?,?) ";
        Date now = new Date();
        String str = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(str);
        boolean flag = false;

        try {
            jdbcTemplate.update(sql, rid, sdf.format(now),uid);
            return true;
        } catch (DataAccessException e) {

        }
        return false;
    }

    @Override
    public List<Favorite> findAll(int uid) {

        String sql = " select * from favorite where uid = ? ";
        List<Favorite> favoriteList = null;

        try {
            favoriteList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Favorite>(Favorite.class), uid);
        } catch (DataAccessException e) {
        }

        return favoriteList;
    }

    @Override
    public List<Favorite> findByPage(int uid, int start, int pageSize) {

        String sql = " select * from favorite where uid = ? limit ?,? ";
        List<Favorite> favoriteList = null;
        try {
            favoriteList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Favorite>(Favorite.class), uid , start , pageSize);
        } catch (DataAccessException e) {
        }

        return favoriteList;
    }

    @Override
    public int findCountByUid(int uid) {
        String sql = " select count(*) from favorite where uid = ? ";

        return jdbcTemplate.queryForObject(sql,Integer.class,uid);
    }
}
