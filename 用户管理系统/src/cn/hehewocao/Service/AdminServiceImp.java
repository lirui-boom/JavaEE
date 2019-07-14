package cn.hehewocao.Service;

import cn.hehewocao.Dao.AdminDao;
import cn.hehewocao.Dao.AdminDaoImp;
import cn.hehewocao.POJO.Admin;

/**
 *  管理员接口的实现类
 */

public class AdminServiceImp implements AdminService {
    @Override
    public Admin login(Admin admin) {

        return new AdminDaoImp().find(admin.getAdministrators(),admin.getPassword());
    }
}
