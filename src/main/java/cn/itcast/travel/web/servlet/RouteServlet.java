package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.*;
import cn.itcast.travel.service.FavoriteService;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.impl.FavoriteServiceImpl;
import cn.itcast.travel.service.impl.RouteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author csm
 * @create 2020-11-01 下午 9:57
 */
@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {

   private RouteService routeService=new RouteServiceImpl();
   private FavoriteService favoriteService=new FavoriteServiceImpl();

    /**
     分页查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public  void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1接受参数
        String currentPageStr=request.getParameter("currentPage");
        String pageSizeStr=request.getParameter("pageSize");
        String cidStr=request.getParameter("cid");
        String rname=request.getParameter("rname");
        String rname2=null;
        if (rname!=null&&rname.length()>0&&!"null".equals(rname)) {
            //设置乱码
            rname2 = new String(rname.getBytes("iso-8859-1"), "utf-8");

        }
        int cid=0;
        if (cidStr!=null&&cidStr.length()>0&&!"null".equals(cidStr)){
            //2处理参数
            cid=Integer.parseInt(cidStr);
        }
        int currentPage=0;
        if (currentPageStr!=null&&currentPageStr.length()>0){
            //2处理参数
            currentPage=Integer.parseInt(currentPageStr);
        }
        else {
            currentPage=1;
        }
        int pageSize=0;
        if (pageSizeStr!=null&&pageSizeStr.length()>0){
            //2处理参数
            pageSize=Integer.parseInt(pageSizeStr);
        }
        else {
            pageSize=6;//默认显示5条记录
        }

        //3调用service查询pageBean

        PageBean<Route> pb=routeService.pageQuery(cid,currentPage,pageSize,rname2);

        //4返回数据
        writeValue(pb,response);
    }

    /**
     * 根据rid查询线路基本数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public  void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String rid=request.getParameter("rid");
        Route route=routeService.findOne(rid);
        writeValue(route,response);
    }

    /**
     * 用户是否收藏
     */
    public  void isFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //接受参数
        String rid = request.getParameter("rid");
        //获取session
        User user= (User) request.getSession().getAttribute("user");
        int uid;
        if (user==null){
            //用户没有登录
            uid=0;

        }else {
            uid=user.getUid();
        }

        //调用service查询，
        boolean flag = favoriteService.isFavorite(rid, uid);
        writeValue(flag,response);



    }

    /**
     * 用户点击收藏
     */
    public  void addFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
        favoriteService.addFavorite(rid, uid);
        //不用返回，直接操作
        //writeValue(flag,response);
    }

    /**
     * 取消收藏
     */

    public  void deleteFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
        favoriteService.deleteFavorite(rid, uid);
    }

        /**
         * 查询rid
         * @param request
         * @param response
         * @throws ServletException
         * @throws IOException
         */
    public  void myFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
        List<myFavorite> favorites=favoriteService.myFavorite(uid);
        writeValue(favorites,response);

    }

    /**
     * 通过rid查询收藏列表
     */
    public  void favoritePageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1接受参数
        String currentPageStr=request.getParameter("currentPage");
        String pageSizeStr=request.getParameter("pageSize");
        String ridStr=request.getParameter("rid");
        //String rname=request.getParameter("rname");
        //获取session
        User user= (User) request.getSession().getAttribute("user");
        int uid;
        if (user==null){
            //用户没有登录
            return;

        }else {
            uid=user.getUid();
        }
       // String uidStr=request.getParameter("uid");
       /** int uid=0;
        if (uidStr!=null&&ridStr.length()>0&&!"null".equals(uidStr)){
            //2处理参数
            uid=Integer.parseInt(uidStr);
        }*/

        int rid=0;
        if (ridStr!=null&&ridStr.length()>0&&!"null".equals(ridStr)){
            //2处理参数
            rid=Integer.parseInt(ridStr);
        }
        int currentPage=0;
        if (currentPageStr!=null&&currentPageStr.length()>0){
            //2处理参数
            currentPage=Integer.parseInt(currentPageStr);
        }
        else {
            currentPage=1;
        }
        int pageSize=0;
        if (pageSizeStr!=null&&pageSizeStr.length()>0){
            //2处理参数
            pageSize=Integer.parseInt(pageSizeStr);
        }
        else {
            pageSize=5;//默认显示5条记录
        }

        //3调用service查询pageBean

        PageBean<Route> pb=routeService.favoritePageQuery(uid,rid,currentPage,pageSize);
        //4返回数据
        writeValue(pb,response);
    }

    }
