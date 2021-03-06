package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.OrderDao;
import cn.itcast.travel.domain.Order;
import cn.itcast.travel.domain.myFavorite;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;

/**
 * @author csm
 * @create 2020-11-17 下午 4:40
 */
public class OrderDaoImpl implements OrderDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Order> myOrder(int uid) {
        String sql = " select * from `order` where uid =  ?";

        return  template.query(sql, new BeanPropertyRowMapper<Order>(Order.class), uid);

    }

    @Override
    //order在数据库中是关键字要转义
    public void addOrder(Order order) {
        String sql="insert into `order` values(?,?,?,?,? ) ";
        template.update(sql, order.getUid(),
                order.getRid(),
                new Date(),
                order.getStatus(),
                order.getCode()
                );
    }

    @Override
    public boolean updateOrder(String rid, int uid) {
        String sql = " update `order` set status = 'Y' where rid= ? and uid=? ";
        int n= template.update(sql,rid,uid);
        return n>=1;
    }
}
