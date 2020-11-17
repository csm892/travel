package cn.itcast.travel.service;

import cn.itcast.travel.domain.Category;

import java.util.List;

/**
 * @author csm
 * @create 2020-10-28 下午 3:21
 */
public interface CategoryService {
    /**
     * 判断集合是否为空
     * 是：访问数据库，并写入redis
     * 否：直接访问redis
     * 返回集合
     * @return
     */

    public List<Category> findAll();
}
