package com.gl.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The Class Customer.
 * 
 * @author amit.gupta7
 */
@Document
public class AddressUser implements Serializable {
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6913860715808943920L;
    /** The id. */
    @Id
    private String addressUserId;
    //Address_user[address_user_id,address_id,customer_id,address_type_id,last_used,created_date,updated_date]-cms
    private String addressId;
    /** The login id. */
    private String customerId;
    
    private String addressTypeId;
    
    private Long createdDate;
    
    /** The created date. */
    private Long lastUsedDate;
    
    /** The updated date. */
    private Long updatedDate;
    
    /** The created by. */
    private String createdBy;
    
    /** The updated by. */
    private String updatedBy;

    public AddressUser(String addressId,
            String customerId, String addressTypeId) {
        super();
        this.addressId = addressId;
        this.customerId = customerId;
        this.addressTypeId = addressTypeId;
    }

    public String getAddressUserId() {
        return addressUserId;
    }

    public void setAddressUserId(String addressUserId) {
        this.addressUserId = addressUserId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public Long getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Long updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getAddressTypeId() {
        return addressTypeId;
    }

    public void setAddressTypeId(String addressTypeId) {
        this.addressTypeId = addressTypeId;
    }

    public Long getLastUsedDate() {
        return lastUsedDate;
    }

    public void setLastUsedDate(Long lastUsedDate) {
        this.lastUsedDate = lastUsedDate;
    }
    
}
