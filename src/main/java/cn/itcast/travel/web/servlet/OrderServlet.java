package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.Order;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.domain.myFavorite;
import cn.itcast.travel.service.OrderService;
import cn.itcast.travel.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author csm
 * @create 2020-11-17 下午 4:22
 */
@WebServlet("/order/*")
public class OrderServlet extends BaseServlet {
    private OrderService orderService=new OrderServiceImpl();


    /**
     *
     * 我的全部订单
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public  void myOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //String uid=request.getParameter("uid");
        //获取session
        User user= (User) request.getSession().getAttribute("user");
         int uid;
         if (user==null){
         //用户没有登录
         return;

         }else {
         uid=user.getUid();
         }
        String rid=request.getParameter("rid");
        List<Order> orders=orderService.myOrder(uid);
        writeValue(orders,response);


    }

    /**
     * 添加订单
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public  void addOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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


       orderService.addOrder(rid,uid);
    }

    public  void updateOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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



        boolean flag =  orderService.updateOrder(rid,uid);

        //3.判断标记
        String msg = null;
        if(flag){
            //激活成功
            msg = "支付成功！";
        }else{
            //激活失败
            msg = "支付失败，请重新支付!";
        }
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(msg);

    }

    }
