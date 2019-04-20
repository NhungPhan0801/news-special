package controller.web;

import model.request.Auth;
import security.Authentication;
import service.IRoleService;
import service.IUserService;
import service.impl.RoleService;
import service.impl.UserService;
import utils.FormUtil;
import utils.SessionUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login","/logout"})
public class AuthController extends HttpServlet {
    private IUserService userService;
    private IRoleService roleService;

    public AuthController(){
        this.userService = new UserService();
        this.roleService = new RoleService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");
        String action = req.getParameter("action");
        if (message != null) {
            if (message.equals("userNameOrPasswordInvalid"))
                req.setAttribute("message", "Tên Đăng nhập hoặc mật khẩu sai!");
            else if (message.equals("notPermission"))
                req.setAttribute("message", "ra đi!");
            else if (message.equals("notLogin"))
                req.setAttribute("message", "không vào được đâu");
        }
        if (action != null && action.equals("logout")) {
            SessionUtil.getSessionUtilInstance().removeValue(req,"MODEL");
            resp.sendRedirect("/home");
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/login.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Auth auth = FormUtil.mapToModel(Auth.class, req);
        String url = Authentication.newModel(auth.getUserName(),auth.getPassword()).urlRedirect(req);
        resp.sendRedirect(req.getContextPath() + url);

    }
}
