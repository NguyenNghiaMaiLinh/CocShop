/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import sample.daos.AccountDAO;
import sample.daos.CustomerDAO;
import sample.daos.ProductDAO;

/**
 *
 * @author Mai Linh
 */
public class DeleteAction {

    private String id;
    private String userID;
    private String lastNameValue;
    private String lastSearchValue;
    private final String FAIL = "fail";
    private final String SUCCESS = "success";
    private final String INVALID = "invalid";

    public DeleteAction() {
    }

    public String deleteFromAdmin() throws Exception {
        CustomerDAO dao = new CustomerDAO();
        String url = FAIL;
        HttpServletRequest request = ServletActionContext.getRequest();
        AccountDAO accDao = new AccountDAO();
        if (accDao.getRole(getUserID()).equals("admin")) {
            if (dao.deleteAccount(id)) {
                if (dao.deleteCustomer(id)) {
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERROR", "Delete failed!");
                }
            } else {
                request.setAttribute("ERROR", "Delete failed!");
            }

        } else {
            url = INVALID;
        }
        return url;
    }

    public String deleteFromStaff() throws Exception {
        ProductDAO dao = new ProductDAO();
        String url = FAIL;
        HttpServletRequest request = ServletActionContext.getRequest();
        AccountDAO accDao = new AccountDAO();
        if (accDao.getRole(getUserID()).equals("staff")) {
            if (dao.deleteProduct(id)) {
                url = SUCCESS;
            } else {
                request.setAttribute("ERROR", "Delete failed!");
            }
        } else {
            url = INVALID;
        }
        return url;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the lastNameValue
     */
    public String getLastNameValue() {
        return lastNameValue;
    }

    /**
     * @param lastNameValue the lastNameValue to set
     */
    public void setLastNameValue(String lastNameValue) {
        this.lastNameValue = lastNameValue;
    }

    /**
     * @return the userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * @return the lastSearchValue
     */
    public String getLastSearchValue() {
        return lastSearchValue;
    }

    /**
     * @param lastSearchValue the lastSearchValue to set
     */
    public void setLastSearchValue(String lastSearchValue) {
        this.lastSearchValue = lastSearchValue;
    }

}
