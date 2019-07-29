package cn.boom.dao;

import cn.boom.domain.User;

public interface UserDao {
    /**
     * 查询此邮箱
     * @param email
     * @return
     */
    User checkUserByEmail(String email);

    /**
     * 添加用户
     * @param user
     * @return
     */
    boolean addUser(User user);

    /**
     * 激活用户
     * @param code
     * @return
     */
    boolean activeUser(String code);

    /**
     * 查询用户状态
     * @param code
     * @return
     */
    User checkUserByCode(String code);

    /**
     * 查询用户
     * @param user
     * @return
     */
    User findUser(User user);

}
