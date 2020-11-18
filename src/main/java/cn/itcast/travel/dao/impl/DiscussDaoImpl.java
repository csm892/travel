package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.DiscussDao;
import cn.itcast.travel.domain.Discuss;
import cn.itcast.travel.domain.myFavorite;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

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
        String sql = "insert into discuss(rid,uid,date,content) values (?,?,?,? ) ";
        //2.执行sql

        template.update(sql,discuss.getRid(),
                discuss.getUid(),
                discuss.getDate(),
                discuss.getContent()

        );
    }
}
