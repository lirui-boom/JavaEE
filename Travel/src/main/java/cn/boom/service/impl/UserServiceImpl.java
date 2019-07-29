package cn.boom.service.impl;

import cn.boom.dao.UserDao;
import cn.boom.dao.impl.UserDaoImpl;
import cn.boom.domain.User;
import cn.boom.service.UserService;
import cn.boom.utils.MailUtils;
import cn.boom.utils.UuidUtil;


public class UserServiceImpl implements UserService {

    private UserDao ud = new UserDaoImpl();

    @Override
    public boolean checkUserByEmail(String email) {

        User user = ud.checkUserByEmail(email);
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }


    @Override
    public boolean addUser(User user) {

        String code = UuidUtil.getUuid();
        String status = "N";
        user.setStatus(status);
        user.setCode(code);
        boolean flagAdd = ud.addUser(user);
        if (flagAdd) { //发送邮件

            //此处配置服务器IP地址
            String ip = "localhost";
            String link = "http://"+ip+"/user/active?code="+code;
            String content = "<a href='"+link+"'>您刚才完成了黑马旅游网的注册，请点击此链接完成账号激活。(若被拦截，请复制以下链接在新标签页内打开)</a><br>"+link;
            MailUtils.sendMail(user.getEmail(), content, "激活您的账号");
            return true;
        }
        return false;

    }

    @Override
    public boolean checkUserByCode(String code) {
        User user = ud.checkUserByCode(code);
        if(user != null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean activeUser(String code) {
        return ud.activeUser(code);
    }

    @Override
    public User findUser(User user) {
        return ud.findUser(user);
    }

    @Override
    public boolean isActive(User user) {

        User u = ud.findUser(user);
        if (u != null && u.getStatus().equals("Y")) {
            return true;
        }else {
            return false;
        }
    }

}
