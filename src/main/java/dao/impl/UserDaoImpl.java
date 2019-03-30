package dao.impl;

import dao.UserDAO;
import mapper.UserMapper;
import model.User;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.UIManager.get;

public class UserDaoImpl extends AbtractDao<User> implements UserDAO {


    public User findUserByUserNameAndPassword(String userName, String password) {
        String sql="SELECT*FROM user WhERE username=? AND password=?";
        List<User> list= new ArrayList<User>();
        list= query(sql,new UserMapper(),userName,password);
        return list.isEmpty()? null:list.get(0);
    }
}
