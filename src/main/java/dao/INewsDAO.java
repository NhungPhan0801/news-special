package dao;

import model.News;

import java.util.List;

public interface INewsDAO extends GenericDAO<News>{
    void insertNews(News news);
    void updateNews(Long id,News news);
    List<News> findAll();
    News findById(Long id);
    List<News>  findNewsByContent(String content);

}
