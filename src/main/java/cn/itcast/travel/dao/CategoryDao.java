package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Category;

import java.util.List;

/**
 * @author csm
 * @create 2020-10-28 下午 3:17
 */
public interface CategoryDao {
    public List<Category> findAll();
}
