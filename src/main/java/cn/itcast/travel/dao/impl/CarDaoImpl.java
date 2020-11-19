package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.CarDao;
import cn.itcast.travel.domain.Car;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.myFavorite;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;

/**
 * @author csm
 * @create 2020-11-19 下午 12:36
 */
public class CarDaoImpl implements CarDao {

    private JdbcTemplate template=new JdbcTemplate();
    @Override
    public Car isCar(int uid, String rid) {
        /**
         * 查询用户是否收藏过此线路
         */
       Car car = null;
        try {
            String sql = " select * from car where uid = ? and rid=?";
            car = template.queryForObject(sql, new BeanPropertyRowMapper<Car>(Car.class), uid,rid);
        } catch (DataAccessException e) {

        }
        return car;
    }

    @Override
    public int addCar(String rid, int uid) {
        int n;
        String sql="insert into car values(?,?,?) ";
        n=template.update(sql, rid, new Date(), uid);
        return n;
    }

    @Override
    public void deleteCar(int rid, int uid) {
        String sql="delete from car where rid= ? and uid = ? ";
        template.update(sql,rid,uid);
    }

    @Override
    public List<Car> myCar(int uid) {
        String sql = " select * from car where  uid = ?";

        return  template.query(sql, new BeanPropertyRowMapper<Car>(Car.class),uid);


    }
}
