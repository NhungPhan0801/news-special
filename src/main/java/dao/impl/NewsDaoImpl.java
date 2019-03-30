package dao.impl;

import dao.GenericDAO;
import dao.NewsDAO;
import mapper.NewsMapper;
import model.News;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsDaoImpl extends AbtractDao<News> implements NewsDAO {

    public void inserNews(News news) {
        String sql = "INSERT INTO news(title, shortDescription, content, createdBy, " +
                "createdDate, thumnail," +
                " status, categoryID) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        insert(
                sql, news.getTitle(), news.getShortDescription(), news.getContent(),
                news.getCreatedBy(), news.getCreatedDate(),
                news.getThumnail(), news.getStatus(),
                news.getCategoryId());
    }

    public void updateNews(Long id,News news) {
        String sql="UPDATE news SET title=?,shortDescription=?,content=?,\n" +
                "                createdBy=?,createdDate=?,modifiedBy=?,\n" +
                "                censor=?,thumnail=?,categoryID=?,\n" +
                "                modifiedDate=? WHERE id=?";
        update(
                sql,news.getTitle(), news.getShortDescription(), news.getContent(),
                news.getCreatedBy(), news.getCreatedDate(), news.getModifiedBy(),
                news.getCensor(), news.getThumnail(),
                news.getCategoryId(), news.getModifiedDate(),news.getId());

    }

    public List<News> findAll() {
        String sql = "SELECT * FROM news";
        return query(sql, new NewsMapper());
    }

    public News findbyId(Long id) {
        String sql="Select* from news where id=?";
        List<News> list= new ArrayList<News>();
        list= query(sql,new NewsMapper(),id);
        return list.isEmpty()? null:list.get(0);
    }

    public List<News> findNewsByContent(String content) {
        String sql="SELECT*FROM news WHERE content LIKE ?";
        List<News> list= query(sql,new NewsMapper(),"%"+ content+"%");
        return list;
    }

    public static void main(String[] args) {
        NewsDAO newsDao = new NewsDaoImpl();
//        List<News> newsList= newsDao.findAll();
//        for (News news:newsList) {
//            System.out.println(news);
//        }





/*
        News  news = new News();
        news.setId(4L);
        news.setTitle("a");
        news.setShortDescription("nhungxinhgai");
        news.setContent("aaa");
        news.setCensor("nana");
        news.setThumnail("haha");
        news.setStatus("aabb");
        news.setCreatedBy("ccdd");
        news.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        news.setCategoryId(1L);
        news.setModifiedBy("xxxxx");
        news.setModifiedDate(new Timestamp(System.currentTimeMillis()));
//        newsDao.inserNews(news);
        newsDao.updateNews(4L,news);

*/
    }

}

