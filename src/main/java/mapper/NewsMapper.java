package mapper;

import model.News;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsMapper implements RowMapper<News> {
    public News mapRow(ResultSet rs) {
        News news = new News();
        try {
            news.setId(rs.getLong("id"));

            if (rs.getString("censor") != null) {
                news.setCensor(rs.getString("censor"));
            }

            if (rs.getString("content") != null) {
                news.setContent(rs.getString("content"));

            }

            if (rs.getString("createdBy") != null) {
                news.setCreatedBy(rs.getString("createdBy"));
            }

            news.setCreatedDate(rs.getTimestamp("createdDate"));

            if (rs.getString("modifiedBy") != null) {
                news.setModifiedBy(rs.getString("modifiedBy"));
            }

            news.setModifiedDate(rs.getTimestamp("modifiedDate"));

            if (rs.getString("shortDescription") != null) {
                news.setShortDescription(rs.getString("shortDescription"));
            }

            if (rs.getString("status") != null) {
                news.setStatus(rs.getString("status"));
            }

            if (rs.getString("thumnail") != null) {
                news.setThumnail(rs.getString("thumnail"));
            }

            if (rs.getString("title") != null) {
                news.setTitle(rs.getString("title"));
            }

            news.setCategoryId(rs.getLong("categoryID"));

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return news;
    }
}
