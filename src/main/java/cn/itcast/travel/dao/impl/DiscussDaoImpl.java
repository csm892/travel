package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.DiscussDao;
import cn.itcast.travel.domain.Discuss;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.myFavorite;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;

/**
 * @author csm
 * @create 2020-11-18 上午 11:22
 */
public class DiscussDaoImpl implements DiscussDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Discuss> findByRid(String rid) {
        String sql = " select * from Discuss where rid = ?";

        return  template.query(sql, new BeanPropertyRowMapper<Discuss>(Discuss.class), rid);

    }

    @Override
    public void add(Discuss discuss) {
        //1.定义sql
        String sql = "insert into discuss(rid,uid,date,content,username) values (?,?,?,?,? ) ";
        //2.执行sql

        template.update(sql,discuss.getRid(),
                discuss.getUid(),
             discuss.getDate(),
                discuss.getContent(),
                discuss.getUsername()

        );
    }

    @Override
    public Discuss isDiscuss(int uid) {
        //用户十分评论过
        Discuss discuss=null;
        try {
            String sql = " select * from discuss where  uid = ?";
            discuss = template.queryForObject(sql, new BeanPropertyRowMapper<Discuss>(Discuss.class), uid);
        } catch (DataAccessException e) {
            // System.out.println("没有用户");

        }
        return discuss;
    }


}
