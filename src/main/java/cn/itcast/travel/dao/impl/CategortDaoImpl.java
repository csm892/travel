package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author csm
 * @create 2020-10-28 下午 3:18
 */
public class CategortDaoImpl implements CategoryDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Category> findAll() {
        String sql="select * from tab_category ";
        return template.query(sql,new BeanPropertyRowMapper<Category>(Category.class));
    }
}