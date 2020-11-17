package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author csm
 * @create 2020-10-28 下午 3:24
 */
@WebServlet( "/category/*")

public class CategoryServlet extends BaseServlet {

    private CategoryService categoryService=new CategoryServiceImpl();

   public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       List<Category> cs=categoryService.findAll();
       writeValue(cs,response);

    }


}
