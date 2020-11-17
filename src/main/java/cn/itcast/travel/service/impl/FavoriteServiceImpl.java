package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.dao.impl.FavoriteDaoImpl;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.myFavorite;
import cn.itcast.travel.service.FavoriteService;

import java.util.List;

/**
 * @author csm
 * @create 2020-11-03 下午 4:06
 */
public class FavoriteServiceImpl implements FavoriteService {
    private FavoriteDao favoriteDao=new FavoriteDaoImpl();
    @Override
    public boolean isFavorite(String rid, int uid) {
        //转换为int
        Favorite favorite = favoriteDao.findByRidAndUid(Integer.parseInt(rid), uid);
        return favorite!=null;//存在则返回true
    }

    @Override
    public void addFavorite(String rid, int uid) {
        favoriteDao.add(Integer.parseInt(rid),uid);
    }

    @Override
    public List<myFavorite> myFavorite(int uid) {
        List<myFavorite> routes=favoriteDao.myFavorite(uid);
        return routes;
    }

    @Override
    public void deleteFavorite(String rid, int uid) {
        favoriteDao.delete(Integer.parseInt(rid),uid);
    }
}
