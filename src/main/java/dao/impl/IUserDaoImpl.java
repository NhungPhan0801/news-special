package dao.impl;

import dao.IUserDAO;
import mapper.UserMapper;
import model.User;

import java.util.ArrayList;
import java.util.List;

import static javax.swing.UIManager.get;

public class IUserDaoImpl extends AbtractDao<User> implements IUserDAO {


    public User findUserByUserNameAndPassword(String userName, String password) {
        String sql="SELECT*FROM user WhERE username=? AND password=?";
        List<User> list = new ArrayList<User>();
        list = query(sql,new UserMapper(),userName,password);
        return list.isEmpty()? null:list.get(0);
    }
}
