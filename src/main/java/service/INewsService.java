package service;

import model.News;

import java.util.List;

public interface INewsService {
    void createdNews(News news);
    void update(Long id, News update);
    News findOneById(long id);
    List<News> findAll();
}
