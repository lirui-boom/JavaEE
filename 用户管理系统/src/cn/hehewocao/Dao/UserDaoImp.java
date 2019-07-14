package cn.hehewocao.Dao;

import cn.hehewocao.JDBC.DBCPUtils;
import cn.hehewocao.POJO.User;
import cn.hehewocao.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDaoImp implements UserDao {
    @Override
    public List<User> findAll() {

        String sql = "select * from user";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public List<User> findByUser(User user) {
        String sql = "select * from user";
        QueryRunner qr = new QueryRunner(DBCPUtils.getDateSource());
        try {
            List<User> users = qr.query(sql, new BeanListHandler<User>(User.class));

            List<User> findUsers = new ArrayList<>();
            //获取用户信息
            int id = user.getId();
            String username = user.getUsername();
            String nickname = user.getNickname();
            String address = user.getAddress();
            for (User u : users) {
                boolean flagId = true;
                boolean flagUsername = true;
                boolean flagNickname = true;
                boolean flagAddress = true;
                if (id != 0) {
                    if (u.getId() != id) {
                        flagId = false;
                    }
                }
                //username
                if (!username.equals("")) {
                    if (!u.getUsername().equals(username)) {
                        flagUsername = false;
                    }
                }

                //Nickname
                if (!nickname.equals("")) {
                    if (!u.getNickname().equals(nickname)) {
                        flagNickname = false;
                    }
                }

                //address
                if (!address.equals("")) {
                    if (!u.getAddress().equals(address)) {
                        flagAddress = false;
                    }
                }

                if (flagId && flagUsername && flagNickname && flagAddress) {
                    findUsers.add(u);
                }

            }

            return findUsers;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int findCount(Map<String, String[]> info) {

        /*初始化sql语句*/
        String sql = "select count(*) from user where 1 = 1 ";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        List<String> list = new ArrayList<String>();
        for (String key : info.keySet()) {

            if (!"".equals(info.get(key)[0]) && info.get(key)[0] != null) {

                if (!key.equals("page")) {

                    if (!key.equals("rows")) {
                        sql += " and " + key + " like ? ";
                        list.add("%" + info.get(key)[0] + "%");
                    }
                }
            }
        }
        return jdbcTemplate.queryForObject(sql, list.toArray(), int.class);

    }

    @Override
    public List<User> findByPage(int startIndex, int rows, Map<String, String[]> info) {

        String sql = "select * from user where 1 = 1 ";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        List<String> list = new ArrayList<String>();
        for (String key : info.keySet()) {

            if (!"".equals(info.get(key)[0]) && info.get(key)[0] != null) {

                if (!key.equals("page")) {

                    if (!key.equals("rows")) {
                        sql += " and " + key + " like ? ";
                        list.add("%" + info.get(key)[0] + "%");
                    }
                }
            }
        }
        sql += "limit " + startIndex + " , " + rows;
        return jdbcTemplate.query(sql, list.toArray(), new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public void delUserById(int id) {
        String sql = "delete from user where id = ? ";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void addUser(User user) {

        String sql = "insert into user  values ( null, ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());

        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getNickname(), user.getSex(), user.getBirthday(),
                user.getPhone(), user.getEmail(), user.getAddress(), user.getOccupation(), user.getDescribes());

    }

    @Override
    public boolean updateUser(int beforeId, User user) {

        try {
            String sql = "update user set username = ? , password = ? , nickname = ? , sex = ? , birthday = ?" +
                    " , phone = ? , email = ? , address = ? , occupation = ? , describes = ? where id = ?";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
            jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getNickname(), user.getSex(), user.getBirthday(),
                    user.getPhone(), user.getEmail(), user.getAddress(), user.getOccupation(), user.getDescribes(), beforeId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public User findByUserId(int id) {
        String sql = "select * from user where id = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
    }

    @Override
    public User login(User user) {
        User u = new User();
        try {
            String sql = "select * from user where username = ? and password = ?";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
            u = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getUsername(), user.getPassword());
        }catch (Exception e){
            return null;
        }
        return u;
    }
}
