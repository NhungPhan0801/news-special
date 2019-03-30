package security.impl;

import model.Role;
import model.User;
import model.request.Auth;
import security.Authentication;
import service.IRoleService;
import service.IUserService;
import service.impl.RoleService;
import service.impl.UserService;

public class AuthenticationImpl implements Authentication {
    private String userName;
    private String password;
    private IUserService userService;
    private IRoleService roleService;


    public AuthenticationImpl(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.userService = new UserService();
        this.roleService = new RoleService();
    }


    @Override
    public String urlRedirect() {
        User user = userService.findUserByUserNameAndPassword(new Auth(userName,password));
        if (user!=null){
            Role role= roleService.findRoleById(user.getRoleId());
            if (role.getRoleName().equals("ADMIN")){
               return "/admin";
            }else if(role.getRoleName().equals("USER")){
                return "/home";
            }
        }else{

            return "/login?message=userNameOrPasswordInvalist";
        }
        return null;
    }
}
