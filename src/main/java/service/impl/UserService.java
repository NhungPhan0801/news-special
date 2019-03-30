package service.impl;

import dao.UserDAO;
import dao.impl.UserDaoImpl;
import model.User;
import model.request.Auth;
import service.IUserService;

public class UserService implements IUserService {

    private UserDAO dao = new UserDaoImpl();
    public User findUserByUserNameAndPassword(Auth auth) {
        return dao.findUserByUserNameAndPassword(auth.getUserName(),auth.getPassword());
    }
}
