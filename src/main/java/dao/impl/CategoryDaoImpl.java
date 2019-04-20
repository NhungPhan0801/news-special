package dao.impl;

import dao.ICategoryDAO;
import mapper.CategoryMapper;
import model.Category;

import java.util.List;

public class CategoryDaoImpl extends AbtractDao<Category> implements ICategoryDAO {
    @Override
    public List<Category> findAll() {
        String sql="SELECT*FORM category";
        return query(sql, new CategoryMapper());
    }
}
