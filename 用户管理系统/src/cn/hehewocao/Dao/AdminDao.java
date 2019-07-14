package cn.hehewocao.Dao;

import cn.hehewocao.POJO.Admin;

/**
 *  管理员的数据访问层
 */
public interface AdminDao {
    public Admin find(String administrator,String password);
}
