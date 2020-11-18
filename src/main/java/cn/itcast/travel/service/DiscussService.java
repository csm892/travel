package cn.itcast.travel.service;

import cn.itcast.travel.domain.Discuss;

import java.util.List;

/**
 * @author csm
 * @create 2020-11-18 上午 11:12
 */
public interface DiscussService {

    List<Discuss> findByRid(String rid);

    void add(Discuss discuss);
}
