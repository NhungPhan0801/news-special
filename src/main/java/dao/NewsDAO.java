package dao;

import model.News;

import java.util.List;

public interface NewsDAO extends GenericDAO<News>{
    void inserNews(News news);
    void updateNews(Long id,News news);
    List<News> findAll();
    News findbyId(Long id);
    List<News>  findNewsByContent(String content);

}
