package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Car;

import java.util.List;

/**
 * @author csm
 * @create 2020-11-19 下午 12:36
 */
public interface CarDao {
    Car isCar(int uid, String rid);

    int addCar(String rid, int uid);

    void deleteCar(int rid, int uid);

    List<Car> myCar(int uid);
}
