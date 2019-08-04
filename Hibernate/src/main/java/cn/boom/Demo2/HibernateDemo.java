package cn.boom.Demo2;


import cn.boom.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

/**
 *  多对多
 */
public class HibernateDemo {

    @Test
    /**
     * 向中间表添加信息 保存学生，联级保存中间表和课程表
     * 注意：被动方一定要放弃表的维护权
     */
    public void add() {

        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Student student1 = new Student();
        student1.setS_name("张三");
        Student student2 = new Student();
        student2.setS_name("李四");

        Course course1 = new Course();
        course1.setC_info("大英");
        Course course2 = new Course();
        course2.setC_info("高数");
        Course course3 = new Course();
        course3.setC_info("离散");

        student1.getCourse().add(course1);
        student1.getCourse().add(course2);
        student2.getCourse().add(course2);
        student2.getCourse().add(course3);

        course1.getStudents().add(student1);
        course2.getStudents().add(student1);
        course2.getStudents().add(student2);
        course3.getStudents().add(student2);

        session.save(student1);
        session.save(student2);

        transaction.commit();

    }

    /**
     * 修改中间表（学生选的课程）
     */
    @Test
    public void update() {

        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Student s1 = (Student) session.get(Student.class, 3);
        Student s2 = (Student) session.get(Student.class, 4);

        Course c1 = (Course) session.get(Course.class, 4);

        s1.getCourse().remove(c1);
        s2.getCourse().add(c1);

        session.save(s1);
        session.save(s2);

        transaction.commit();
    }
}
