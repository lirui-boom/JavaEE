package cn.boom.service;

import cn.boom.domain.User;

public interface UserService {
    /**
     * 查询此邮箱是否存在
     * @param email
     * @return
     */
    boolean checkUserByEmail(String email);

    /**
     * 注册用户，发送邮件
     * @param user
     * @return
     */
    boolean addUser(User user);

    boolean checkUserByCode(String code);

    boolean activeUser(String code);

    User findUser(User user);

    boolean isActive(User user);
}
