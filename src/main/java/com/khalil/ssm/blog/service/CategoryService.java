package com.khalil.ssm.blog.service;

import com.khalil.ssm.blog.entity.Category;

import java.util.List;

public interface CategoryService {

    /**
     * 获取分类总数
     * @return
     */
    Integer countCategory();

    /**
     * 获取分类列表
     * @return
     */
    List<Category> listCategory();

    /**
     * 获取分类列表和总数
     * @return
     */
    List<Category> listCategoryWithCount();

    /**
     * 删除分类
     * @param id
     */
    void deleteCategory(Integer id);

    /**
     * 根据id查询分类信息
     * @param id
     * @return 分类
     */
    Category getCategoryById(Integer id);

    /**
     * 添加分类
     * @param category
     * @return
     */
    Category insertCategory(Category category);

    /**
     * 更新分类
     * @param category 分类
     */
    void updateCategory(Category category);

    /**
     * 根据分类名获取分类
     * @param name 名称
     * @return 分类
     */
    Category getCategoryByName(String name);
}
