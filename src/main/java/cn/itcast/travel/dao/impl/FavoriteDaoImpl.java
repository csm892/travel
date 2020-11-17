package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.myFavorite;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author csm
 * @create 2020-11-03 下午 4:08
 */
public class FavoriteDaoImpl implements FavoriteDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Favorite findByRidAndUid(int rid, int uid) {
        /**
         * 查询用户是否收藏过此线路
         */
        Favorite favorite = null;
        try {
            String sql = " select * from tab_favorite where rid = ? and uid = ?";
            favorite = template.queryForObject(sql, new BeanPropertyRowMapper<Favorite>(Favorite.class), rid, uid);
        } catch (DataAccessException e) {
           // System.out.println("没有用户");

        }
        return favorite;

    }

    @Override
    public int findCountByRid(int rid) {
        /**
         * 根据rid查询收藏的次数
         */
        String sql="select count(*) from tab_favorite  where rid=? ";

        return  template.queryForObject(sql,Integer.class,rid);
    }

    @Override
    public void add(int rid, int uid) {
        String sql="insert into tab_favorite values(?,?,?) ";
       template.update(sql, rid, new Date(), uid);

    }

    @Override
    public List<myFavorite> myFavorite(int uid) {


            String sql = " select rid from tab_favorite where uid = ?";

            return  template.query(sql, new BeanPropertyRowMapper<myFavorite>(myFavorite.class), uid);

    }

    @Override
    public int findTotalCount(int uid) {
        // String sql = "select count(*) from tab_route where cid = ?";
        String sql="select count(*) from tab_favorite where 1=1 ";
        StringBuilder sb=new StringBuilder(sql);
        List params=new ArrayList();
        if (uid!=0){
            sb.append("  and uid = ?");
            params.add(uid);

        }

        //sql.toString();
        sql=sb.toString();

        return template.queryForObject(sql,Integer.class,params.toArray());

    }

    @Override
    public void delete(int rid, int uid) {
        String sql="delete from tab_favorite where rid= ? and uid = ? ";
        template.update(sql,rid,uid);
    }
}
