package service;

import model.News;

public interface INewsService {
    void createdNews(News news);
    void update(Long id, News update);
}
