package cn.boom.dao;

import cn.boom.domain.Favorite;

import java.util.List;

public interface FavoriteDao {

    /**
     * 查询线路收藏次数
     * @param rid
     * @return
     */
    int findCountByRid(int rid);

    /**
     * 查询路线是否被此用户收藏
     * @param rid
     * @param uid
     * @return
     */
    Favorite findIsCollect(int rid, int uid);

    /**
     * 添加用户收藏
     * @param rid
     * @param uid
     * @return
     */
    boolean add(int rid, int uid);

    /**
     * 查询用户所有收藏信息
     * @param i
     * @return
     */
    List<Favorite> findAll(int i);

    /**
     * 用户收藏分页查询
     * @param uid
     * @param start
     * @param pageSize
     * @return
     */
    List<Favorite> findByPage(int uid, int start, int pageSize);

    /**
     * 查询用户收藏线路总数
     * @param uid
     * @return
     */
    int findCountByUid(int uid);
}
