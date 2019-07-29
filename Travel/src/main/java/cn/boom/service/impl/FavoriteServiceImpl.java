package cn.boom.service.impl;

import cn.boom.dao.FavoriteDao;
import cn.boom.dao.RouteDao;
import cn.boom.dao.impl.FavoriteDaoImpl;
import cn.boom.dao.impl.RouteDaoImpl;
import cn.boom.domain.Favorite;
import cn.boom.domain.PageBean;
import cn.boom.domain.Route;
import cn.boom.service.FavoriteService;

import java.util.ArrayList;
import java.util.List;

public class FavoriteServiceImpl implements FavoriteService {
    private FavoriteDao favoriteDao = new FavoriteDaoImpl();
    private RouteDao routeDao = new RouteDaoImpl();

    @Override
    public boolean isCollect(String rid, String uid) {

        Favorite favorite = favoriteDao.findIsCollect(Integer.parseInt(rid), Integer.parseInt(uid));

        if (favorite == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean addFavorite(String rid, String uid) {

        return favoriteDao.add(Integer.parseInt(rid), Integer.parseInt(uid));

    }

    @Override
    public PageBean<Route> findAllCollect(String uidStr, String currentPageStr, String pageSizeStr) {

        //校验信息
        int uid = Integer.parseInt(uidStr);
        int currentPage;
        int pageSize;
        if (currentPageStr == null || currentPageStr.length() == 0){
            currentPageStr = "1";
        }
        if (pageSizeStr == null || pageSizeStr.length() == 0) {
            pageSizeStr = "12";
        }
        currentPage = Integer.parseInt(currentPageStr);
        pageSize = Integer.parseInt(pageSizeStr);
        if (currentPage < 1) {
            currentPage = 1;
        }
        if (pageSize < 1) {
            pageSize = 12;
        }

        int start = (currentPage - 1) * pageSize;

        //封装数据
        PageBean<Route> favoritePageBean = new PageBean<Route>();
        List<Route> routeList = new ArrayList<Route>();

        List<Favorite> favoriteList = favoriteDao.findByPage(uid,start,pageSize);

        for (int i = 0; i < favoriteList.size(); i++) {

            int rid = favoriteList.get(i).getRid();
            Route route = routeDao.findById(rid);
            routeList.add(route);

        }

        int totalCount = favoriteDao.findCountByUid(uid);
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize + 1);
        favoritePageBean.setList(routeList);
        favoritePageBean.setCurrentPage(currentPage);
        favoritePageBean.setTotalCount(totalCount);
        favoritePageBean.setTotalPage(totalPage);
        favoritePageBean.setPageSize(pageSize);

        return favoritePageBean;
    }
}
