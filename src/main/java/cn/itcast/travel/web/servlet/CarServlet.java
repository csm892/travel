package cn.itcast.travel.web.servlet;

import cn.itcast.travel.dao.CarDao;
import cn.itcast.travel.domain.Car;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.domain.myFavorite;
import cn.itcast.travel.service.CarService;
import cn.itcast.travel.service.impl.CarServiceImpl;
import com.sun.xml.internal.rngom.parse.host.Base;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author csm
 * @create 2020-11-19 下午 12:22
 */
@WebServlet(name = "/car/*")
public class CarServlet extends BaseServlet {
    private CarService carService=new CarServiceImpl();

    /**
     *先判断用户是否已经把线路加入了购物车
     */
    public  void isCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取session
        User user= (User) request.getSession().getAttribute("user");
        //接受参数
        String rid = request.getParameter("rid");
        int uid;
        if (user==null){
            //用户没有登录
            uid=0;

        }else {
            uid=user.getUid();
        }


        boolean flag =carService.isCar(uid,rid);
        writeValue(flag,response);
      }
    /**
     * 用户加入购物车

     */
    public  void addCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //接受参数
        String rid = request.getParameter("rid");
        //获取session
        User user= (User) request.getSession().getAttribute("user");
        int uid;
        if (user==null){
            //用户没有登录
            return;

        }else {
            uid=user.getUid();
        }

        //调用service查询，

        boolean flag= carService.addCar(rid,uid);
        writeValue(flag,response);

    }

    /**
     * 删除购物车线路
     */
    public  void deleteCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受参数
        String rid = request.getParameter("rid");
        //获取session
        User user= (User) request.getSession().getAttribute("user");
        int uid;
        if (user==null){
            //用户没有登录
            return;

        }else {
            uid=user.getUid();
        }

        //调用service查询，
        carService.deleteCar(rid, uid);


    }
    /**
     * 购物车全部线路
     */
    public  void myCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //接受参数

        //获取session
        User user= (User) request.getSession().getAttribute("user");
        int uid;
        if (user==null){
            //用户没有登录
            uid=0;

        }else {
            uid=user.getUid();
        }

        //String uid=request.getParameter("uid");
        //调用service查询，
        List<Car> cars=carService.myCar(uid);
        writeValue(cars,response);

    }



    }
