package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.myFavorite;

import java.util.List;

/**
 * @author csm
 * @create 2020-11-03 下午 4:07
 */
public interface FavoriteDao {
    //查询是否收藏
     public Favorite findByRidAndUid(int rid,int uid);

     public int findCountByRid(int rid);

     public void add(int rid, int uid);

    public List<myFavorite> myFavorite(int uid);

    public int findTotalCount(int uid);

    public  void delete(int parseInt, int uid);
}
