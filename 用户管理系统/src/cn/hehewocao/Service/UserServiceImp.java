package cn.hehewocao.Service;

import cn.hehewocao.Dao.UserDaoImp;
import cn.hehewocao.POJO.PageBean;
import cn.hehewocao.POJO.User;
import cn.hehewocao.Dao.UserDao;

import java.util.List;
import java.util.Map;

public class UserServiceImp implements UserService {

    @Override
    public List<User> findAll() {
        UserDao ud = new UserDaoImp();
        return ud.findAll();
    }

    @Override
    public List<User> findByUser(User user) {

        UserDao ud = new UserDaoImp();
        return ud.findByUser(user);
    }

    @Override
    public PageBean<User> findByPage(String _page, String _rows, Map<String,String[]> info) {

        PageBean<User> pb = new PageBean<User>();
        //设置默认值
        if ("".equals(_page) || _page == null) {
            _page = "1";
        }

        if ("".equals(_rows) || _rows == null) {
            _rows = "5";
        }

        int page = Integer.parseInt(_page);
        int rows = Integer.parseInt(_rows);

        if(page < 1){
            page = 1;
        }

        if(rows < 1){
            rows = 1;
        }

        //设置查询的页数和每页的记录条数
        pb.setPage(page);
        pb.setRow(rows);

        UserDao ud = new UserDaoImp();
        int count  = ud.findCount(info);
        //总记录数
        pb.setCount(count);

        int startIndex = (page - 1) * rows;

        List<User> list  = ud.findByPage(startIndex,rows,info);

        if (list == null || list.size() == 0){
            return null;
        }

        //该页记录集合
        pb.setList(list);

        //页数
        int pages = count % rows == 0 ? count/rows : count/rows + 1;
        pb.setPages(pages);

        return pb;
    }

    @Override
    public void delUserById(String _id) {
        UserDao ud = new UserDaoImp();
        int id = Integer.parseInt(_id);
        ud.delUserById(id);
    }

    @Override
    public void addUser(User user) {
        UserDao ud = new UserDaoImp();
        ud.addUser(user);
    }

    @Override
    public boolean updateUser(String _beforeId, User user) {
        int beforeId = Integer.parseInt(_beforeId);
        UserDao ud = new UserDaoImp();
        return ud.updateUser(beforeId,user);
    }

    @Override
    public User findByUserId(String id) {

        UserDao ud = new UserDaoImp();
        return ud.findByUserId(Integer.parseInt(id));
    }

    @Override
    public User login(User user) {

        UserDao ud = new UserDaoImp();
        return ud.login(user);
    }
}
