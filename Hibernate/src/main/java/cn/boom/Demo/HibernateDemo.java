package cn.boom.Demo;

import cn.boom.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

public class HibernateDemo {


    @Test
    public void addCustomer() {

        //1.加载配置文件
        Configuration configuration = new Configuration().configure();
        //创建SessionFactor对象
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //创建Session对象
        Session session = sessionFactory.openSession();
        //开启事务
        Transaction transaction = session.beginTransaction();
        //编写代码

        Customer customer = new Customer();
        customer.setCust_name("张四");
        customer.setCust_phone("15691729703");
        session.save(customer);

        //提交事务
        transaction.commit();
        //释放资源
        session.close();
    }

    @Test
    public void addCustomerUtils() {

        Session session = HibernateUtils.openSession();
        //开启事务
        Transaction transaction = session.beginTransaction();

        Customer customer = new Customer();
        customer.setCust_name("李刚");

        session.save(customer);

        //提交事务
        transaction.commit();

        session.close();
    }


    @Test
    //保存customer联级保存linkmam
    public void test() {


        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Customer customer1 = new Customer();
        customer1.setCust_name("张三");
        Customer customer2 = new Customer();
        customer2.setCust_name("张四");

        LinkMan linkMan1 = new LinkMan();
        linkMan1.setL_name("王5");
        LinkMan linkMan2 = new LinkMan();
        linkMan2.setL_name("王6");
        LinkMan linkMan3 = new LinkMan();
        linkMan3.setL_name("王7");
        LinkMan linkMan4 = new LinkMan();
        linkMan4.setL_name("王8");

        customer1.getSetMans().add(linkMan1);
        linkMan1.setCustomer(customer1);

        customer1.getSetMans().add(linkMan2);
        linkMan2.setCustomer(customer1);

        customer2.getSetMans().add(linkMan3);
        linkMan3.setCustomer(customer2);

        customer2.getSetMans().add(linkMan4);
        linkMan4.setCustomer(customer2);

        session.save(customer1);
        session.save(customer2);
        transaction.commit();
    }

    @Test
    /**
     * 级联删除
     */
    public void linkDel() {

        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = (Customer) session.get(Customer.class, 15l);
        session.delete(customer);

        transaction.commit();
    }
}

