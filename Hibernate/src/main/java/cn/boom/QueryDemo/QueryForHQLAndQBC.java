package cn.boom.QueryDemo;

import cn.boom.Demo.Customer;
import cn.boom.Demo.LinkMan;
import cn.boom.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.junit.jupiter.api.Test;

import javax.sound.midi.SoundbankResource;
import java.util.List;

public class QueryForHQLAndQBC {

    @Test
    /**
     * 简单查询
     */
    public void test1(){

        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(Customer.class);
        List<Customer> list = criteria.list();
        /*String hql = " from Customer ";
        List<Customer> list = session.createQuery(hql).list();
        */

        for (Customer customer : list) {

            System.out.println(customer);

        }

        transaction.commit();
    }

    @Test
    /**
     * 排序查询
     */
    public void test2() {

        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        /*String hql = " from Customer order by cust_id desc "; //降序
        List<Customer> list = session.createQuery(hql).list();*/
        Criteria criteria = session.createCriteria(Customer.class);
        criteria.addOrder(Order.desc("cust_id"));//降序
        List<Customer> list = criteria.list();

        for (Customer customer : list) {

            System.out.println(customer);
        }
        transaction.commit();

    }

    @Test
    /**
     * 条件查询
     */
    public void test3() {

        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();

       /* String hql = " from Customer where cust_id = ? ";
        Query query = session.createQuery(hql);
        query.setParameter(0, 13l);
        Customer customer = (Customer)  query.uniqueResult();*/

       /* Criteria criteria = session.createCriteria(Customer.class);
        criteria.add(Restrictions.eq("cust_id", 13l));
        Customer customer = (Customer) criteria.uniqueResult();

        System.out.println(customer);*/

       //模糊查询
        Criteria criteria = session.createCriteria(Customer.class);
        criteria.add(Restrictions.like("cust_name", "张%"));
        List<Customer> list = criteria.list();
        for (Customer customer : list) {
            System.out.println(customer);
        }

        transaction.commit();

    }

    @Test
    /**
     * 分页查询
     */
    public void test4() {

        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        /*String hql = " from LinkMan";
        Query query = session.createQuery(hql);
        query.setFirstResult(3);
        query.setMaxResults(3);
        List<LinkMan> list = query.list();*/

        Criteria criteria = session.createCriteria(LinkMan.class);
        criteria.setFirstResult(3);
        criteria.setMaxResults(3);
        List<LinkMan> list = criteria.list();

        for (LinkMan linkMan : list) {
            System.out.println(linkMan);
        }

        transaction.commit();
    }

    @Test
    /**
     * 离线查询
     */
    public void test5() {

        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
        detachedCriteria.add(Restrictions.like("cust_name", "张%"));

        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = detachedCriteria.getExecutableCriteria(session);
        List<Customer> list = criteria.list();

        for (Customer customer : list) {
            System.out.println(customer);
        }
        transaction.commit();

    }

}
