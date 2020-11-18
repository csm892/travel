package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Discuss;

import java.util.List;

/**
 * @author csm
 * @create 2020-11-18 上午 11:22
 */
public interface DiscussDao {

    List<Discuss> findByRid(String rid);

    void add(Discuss discuss);
}
