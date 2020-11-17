package cn.itcast.travel.service;

import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.myFavorite;

import java.util.List;

/**
 * @author csm
 * @create 2020-11-03 下午 4:04
 */
public interface FavoriteService {
    public  boolean isFavorite(String rid,int uid);

    public void addFavorite(String rid, int uid);

    public List<myFavorite> myFavorite(int uid);

    public void deleteFavorite(String rid, int uid);
}
