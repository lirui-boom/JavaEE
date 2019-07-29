package cn.boom.service;

import cn.boom.domain.Favorite;
import cn.boom.domain.PageBean;
import cn.boom.domain.Route;

import java.util.List;

public interface FavoriteService {
    /**
     * 查询路线是否被此用户收藏
     * @param rid
     * @param uid
     * @return
     */
    boolean isCollect(String rid, String uid);

    /**
     * 用户添加收藏功能
     * @param rid
     * @param uid
     * @return
     */
    boolean addFavorite(String rid, String uid);

    /**
     * 查询该用户所有的收藏信息
     * 封装路线对象
     * @param uid
     * @return
     */
    PageBean<Route> findAllCollect(String uid, String currentPage, String pageSize);
}
