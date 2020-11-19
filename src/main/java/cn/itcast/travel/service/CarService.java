package cn.itcast.travel.service;

import cn.itcast.travel.domain.Car;

import java.util.List;

/**
 * @author csm
 * @create 2020-11-19 下午 12:32
 */
public interface CarService {
    boolean isCar(int uid, String rid);

    boolean addCar(String rid, int uid);

    void deleteCar(String rid, int uid);

    List<Car> myCar(int uid);
}
