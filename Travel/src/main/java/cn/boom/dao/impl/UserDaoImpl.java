package cn.boom.dao.impl;

import cn.boom.dao.UserDao;
import cn.boom.domain.User;
import cn.boom.utils.JDBCUtils;
import cn.boom.utils.UuidUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User checkUserByEmail(String email) {

        User user = null;
        String sql = " select * from user where email = ? ";

        try {
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), email);
        } catch (DataAccessException e) {

        }

        return user;
    }

    @Override
    public boolean addUser(User user) {


        String sql = " insert into user(email,password,status,code) values (?,?,?,?) ";

        try {
            template.update(sql, user.getEmail(), user.getPassword(), user.getStatus(), user.getCode());
            return true;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return false;

    }

    @Override
    public boolean activeUser(String code) {

        String sql = " update user set status='Y' where code = ? ";
        try {
            template.update(sql, code);
        } catch (DataAccessException e) {
            return false;
        }
        return true;
    }

    @Override
    public User checkUserByCode(String code) {

        String sql = "select * from user where code = ? ";
        User user = null;
        try {
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), code);
        } catch (DataAccessException e) {

        }

        return user;
    }

    @Override
    public User findUser(User user) {
        String sql = " select * from user where email = ? and password = ? ";
        User u = null;
        try {
            u = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getEmail(), user.getPassword());
        } catch (DataAccessException e) {

        }
        return u;
    }


}
