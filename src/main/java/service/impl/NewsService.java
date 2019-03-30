package service.impl;

import dao.NewsDAO;
import dao.impl.NewsDaoImpl;
import model.News;
import service.INewsService;

import java.sql.Timestamp;

public class NewsService implements INewsService {
    private NewsDAO newsDAO;

    public NewsService(){
        this.newsDAO=new NewsDaoImpl();
    }

    public void createdNews(News news) {
        news.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        news.setCreatedBy("");
        newsDAO.inserNews(news);

    }

    public void update(Long id, News update) {
        News oldNews=newsDAO.findbyId(id);
        update.setCreatedDate(oldNews.getCreatedDate());
        update.setCreatedBy(oldNews.getCreatedBy());
        update.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        update.setModifiedBy("");
        newsDAO.updateNews(id, update);
    }
}
