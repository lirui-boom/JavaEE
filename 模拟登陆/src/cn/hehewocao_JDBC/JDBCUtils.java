package cn.hehewocao_JDBC;

import cn.hehewocao_user.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class JDBCUtils {

    public static User checkUser(String username, String password) {

        String sql = "select * from user where username = ? and password = ?";
        QueryRunner qr = new QueryRunner(DBCPUtils.getDateSource());
        Object[] param = { username, password };
        User user = new User();
        try {
            user = qr.query(sql, new BeanHandler<User>(User.class),param);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }

}
