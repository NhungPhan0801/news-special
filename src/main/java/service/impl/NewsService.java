package service.impl;

import dao.INewsDAO;
import dao.impl.NewsDaoImpl;
import model.News;
import service.INewsService;

import java.sql.Timestamp;
import java.util.List;

public class NewsService implements INewsService {
    private INewsDAO INewsDAO;

    public NewsService(){
        this.INewsDAO =new NewsDaoImpl();
    }

    public void createdNews(News news) {
        news.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        news.setCreatedBy("");
        INewsDAO.insertNews(news);

    }

    public void update(Long id, News update) {
        News oldNews= INewsDAO.findById(id);
        update.setCreatedDate(oldNews.getCreatedDate());
        update.setCreatedBy(oldNews.getCreatedBy());
        update.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        update.setModifiedBy("");
        INewsDAO.updateNews(id, update);
    }

    @Override
    public News findOneById(long id) {
        return INewsDAO.findById(id);
    }


    @Override
    public List<News> findAll() {
        return INewsDAO.findAll();
    }
}
