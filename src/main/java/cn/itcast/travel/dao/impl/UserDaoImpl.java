package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.util.JDBCUtils;
import cn.itcast.travel.util.StrUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User findByUsername(String username) {
        User user = null;
        try {
            //1.定义sql
            String sql = "select * from tab_user where username = ?";
            //2.执行sql
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
        } catch (Exception e) {

        }

        return user;
    }

    @Override
    public void save(User user) {
        //1.定义sql
        String sql = "insert into tab_user(username,password,name,birthday,sex,telephone,email,status,code) values(?,?,?,?,?,?,?,?,?)";
        //2.执行sql

        template.update(sql,user.getUsername(),
                    user.getPassword(),
                user.getName(),
                user.getBirthday(),
                user.getSex(),
                user.getTelephone(),
                user.getEmail(),
                user.getStatus(),
                user.getCode()
                );
    }

    /**
     * 根据激活码查询用户对象
     * @param code
     * @return
     */
    @Override
    public User findByCode(String code) {
        User user = null;
        try {
            String sql = "select * from tab_user where code = ?";

            user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),code);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return user;
    }

    /**
     * 修改指定用户激活状态
     * @param user
     */
    @Override
    public void updateStatus(User user) {
        String sql = " update tab_user set status = 'Y' where uid=?";
        template.update(sql,user.getUid());
    }

    /**
     * 根据用户名和密码查询的方法
     * @param username
     * @param password
     * @return
     */
    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user = null;
        try {
            //1.定义sql
            String sql = "select * from tab_user where username = ? and password = ?";
            //2.执行sql
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username,password);
        } catch (Exception e) {

        }

        return user;
    }

    @Override
    public User findUser(int uid) {
        User user = null;
        try {
            //1.定义sql
            String sql = "select * from tab_user where uid =  ?";
            //2.执行sql
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),uid);
        } catch (Exception e) {

        }

        return user;
    }

    @Override
    public int updateUser(User user) {
        int n=0;
        String sql = " update tab_user set ";

        StringBuilder sb = new StringBuilder(sql);
        List params = new ArrayList();//条件们
        if (StrUtil.isNotEmpty(user.getUsername())){

            sb.append( " username = ?, ");

            params.add(user.getUsername());//添加？对应的值
        }
        if (StrUtil.isNotEmpty(user.getPassword())){

            sb.append( " password = ?, ");

            params.add(user.getPassword());//添加？对应的值
        }
        if (StrUtil.isNotEmpty(user.getName())){

            sb.append( "name = ?, ");

            params.add(user.getName());//添加？对应的值
        }
        if (StrUtil.isNotEmpty(user.getTelephone())){

            sb.append( " telephone= ?, ");

            params.add(user.getTelephone());//添加？对应的值
        }

        params.add(user.getUid());
        params.add(user.getUid());
        sb.append(" uid=? where uid= ? ");//分页条件

        sql = sb.toString();

        n= template.update(sql,params.toArray());
        return n;
    }

    @Override
    public List<User> findAllUser() {
        String sql="select * from tab_user";
        return template.query(sql,new BeanPropertyRowMapper<User>(User.class));

    }
}
