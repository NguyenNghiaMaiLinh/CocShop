/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dtos;

import java.io.Serializable;

/**
 *
 * @author Mai Linh
 */
public class ProductErrorObject implements Serializable {

    private String searchError;

    public ProductErrorObject() {
    }

    /**
     * @return the searchError
     */
    public String getSearchError() {
        return searchError;
    }

    /**
     * @param searchError the searchError to set
     */
    public void setSearchError(String searchError) {
        this.searchError = searchError;
    }

}
