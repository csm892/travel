package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.Discuss;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.DiscussService;
import cn.itcast.travel.service.impl.DiscussServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author csm
 * @create 2020-11-18 上午 11:00
 */
@WebServlet("/discuss/*")
public class DiscussServlet extends BaseServlet {

    private DiscussService discussService=new DiscussServiceImpl();
    //展示一个线路所有的评论
    public void findByRid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String rid=request.getParameter("rid");
        List<Discuss> discuss=discussService.findByRid(rid);
        writeValue(discuss,response);

    }
    //填写评论
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rid=request.getParameter("rid");
        String uid=request.getParameter("uid");
        String username=request.getParameter("username");
        //获取表单提交评论内容
        Map<String, String[]> map = request.getParameterMap();
        Discuss discuss=new Discuss();
        discuss.setRid(Integer.parseInt(rid));
        discuss.setUid(Integer.parseInt(uid));

        discuss.setDate(new Date());
        discuss.setUsername(username);
        //封装提交的评论内容
        try {
            BeanUtils.populate(discuss,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //System.out.println(discuss);
        discussService.add(discuss);


    }
    /**
     * 判断用户是否评论过
     */
    public  void isDiscuss(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //获取session
      User user= (User) request.getSession().getAttribute("user");
        int uid;
        if (user==null){
            //用户没有登录
            uid=0;

        }else {
            uid=user.getUid();
        }

        //调用service查询，*/
       // String uid=request.getParameter("uid");
        boolean flag = discussService.isDiscuss(uid);
        writeValue(flag,response);
     }

    }
