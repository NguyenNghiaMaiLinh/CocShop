/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import sample.dtos.CartObj;

/**
 *
 * @author Mai Linh
 */
public class RemoveCartAction {

    private String id;
    private final String SUCCESS = "success";

    public RemoveCartAction() {
    }

    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        CartObj cart = (CartObj) session.get("shoppingCart");
        cart.removeCart(id);
        session.put("shoppingCart", cart);
        return SUCCESS;
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

}
