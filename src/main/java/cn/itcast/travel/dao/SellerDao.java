package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Seller;

import java.util.List;

/**
 * @author csm
 * @create 2020-11-03 下午 12:11
 */
public interface SellerDao {
    public Seller findById(int id);
}
