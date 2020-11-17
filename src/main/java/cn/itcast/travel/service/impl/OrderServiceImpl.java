package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.OrderDao;
import cn.itcast.travel.dao.impl.OrderDaoImpl;
import cn.itcast.travel.domain.Order;
import cn.itcast.travel.domain.myFavorite;
import cn.itcast.travel.service.OrderService;

import java.util.List;

/**
 * @author csm
 * @create 2020-11-17 下午 4:36
 */
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao=new OrderDaoImpl();
    @Override
    public List<Order> myOrder(int uid) {
        List<Order> orders=orderDao.myOrder(uid);
        return orders;
    }

    @Override
    public void addOrder(String rid, String uid) {
        orderDao.addOrder(rid,uid);
    }
}
