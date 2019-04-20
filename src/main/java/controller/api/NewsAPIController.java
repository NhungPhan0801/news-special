package controller.api;


import model.News;
import model.User;
import service.INewsService;
import service.impl.NewsService;
import utils.MapJsonToModelUtil;
import utils.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/admin/news")
public class NewsAPIController extends HttpServlet {
    private INewsService newsService;

    public NewsAPIController() {
        this.newsService = new NewsService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");
        News news= MapJsonToModelUtil.of(req.getReader()).toModel(News.class);
        User user= (User) SessionUtil.getSessionUtilInstance().getValue(req,"MODEL");
//        news.setCreatedBy(user.getUserName());
        newsService.createdNews(news);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
