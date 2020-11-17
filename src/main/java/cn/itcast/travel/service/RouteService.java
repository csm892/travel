package cn.itcast.travel.service;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

/**
 * @author csm
 * @create 2020-11-02 上午 9:15
 */
public interface RouteService {
    public PageBean<Route> pageQuery(int cid,int currentPage,int pageSize,String rname);

    /**
     * 根据rid查询
     * @param rid
     * @return
     */
   public Route findOne(String rid);

   public PageBean<Route> favoritePageQuery(int uid,int rid, int currentPage, int pageSize);

    /**
     * 根据rid查询收藏次数
     */

}
