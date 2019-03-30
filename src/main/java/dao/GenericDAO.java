package dao;

import mapper.RowMapper;
import model.News;

import java.util.List;

public interface GenericDAO<T> {
    List<T> query(String  sql, RowMapper<T> rowMapper, Object...parameters);
    void insert(String sql,Object...parameters);
    void update(String sql,Object...parameters);

}
