package cn.hehewocao.Dao;

import cn.hehewocao.POJO.User;

import java.util.List;
import java.util.Map;

/**
 * 用户基本数据库交互类
 */
public interface UserDao {
    List<User> findAll();

    List<User> findByUser(User user);

    int findCount(Map<String,String[]> info);

    List<User> findByPage(int startIndex, int endIndex, Map<String,String[]> info);

    void delUserById(int id);

    void addUser(User user);

    boolean updateUser(int beforeId, User user);

    User findByUserId(int id);

    User login(User user);
}
