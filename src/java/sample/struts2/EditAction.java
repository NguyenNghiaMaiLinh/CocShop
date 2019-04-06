/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import sample.daos.AccountDAO;
import sample.daos.ProductDAO;
import sample.dtos.AccountDTO;
import sample.dtos.ProductDTO;

/**
 *
 * @author Mai Linh
 */
public class EditAction {

    private String id;
    private String userID;
    private final String SUCCESS = "success";
    private final String INVALID = "invalid";
    private String lastNameValue;
    private String lastSearchValue;

    public EditAction() {
    }

    public String editFromAdmin() throws Exception {
        AccountDAO dao = new AccountDAO();
        if (dao.getRole(getUserID()).equals("admin")) {
            HttpServletRequest request = ServletActionContext.getRequest();
            AccountDTO dto = dao.findByPrimaryKey(getId());
            request.setAttribute("DTO", dto);
            return SUCCESS;
        } else {
            return INVALID;
        }
    }

    public String editFromSatff() throws Exception {
        AccountDAO accDao = new AccountDAO();
        if (accDao.getRole(getUserID()).equals("staff")) {
            HttpServletRequest request = ServletActionContext.getRequest();
            ProductDAO dao = new ProductDAO();
            ProductDTO dto = dao.findByPrimaryKey(getId());
            request.setAttribute("DTO", dto);
            return SUCCESS;
        } else {
            return INVALID;
        }
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
