package cn.boom.dao;

import cn.boom.domain.Category;

import java.util.List;

public interface CategoryDao {
    /**
     * 查询所有类别
     * @return
     */
    List<Category> findAll();

    /**
     * 通过id查询类别
     * @param id
     * @return
     */
    Category findById(int id);
}
