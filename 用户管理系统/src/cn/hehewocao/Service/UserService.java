package cn.hehewocao.Service;

import cn.hehewocao.POJO.PageBean;
import cn.hehewocao.POJO.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> findAll();

    List<User> findByUser(User user);

    PageBean<User> findByPage(String page, String rows, Map<String,String[]> info);

    void delUserById(String id);

    void addUser(User user);

    boolean updateUser(String beforeId, User user);

    User findByUserId(String id);

    User login(User user);
}
