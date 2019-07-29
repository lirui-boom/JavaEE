package cn.boom.service;

import cn.boom.domain.PageBean;
import cn.boom.domain.Route;

public interface RouteService {
    /**
     * 分页查询功能
     * @param cid
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageBean<Route> findByPage(int cid, int currentPage, int pageSize, String condition);

    /**
     * 根据rid查询旅游路线详情信息
     * @param rid
     * @return
     */
    Route findRouteDetail(String rid);
}
