package cn.hehewocao_user;

import cn.hehewocao_JDBC.DBCPUtils;
import cn.hehewocao_JDBC.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.BeanMapHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDao {

    public static User islogin(String name, String password) {

        User user = JDBCUtils.checkUser(name, password);
        if (user != null) {
            return user;
        }
        return null;
    }


}
