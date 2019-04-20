package dao.impl;

import dao.INewsDAO;
import mapper.NewsMapper;
import model.News;

import java.util.ArrayList;
import java.util.List;

public class NewsDaoImpl extends AbtractDao<News> implements INewsDAO {

    public void insertNews(News news) {
        String sql = "INSERT INTO news(title, shortDescription, content, createdBy, " +
                "createdDate, thumbnail," +
                " status, categoryID) VALUES (?,?,?,?,?,?,?,?)";
        insert(
                sql, news.getTitle(), news.getShortDescription(), news.getContent(),
                news.getCreatedBy(), news.getCreatedDate(),
                news.getThumbnail(), news.getStatus(),
                news.getCategoryID());
    }

    public void updateNews(Long id,News news) {
        String sql="UPDATE news SET title=?,shortDescription=?,content=?,\n" +
                "                createdBy=?,createdDate=?,modifiedBy=?,\n" +
                "                censor=?,thumbnail=?,categoryID=?,\n" +
                "                modifiedDate=? WHERE id=?";
        update(
                sql,news.getTitle(), news.getShortDescription(), news.getContent(),
                news.getCreatedBy(), news.getCreatedDate(), news.getModifiedBy(),
                news.getCensor(), news.getThumbnail(),
                news.getCategoryID(), news.getModifiedDate(),news.getId());

    }

    public List<News> findAll() {
        String sql = "SELECT * FROM news";
        return query(sql, new NewsMapper());
    }

    public News findById(Long id) {
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
        INewsDAO INewsDao = new NewsDaoImpl();
//        List<News> newsList= INewsDao.findAll();
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
        news.setThumbnail("haha");
        news.setStatus("aabb");
        news.setCreatedBy("ccdd");
        news.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        news.setCategoryID(1L);
        news.setModifiedBy("xxxxx");
        news.setModifiedDate(new Timestamp(System.currentTimeMillis()));
//        INewsDao.inserNews(news);
        INewsDao.updateNews(4L,news);

*/
    }

}

