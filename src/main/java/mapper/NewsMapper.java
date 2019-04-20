package mapper;

import model.News;
import utils.MapperUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsMapper implements RowMapper<News> {
    public News mapRow(ResultSet rs) {
        return MapperUtil.map(new News(),rs);
    }
}
