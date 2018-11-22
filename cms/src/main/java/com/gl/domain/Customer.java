package com.gl.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class Customer.
 * 
 * @author amit.gupta7
 */
@Document
public class Customer implements Serializable {
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6913860715808943920L;
    
    /** The id. */
    @Id
    private String customerId;
    
    /** The login id. */
    private String loginId;
    
    /** The first name. */
    private String name;
    
    /** The last name. */
    private String password;
    
    /** The email id. */
    private String emailId;
    
    /** The gender. */
    private String gender;
    
    /** The last login. */
    private Long lastLogin;

    /** The login failures. */
    private int loginFailures;
    
    /** The is enabled. */
    private boolean isEnabled;
    
    /** The created date. */
    private Long createdDate;
    
    /** The updated date. */
    private Long updatedDate;
    
    /** The created by. */
    private String createdBy;
    
    /** The updated by. */
    private String updatedBy;
    
    /** The cart info. */
    private String cartInfo;//TODO update this

    
    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    @JsonIgnore
    @JsonProperty(value = "password")
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the email id.
     *
     * @return the email id
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * Sets the email id.
     *
     * @param emailId the new email id
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    /**
     * Gets the gender.
     *
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender.
     *
     * @param gender the new gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets the last login.
     *
     * @return the last login
     */
    public Long getLastLogin() {
        return lastLogin;
    }

    /**
     * Sets the last login.
     *
     * @param lastLogin the new last login
     */
    public void setLastLogin(Long lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     * Gets the login failures.
     *
     * @return the login failures
     */
    public int getLoginFailures() {
        return loginFailures;
    }

    /**
     * Sets the login failures.
     *
     * @param loginFailures the new login failures
     */
    public void setLoginFailures(int loginFailures) {
        this.loginFailures = loginFailures;
    }

    /**
     * Checks if is enabled.
     *
     * @return true, if is enabled
     */
    public boolean isEnabled() {
        return isEnabled;
    }

    /**
     * Sets the enabled.
     *
     * @param isEnabled the new enabled
     */
    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    /**
     * Gets the created date.
     *
     * @return the created date
     */
    public Long getCreatedDate() {
        return createdDate;
    }

    /**
     * Sets the created date.
     *
     * @param createdDate the new created date
     */
    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Gets the updated date.
     *
     * @return the updated date
     */
    public Long getUpdatedDate() {
        return updatedDate;
    }

    /**
     * Sets the updated date.
     *
     * @param updatedDate the new updated date
     */
    public void setUpdatedDate(Long updatedDate) {
        this.updatedDate = updatedDate;
    }

    /**
     * Gets the created by.
     *
     * @return the created by
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets the created by.
     *
     * @param createdBy the new created by
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Gets the updated by.
     *
     * @return the updated by
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * Sets the updated by.
     *
     * @param updatedBy the new updated by
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * Gets the cart info.
     *
     * @return the cart info
     */
    public String getCartInfo() {
        return cartInfo;
    }

    /**
     * Sets the cart info.
     *
     * @param cartInfo the new cart info
     */
    public void setCartInfo(String cartInfo) {
        this.cartInfo = cartInfo;
    }

    /**
     * Gets the customer id.
     *
     * @return the customer id
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Sets the customer id.
     *
     * @param customerId the new customer id
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets the login id.
     *
     * @return the login id
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * Sets the login id.
     *
     * @param loginId the new login id
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    
    
}
