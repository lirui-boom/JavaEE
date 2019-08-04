package cn.boom.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * hibernate工具类
 */
public class HibernateUtils {
    private static final Configuration conf;
    private static final SessionFactory sf;

    static {
        conf = new Configuration().configure();
        sf = conf.buildSessionFactory();
    }

    public static Session openSession() {
        return sf.openSession();
    }

    public static Session getCurrentSession() {
        return sf.getCurrentSession();
    }
}
