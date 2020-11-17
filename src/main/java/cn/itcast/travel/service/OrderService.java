package cn.itcast.travel.service;

import cn.itcast.travel.domain.Order;

import java.util.List;

/**
 * @author csm
 * @create 2020-11-17 下午 4:35
 */
public interface OrderService {
    List<Order> myOrder(int uid);

    void addOrder(String rid, String uid);
}
