package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.impl.CategortDaoImpl;
import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author csm
 * @create 2020-10-28 下午 3:22
 */
public class CategoryServiceImpl  implements CategoryService {
    /**
     * 判断集合是否为空
     * 是：访问数据库，并写入redis
     * 否：直接访问redis
     * 返回集合
     * @return
     */

    private CategoryDao categoryDao=new CategortDaoImpl();
    public List<Category> findAll() {
    //1.从redis查询
    //1 .1获取jedis连接
   Jedis jedis=JedisUtil.getJedis();
   //使用sortset排序
  // Set<String> category=jedis.zrange("category",0,-1);
        //传递两个元素
       Set<Tuple> category= jedis.zrangeByScoreWithScores("category",0,-1);
   List<Category> cs=null;
    // 2判断集合是否为空
    if (category==null||category.size()==0){
        //3为空，从数据库中查询，并且写入redis中
        cs= categoryDao.findAll();
        //写入redis
        for (int i = 0; i < cs.size(); i++) {
            jedis.zadd("category",cs.get(i).getCid(),cs.get(i).getCname());
        }

    }else {
        //4不为空，从redis中查询，直接返回
       // System.out.println("从redis中查询.....");

        //4.如果不为空,将set的数据存入list
        cs = new ArrayList<Category>();
        for (Tuple tuple : category) {
            Category categorys = new Category();
            categorys.setCname(tuple.getElement());
            categorys.setCid((int) tuple.getScore());

            cs.add(categorys);
        }


    }

        return cs;
    }
}
