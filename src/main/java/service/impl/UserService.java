package service.impl;

import dao.IUserDAO;
import dao.impl.IUserDaoImpl;
import model.User;
import model.request.Auth;
import service.IUserService;

public class UserService implements IUserService {

    private IUserDAO dao = new IUserDaoImpl();
    public User findUserByUserNameAndPassword(Auth auth) {
        return dao.findUserByUserNameAndPassword(auth.getUserName(),auth.getPassword());
    }
}
