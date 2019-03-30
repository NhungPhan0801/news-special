package dao;

import model.User;

public interface UserDAO extends GenericDAO<User> {
    User findUserByUserNameAndPassword(String userName,String password);
}
