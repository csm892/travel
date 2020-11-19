package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.CarDao;
import cn.itcast.travel.dao.impl.CarDaoImpl;
import cn.itcast.travel.domain.Car;
import cn.itcast.travel.service.CarService;

import java.util.List;

/**
 * @author csm
 * @create 2020-11-19 下午 12:33
 */
public class CarServiceImpl implements CarService {
    private CarDao carDao= new CarDaoImpl();
    @Override
    public boolean isCar(int uid, String rid) {
        Car car=carDao.isCar(uid, rid);
        return car!=null;
    }

    @Override
    public boolean addCar(String rid, int uid) {
       int n= carDao.addCar(rid,uid);
       return n>=1;
    }

    @Override
    public void deleteCar(String rid, int uid) {
       carDao.deleteCar(Integer.parseInt(rid),uid);
    }

    @Override
    public List<Car> myCar(int uid) {
        List<Car> cars=carDao.myCar(uid);
        return cars;
    }

}
