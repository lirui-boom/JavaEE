package cn.boom.dao;

import cn.boom.domain.Route;

import java.util.List;

public interface RouteDao {
    /**
     * 查询该类别下的总记录数
     * @param cid
     * @return
     */
    int findTotalCount(int cid,String condition);

    /**
     * 查询数据
     * @param cid       类别
     * @param start     开始
     * @param pageSize  步长
     * @return
     */
    List<Route> findByPage(int cid, int start, int pageSize, String condition);

    /**
     * 查询路线
     * @param rid
     * @return
     */
    Route findById(int rid);
}
