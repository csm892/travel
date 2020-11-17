package cn.itcast.travel.dao;

import cn.itcast.travel.domain.RouteImg;

import java.util.List;

/**
 * @author csm
 * @create 2020-11-03 下午 12:04
 */
public interface RouteImgDao {
    public List<RouteImg> findById(int id);
}
