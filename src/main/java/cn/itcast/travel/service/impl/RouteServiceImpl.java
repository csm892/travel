package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.RouteImgDao;
import cn.itcast.travel.dao.SellerDao;
import cn.itcast.travel.dao.impl.FavoriteDaoImpl;
import cn.itcast.travel.dao.impl.RouteDaoImpl;
import cn.itcast.travel.dao.impl.RouteImgDaoImpl;
import cn.itcast.travel.dao.impl.SellerDaoImpl;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.RouteImg;
import cn.itcast.travel.domain.Seller;
import cn.itcast.travel.service.RouteService;

import java.util.List;

/**
 * @author csm
 * @create 2020-11-02 上午 9:23
 */
public class RouteServiceImpl implements RouteService {
    private RouteDao routeDao=new RouteDaoImpl();
    private RouteImgDao routeImgDao=new RouteImgDaoImpl();
    private SellerDao sellerDao=new SellerDaoImpl();
    private FavoriteDao favoriteDao=new FavoriteDaoImpl();

    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize,String rname) {
        //封装pagebean
        PageBean<Route> pb=new PageBean<Route>();
        //当前页码
        pb.setCurrentPage(currentPage);
        //每页显示条数
        pb.setPageSize(pageSize);

        //总记录数
        int totalCount=routeDao.findTotalCount(cid,rname);
        pb.setTotalCount(totalCount);

        //当前页数显示的集合
        int start=(currentPage-1)*pageSize;//开始的记录数
        List<Route> list=routeDao.findByPage(cid,start,pageSize,rname);
        pb.setList(list);


        //总页数
        int totalPage= totalCount % pageSize == 0 ? totalCount / pageSize :(totalCount / pageSize) + 1 ;
        pb.setTotalPage(totalPage);

        return pb;


    }

    @Override
    public Route findOne(String rid) {
        //查询出一个route对象，基本信息
        Route route=routeDao.findOne(Integer.parseInt(rid));
        //查询出图片集合
        List<RouteImg> list = routeImgDao.findById(route.getRid());
        //添加到route对象之中
        route.setRouteImgList(list);
        //查询出商家集合
        Seller seller = sellerDao.findById(route.getSid());
        route.setSeller(seller);
        int count= favoriteDao.findCountByRid(route.getRid());
        route.setCount(count);




        return route;
    }

    @Override
    public PageBean<Route> favoritePageQuery(int uid,int rid, int currentPage, int pageSize) {
        //封装pagebean
        PageBean<Route> pb=new PageBean<Route>();
        //当前页码
        pb.setCurrentPage(currentPage);
        //每页显示条数
        pb.setPageSize(pageSize);

        //总记录数
        int totalCount=favoriteDao.findTotalCount(uid);
        pb.setTotalCount(totalCount);

        //当前页数显示的集合
        int start=(currentPage-1)*pageSize;//开始的记录数
        List<Route> list=routeDao.favoritefindByPage(rid,start,pageSize);
        pb.setList(list);


        //总页数
        int totalPage= totalCount % pageSize == 0 ? totalCount / pageSize :(totalCount / pageSize) + 1 ;
        pb.setTotalPage(totalPage);

        return pb;
    }


}
