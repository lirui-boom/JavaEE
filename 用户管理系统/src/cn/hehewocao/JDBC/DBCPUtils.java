package cn.hehewocao.JDBC;

import org.apache.commons.dbcp.BasicDataSource;
import java.io.InputStream;
import java.util.Properties;

public class DBCPUtils {

    private static BasicDataSource bds = new BasicDataSource();

    static{
        try {
            Properties properties = new Properties();
            InputStream is = DBCPUtils.class.getClassLoader().getResourceAsStream("JDBCconfig.properties");
            properties.load(is);
            bds.setDriverClassName(properties.getProperty("driver"));
            bds.setUrl(properties.getProperty("url"));
            bds.setUsername(properties.getProperty("username"));
            bds.setPassword(properties.getProperty("password"));

            bds.setInitialSize(10);
            bds.setMaxActive(8);
            bds.setMaxIdle(2);
            bds.setMinIdle(1);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static BasicDataSource getDateSource(){
        return bds;
    }
}
