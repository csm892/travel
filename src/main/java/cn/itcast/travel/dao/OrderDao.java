package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Order;
import cn.itcast.travel.domain.myFavorite;

import java.util.List;

/**
 * @author csm
 * @create 2020-11-17 下午 4:39
 */
public interface OrderDao {
    public List<Order> myOrder(int uid);

    void addOrder(Order order);

    boolean updateOrder(String rid, int uid);
}
