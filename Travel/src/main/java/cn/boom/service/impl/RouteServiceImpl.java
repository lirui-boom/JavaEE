package cn.boom.service.impl;

import cn.boom.dao.FavoriteDao;
import cn.boom.dao.RouteDao;
import cn.boom.dao.RouteImgDao;
import cn.boom.dao.SellerDao;
import cn.boom.dao.impl.FavoriteDaoImpl;
import cn.boom.dao.impl.RouteDaoImpl;
import cn.boom.dao.impl.RouteImgDaoImpl;
import cn.boom.dao.impl.SellerDaoImpl;
import cn.boom.domain.PageBean;
import cn.boom.domain.Route;
import cn.boom.domain.RouteImg;
import cn.boom.domain.Seller;
import cn.boom.service.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService {

    private RouteDao routeDao = new RouteDaoImpl();
    private RouteImgDao routeImgDao = new RouteImgDaoImpl();
    private SellerDao sellerDao = new SellerDaoImpl();
    private FavoriteDao favoriteDao= new FavoriteDaoImpl();
    /**
     * 分页查询，封装PageBean对象
     * @param cid
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageBean<Route> findByPage(int cid, int currentPage, int pageSize, String condition) {

        PageBean<Route> routePageBean = new PageBean<Route>();

        //查询该类别下的总记录数
        int totalCount = routeDao.findTotalCount(cid,condition);
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize + 1);

        int start = (currentPage - 1) * pageSize;
        //页面数据
        List<Route> routeList = routeDao.findByPage(cid,start,pageSize,condition);

        routePageBean.setTotalCount(totalCount);
        routePageBean.setTotalPage(totalPage);
        routePageBean.setCurrentPage(currentPage);
        routePageBean.setPageSize(pageSize);
        routePageBean.setList(routeList);

        return routePageBean;
    }

    /**
     * 封装详细路线信息
     * @param rid
     * @return
     */
    @Override
    public Route findRouteDetail(String rid) {

        Route route = routeDao.findById(Integer.parseInt(rid));

        List<RouteImg> routeImgs = routeImgDao.findByRid(route.getRid());
        route.setRouteImgList(routeImgs);

        Seller seller = sellerDao.findById(route.getSid());
        route.setSeller(seller);

        //收藏次数
        int count = favoriteDao.findCountByRid(route.getRid());
        route.setCount(count);

        return route;

    }
}
