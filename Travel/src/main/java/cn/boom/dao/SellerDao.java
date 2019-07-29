package cn.boom.dao;

import cn.boom.domain.RouteImg;
import cn.boom.domain.Seller;

import java.util.List;

public interface SellerDao {
    /**
     * 根据id查询代理商家信息
     * @param id
     * @return
     */
    Seller findById(int id);
}
