/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2;

import java.util.List;
import sample.daos.AccountDAO;
import sample.daos.CustomerDetailDAO;
import sample.daos.ProductDAO;
import sample.dtos.CustomerDetailDTO;
import sample.dtos.ProductDTO;

/**
 *
 * @author Mai Linh
 */
public class SearchAction {

    private String nameValue;
    private String userID;
    private String searchValue;
    private List<ProductDTO> result;
    private List<CustomerDetailDTO> getListAccounts;
    private final String SUCCESS = "success";
    private final String INVALID = "invalid";

    public SearchAction() {
    }

    public String searchFromUser() throws Exception {
        ProductDAO dao = new ProductDAO();
        result = dao.searchByName(searchValue);
        return SUCCESS;
    }

    public String searchFromAdmin() throws Exception {
        AccountDAO accDAO = new AccountDAO();
        if (accDAO.getRole(userID).equals("admin")) {
            CustomerDetailDAO dao = new CustomerDetailDAO();
            getListAccounts = dao.getListAccount(nameValue);
            return SUCCESS;
        } else {
            return INVALID;
        }
    }

    public String searchFromStaff() throws Exception {
        AccountDAO accDAO = new AccountDAO();
        if (accDAO.getRole(userID).equals("staff")) {
            ProductDAO dao = new ProductDAO();
            result = dao.searchFromStaff(searchValue);
            return SUCCESS;
        } else {
            return INVALID;
        }
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public List<ProductDTO> getResult() {
        return result;
    }

    /**
     * @return the nameValue
     */
    public String getNameValue() {
        return nameValue;
    }

    /**
     * @param nameValue the nameValue to set
     */
    public void setNameValue(String nameValue) {
        this.nameValue = nameValue;
    }

    /**
     * @return the getListAccounts
     */
    public List<CustomerDetailDTO> getGetListAccounts() {
        return getListAccounts;
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

}
