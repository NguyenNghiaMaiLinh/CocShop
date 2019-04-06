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
public class CustomerDetailErrorObject implements Serializable {

    private String usernameErr, lastNameErr, middleNameErr, firstNameErr, addressErr, phoneErr;
    private String passwordErr, rolesErr, confirmErr;

    public CustomerDetailErrorObject() {
    }

    /**
     * @return the usernameErr
     */
    public String getUsernameErr() {
        return usernameErr;
    }

    /**
     * @param usernameErr the usernameErr to set
     */
    public void setUsernameErr(String usernameErr) {
        this.usernameErr = usernameErr;
    }

    /**
     * @return the lastNameErr
     */
    public String getLastNameErr() {
        return lastNameErr;
    }

    /**
     * @param lastNameErr the lastNameErr to set
     */
    public void setLastNameErr(String lastNameErr) {
        this.lastNameErr = lastNameErr;
    }

    /**
     * @return the middleNameErr
     */
    public String getMiddleNameErr() {
        return middleNameErr;
    }

    /**
     * @param middleNameErr the middleNameErr to set
     */
    public void setMiddleNameErr(String middleNameErr) {
        this.middleNameErr = middleNameErr;
    }

    /**
     * @return the firstNameErr
     */
    public String getFirstNameErr() {
        return firstNameErr;
    }

    /**
     * @param firstNameErr the firstNameErr to set
     */
    public void setFirstNameErr(String firstNameErr) {
        this.firstNameErr = firstNameErr;
    }

    /**
     * @return the addressErr
     */
    public String getAddressErr() {
        return addressErr;
    }

    /**
     * @param addressErr the addressErr to set
     */
    public void setAddressErr(String addressErr) {
        this.addressErr = addressErr;
    }

    /**
     * @return the phoneErr
     */
    public String getPhoneErr() {
        return phoneErr;
    }

    /**
     * @param phoneErr the phoneErr to set
     */
    public void setPhoneErr(String phoneErr) {
        this.phoneErr = phoneErr;
    }

    /**
     * @return the passwordErr
     */
    public String getPasswordErr() {
        return passwordErr;
    }

    /**
     * @param passwordErr the passwordErr to set
     */
    public void setPasswordErr(String passwordErr) {
        this.passwordErr = passwordErr;
    }

    /**
     * @return the rolesErr
     */
    public String getRolesErr() {
        return rolesErr;
    }

    /**
     * @param rolesErr the rolesErr to set
     */
    public void setRolesErr(String rolesErr) {
        this.rolesErr = rolesErr;
    }

    /**
     * @return the confirmErr
     */
    public String getConfirmErr() {
        return confirmErr;
    }

    /**
     * @param confirmErr the confirmErr to set
     */
    public void setConfirmErr(String confirmErr) {
        this.confirmErr = confirmErr;
    }

}
