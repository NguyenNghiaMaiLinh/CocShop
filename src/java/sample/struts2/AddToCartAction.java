/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import sample.daos.AccountDAO;
import sample.dtos.CartObj;
import sample.dtos.ProductDTO;

/**
 *
 * @author Mai Linh
 */
public class AddToCartAction {

    private String prodID;
    private String userID;
    private String prodName;
    private String prodPrice;
    private String lastSearchValue;
    private final String SUCCESS = "success";
    private final String INVALID = "invalid";
    private final String FAIL = "fail";

    public AddToCartAction() {
    }

    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        AccountDAO dao = new AccountDAO();
        String url = FAIL;
        if (dao.getRole(getUserID()).equals("user")) {
            CartObj cart = (CartObj) session.get("shoppingCart");
            if (cart == null) {
                cart = new CartObj(getUserID());
            }
            ProductDTO dto = new ProductDTO(getProdID(), getProdName(), 1, Float.parseFloat(getProdPrice()));
            cart.addToCart(dto);
            session.put("shoppingCart", cart);
            url = SUCCESS;
        } else {
            url = INVALID;
        }
        return url;
    }

    /**
     * @return the prodID
     */
    public String getProdID() {
        return prodID;
    }

    /**
     * @param prodID the prodID to set
     */
    public void setProdID(String prodID) {
        this.prodID = prodID;
    }

    /**
     * @return the prodName
     */
    public String getProdName() {
        return prodName;
    }

    /**
     * @param prodName the prodName to set
     */
    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    /**
     * @return the prodPrice
     */
    public String getProdPrice() {
        return prodPrice;
    }

    /**
     * @param prodPrice the prodPrice to set
     */
    public void setProdPrice(String prodPrice) {
        this.prodPrice = prodPrice;
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
