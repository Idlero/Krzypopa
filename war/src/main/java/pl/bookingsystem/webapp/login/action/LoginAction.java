package pl.bookingsystem.webapp.login.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;
import pl.bookingsystem.db.dao.UserDAO;
import pl.bookingsystem.db.dao.impl.UserDAOImpl;
import pl.bookingsystem.db.entity.Address;
import pl.bookingsystem.db.entity.User;

import java.util.Map;


@Namespace("/")
@ResultPath(value = "/")
public class LoginAction extends ActionSupport implements SessionAware, ApplicationAware {

    private Map<String, Object> application;

    private String username;
    private String password;
    private Map<String, Object> session;

    @Action(value = "dashboard", results = {
            @Result(name = "userlogged", location = "/modules/user/pages/dashboard.jsp"),
            @Result(name = "adminlogged", location = "/modules/admin/pages/dashboard.jsp"),
            @Result(name = "error", location = "/modules/login/pages/register_user.jsp")
    })
    public String execute() {

        UserDAO userManager = new UserDAOImpl();

        User.Type userType = userManager.checkRegisteredUser(username, password);
        if (User.Type.ADMIN.equals(userType)) {
            session.put("username", getUsername());
            return "adminlogged";
        } else if (User.Type.EMPLOYEE.equals(userType)) {
            session.put("username", getUsername());
            return "userlogged";
        }
        return ERROR;
    }


    @Action(value = "logout", results = {
            @Result(name = "success", location = "/modules/login/pages/logout.jsp")
    })
    public String logout() {
        setUsername("");
        setPassword("");
        session.put("username", "");
        application.put("username", "");
        application.put("password", "");
        return SUCCESS;
    }

    @Action(value = "login", results = {
            @Result(name = "success", location = "/modules/login/pages/login.jsp")
    })
    public String goToLogin() {
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setApplication(Map<String, Object> application) {
        this.application = application;

    }
}