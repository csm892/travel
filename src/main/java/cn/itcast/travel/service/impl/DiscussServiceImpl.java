package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.DiscussDao;
import cn.itcast.travel.dao.impl.DiscussDaoImpl;
import cn.itcast.travel.domain.Discuss;
import cn.itcast.travel.domain.myFavorite;
import cn.itcast.travel.service.DiscussService;

import java.util.List;

/**
 * @author csm
 * @create 2020-11-18 上午 11:13
 */
public class DiscussServiceImpl implements DiscussService {
    private DiscussDao discussDao=new DiscussDaoImpl();
    @Override
    public List<Discuss> findByRid(String rid) {
        List<Discuss> discusses=discussDao.findByRid(rid);
        return discusses;
    }

    @Override
    public void add(Discuss discuss) {
        discussDao.add(discuss);
    }
}
