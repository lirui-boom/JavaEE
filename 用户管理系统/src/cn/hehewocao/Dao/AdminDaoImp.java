package cn.hehewocao.Dao;

import cn.hehewocao.POJO.Admin;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import cn.hehewocao.JDBC.DBCPUtils;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 *  管理员数据访问层的实现类
 */
public class AdminDaoImp implements AdminDao {
    @Override
    public Admin find(String administrator,String password) {
        String sql = "select * from admin where administrator = ? and password = ?";
        QueryRunner qr = new QueryRunner((DataSource) DBCPUtils.getDateSource());
        Admin admin = new Admin();
        try {
           admin = qr.query(sql, new BeanHandler<Admin>(Admin.class), administrator,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
}
