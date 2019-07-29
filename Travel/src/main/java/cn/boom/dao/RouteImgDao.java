package cn.boom.dao;

import cn.boom.domain.RouteImg;

import java.util.List;

public interface RouteImgDao {
    /**
     * 根据rid查询详情图片
     * @param rid
     * @return
     */
    List<RouteImg> findByRid(int rid);
}
