package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.OrderDao;
import cn.itcast.travel.dao.impl.OrderDaoImpl;
import cn.itcast.travel.domain.Order;
import cn.itcast.travel.domain.myFavorite;
import cn.itcast.travel.service.OrderService;
import cn.itcast.travel.util.UuidUtil;

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
    public void addOrder(String rid, int uid) {
        Order order=new Order();
        //2.2设置激活状态
        order.setStatus("N");
        order.setCode(UuidUtil.getUuid());
        order.setRid(Integer.parseInt(rid));
        order.setUid(uid);
        orderDao.addOrder(order);
    }

    @Override
    public boolean updateOrder(String rid, int uid) {
       boolean flag= orderDao.updateOrder(rid,uid);
        return flag;
    }
}
