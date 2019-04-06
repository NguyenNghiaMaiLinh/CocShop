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
public class UpdateAction {

    private String productID,productName,description,brand,quantity,price,status;
    private String username, password, roles;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    private final String INVALID = "invalid";
    private String lastNameValue;
    private String lastSearchValue;

    private String userID;

    public UpdateAction() {
    }

    public String updateFromAdmin() throws Exception {
        AccountDAO dao = new AccountDAO();
        String url = FAIL;
        HttpServletRequest request = ServletActionContext.getRequest();
        boolean valid = true;
        if (password.length() < 8) {
            valid = false;
            request.setAttribute("INVALID", "password min legnth is 8 character");
        }
        if (valid) {
            AccountDTO dto = new AccountDTO(username, password, roles);
            if (dao.updateAccount(dto)) {
                url = SUCCESS;
                request.setAttribute("userID", userID);
                request.setAttribute("lastNameValue", lastNameValue);
            } else {
                request.setAttribute("ERROR", "Update is failed!");
            }
        } else {
            request.setAttribute("lastNameValue", lastNameValue);
            request.setAttribute("userID", userID);
            AccountDTO dto = dao.findByPrimaryKey(username);
            request.setAttribute("DTO", dto);
            url = INVALID;
        }

        return url;
    }

    public String updateFromStaff() throws Exception {
        String url = FAIL;
        HttpServletRequest request = ServletActionContext.getRequest();
        boolean valid = true;
        if (!quantity.matches("[0-9]{1,10}")) {
            valid = false;
            request.setAttribute("INVALIDQUANTITY", "quantity is invalid");
        }
        if (!price.matches("([0-9]{1,10}.[0-9]{1,10})|[0-9]{1,10}")) {
            valid = false;
            request.setAttribute("INVALIDPRICE", "price is invalid");
        }
        if (valid) {
            ProductDTO dto = new ProductDTO(productID, productName, Integer.parseInt(quantity), status, description, brand, Float.parseFloat(price));
            ProductDAO proDAO = new ProductDAO();
            if (proDAO.updateProduct(dto)) {
                request.setAttribute("lastSearchValue", lastSearchValue);
                request.setAttribute("userID", userID);
                url = SUCCESS;
            } else {
                request.setAttribute("ERROR", "Update is failed!");
            }
        } else {
            request.setAttribute("lastSearchValue", lastSearchValue);
            request.setAttribute("userID", userID);
            ProductDAO proDAO = new ProductDAO();
            ProductDTO dto = proDAO.findByPrimaryKey(productID);
            request.setAttribute("DTO", dto);
            url = INVALID;
        }

        return url;
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

    /**
     * @return the roles
     */
    public String getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(String roles) {
        this.roles = roles;
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
     * @return the productID
     */
    public String getProductID() {
        return productID;
    }

    /**
     * @param productID the productID to set
     */
    public void setProductID(String productID) {
        this.productID = productID;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the quantity
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
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
