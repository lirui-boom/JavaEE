package cn.boom.service;



import cn.boom.domain.Category;

import java.util.List;

public interface CategoryService {
    /**
     * 查询所有类别
     * @return
     */
    List<Category> findAll();

    /**
     * 通过id查询类别
     * @return
     */
    Category findById(String cid);
}
