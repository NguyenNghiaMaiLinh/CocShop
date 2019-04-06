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
import sample.dtos.AccountDTO;
import sample.dtos.CustomerDTO;
import sample.dtos.ProductDTO;

/**
 *
 * @author Mai Linh
 */
public class InsertAction {

    private String productID, productName, description, brand, quantity, price, status;
    private String username, lastName, middleName, firstName, address, phone;
    private String password;
    private String confirm;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    private final String INVALID = "invalid";

    public InsertAction() {
    }

    public String insertAccount() throws Exception {
        String url = FAIL;
        HttpServletRequest request = ServletActionContext.getRequest();
        boolean valid = true;

        if (username.length() == 0) {
            valid = false;
            request.setAttribute("INVALIDUSERNAME", "username can't blank!");
        }
        if (password.length() == 0) {
            valid = false;
            request.setAttribute("INVALIDPASSWORD", "password can't blank!");
        }
        if (!confirm.equals(password)) {
            valid = false;
            request.setAttribute("INVALIDCOMFIRM", "comfirm can't blank!");
        }
        if (lastName.length() == 0) {
            valid = false;
            request.setAttribute("INVALIDLASTNAME", "last name can't blank!");
        }
        if (middleName.length() == 0) {
            valid = false;
            request.setAttribute("INVALIDMIDDLENAME", "middle name can't blank!");
        }
        if (firstName.length() == 0) {
            valid = false;
            request.setAttribute("INVALIDFIRSTNAME", "first name can't blank!");
        }
        if (address.length() == 0) {
            valid = false;
            request.setAttribute("INVALIDADDRESS", "address can't blank!");
        }
        if (!phone.matches("[0-9]{10}")) {
            valid = false;
            request.setAttribute("INVALIDPHONE", "phone must 10 numbers");
        }
        if (valid) {
            CustomerDAO dao = new CustomerDAO();
            CustomerDTO dto = new CustomerDTO(getUsername(), getLastName(), getMiddleName(), getFirstName(), getAddress(), getPhone());
            if (dao.checkDuplicate(username)) {
                if (dao.insertCustomer(dto)) {
                    AccountDTO accDTO = new AccountDTO(getUsername(), getPassword());
                    AccountDAO accDAO = new AccountDAO();
                    if (accDAO.insertAccount(accDTO)) {
                        url = SUCCESS;
                    } else {
                        request.setAttribute("ERROR", "Insert failed!");
                    }
                } else {
                    request.setAttribute("ERROR", "Insert failed!");
                }
            } else {
                request.setAttribute("INVALIDUSERNAME", "username is existed!");
                url = INVALID;
            }
        } else {
            url = INVALID;
        }

        return url;
    }

    public String insertProduct() throws Exception {
        String url = FAIL;
        HttpServletRequest request = ServletActionContext.getRequest();
        boolean valid = true;
        if (productID.length() == 0) {
            valid = false;
            request.setAttribute("INVALIDPRODUCTID", "product ID can't be blank!");
        }
        if (productName.length() == 0) {
            valid = false;
            request.setAttribute("INVALIDPRODUCTNAME", "product Name can't be blank!");
        }
        if (description.length() == 0) {
            valid = false;
            request.setAttribute("INVALIDDESCRIPTION", "description can't be blank!");
        }
        if (brand.length() == 0) {
            valid = false;
            request.setAttribute("INVALIDBRAND", "brand can't be blank!");
        }
        if (!quantity.matches("[0-9]{1,10}")) {
            valid = false;
            request.setAttribute("INVALIDQUANTITY", "quantity is invalid! | 12");
        }
        if (!price.matches("([0-9]{1,10}.[0-9]{1,10})|[0-9]{1,10}")) {
            valid = false;
            request.setAttribute("INVALIDPRICE", "price is invalid! | 12.2");
        }
        if (valid) {

            ProductDTO dto = new ProductDTO(productID, productName, Integer.parseInt(quantity), status, description, brand, Float.parseFloat(price));
            ProductDAO dao = new ProductDAO();
            if (dao.checkDuplicate(productID)) {
                if (dao.insertProduct(dto)) {
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERROR", "Insert failed!");
                }
            } else {
                request.setAttribute("INVALIDPRODUCTID", "ID existed!");
                url = INVALID;
            }
        } else {
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
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @param middleName the middleName to set
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
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
     * @return the confirm
     */
    public String getConfirm() {
        return confirm;
    }

    /**
     * @param confirm the confirm to set
     */
    public void setConfirm(String confirm) {
        this.confirm = confirm;
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

}
