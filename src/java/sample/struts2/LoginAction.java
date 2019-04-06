/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import sample.daos.AccountDAO;
import sample.daos.CustomerDAO;

/**
 *
 * @author Mai Linh
 */
public class LoginAction {

    private String username;
    private String password;
    private final String FAIL = "fail";
    private final String STAFF = "staff";
    private final String USER = "user";
    private final String ADMIN = "admin";
    private final String INVALID = "invalid";
    private final String SUCCESS = "success";

    public LoginAction() {
    }

    public String execute() throws Exception {
        AccountDAO dao = new AccountDAO();
        String check = dao.checkLogin(getUsername(), getPassword());
        String url = FAIL;
        HttpServletRequest request = ServletActionContext.getRequest();
        boolean valid = true;
        if (username.length() == 0) {
            valid = false;
            request.setAttribute("INVALIDUSERNAME", "username is not empty");
        }
        if (password.length() == 0) {
            valid = false;
            request.setAttribute("INVALIDPASSWORD", "password is not empty");
        }
        if (valid) {
            if (check.equals("user")) {
                Map session = ActionContext.getContext().getSession();
                CustomerDAO cusDAO = new CustomerDAO();
                session.put("USER", cusDAO.getName(getUsername()));
                session.put("USERID", getUsername());
                url = USER;
            } else if (check.equals("admin")) {
                Map session = ActionContext.getContext().getSession();
                CustomerDAO cusDAO = new CustomerDAO();
                session.put("USER", cusDAO.getName(getUsername()));
                session.put("USERID", getUsername());
                url = ADMIN;
            } else if (check.equals("staff")) {
                Map session = ActionContext.getContext().getSession();
                CustomerDAO cusDAO = new CustomerDAO();
                session.put("USER", cusDAO.getName(getUsername()));
                session.put("USERID", getUsername());
                url = STAFF;
            } else if (check.equals("failed")) {
                request.setAttribute("ERROR", "Invalid username or password!");
            }
        } else {
            url = INVALID;
        }
        return url;
    }

    public String logout() {
        Map session = ActionContext.getContext().getSession();
        session.remove("USER");
        session.remove("USERID");
        return SUCCESS;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
