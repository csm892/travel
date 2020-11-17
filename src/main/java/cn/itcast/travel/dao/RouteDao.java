package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Route;

import java.util.List;

/**
 * @author csm
 * @create 2020-11-02 上午 9:18
 */
public interface RouteDao {
    public int findTotalCount(int cid ,String rname);
    public List<Route> findByPage(int cid,int start,int pageSize,String rname);

     public Route findOne(int rid);

  public List<Route> favoritefindByPage(int rid, int start, int pageSize);
}
