package controller;

import dao.ICategoryDAO;
import model.Category;
import model.News;
import service.ICategoryService;
import service.INewsService;
import service.impl.CategoryService;
import service.impl.NewsService;
import utils.FormUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/news")

public class NewsController extends HttpServlet {
    private INewsService newsService;
    private ICategoryService categoryService;
    public NewsController(){
        this.newsService= new NewsService();
        this.categoryService= new CategoryService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type=req.getParameter("type");
        String view="/views/admin/news/list.jsp";
        if(type!=null) {
            if (type.equals("edit")) {
                String i=req.getParameter("id");
                long id= Long.parseLong(i);
                News news=  newsService.findOneById(id);
                List<Category> list= categoryService.fillAll();
                req.setAttribute("categories",list);
                req.setAttribute("model",news);

            } else {

            }
            view="/view/admin/news/edit.jsp";
        }else {
            List<News> list= newsService.findAll();
            req.setAttribute("models",list);
        }

        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/views/admin/news/list.jsp");
        requestDispatcher.forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
