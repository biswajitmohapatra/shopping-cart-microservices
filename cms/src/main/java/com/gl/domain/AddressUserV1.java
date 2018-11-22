package com.gl.domain;

import java.io.Serializable;

/**
 * The Class Customer.
 * 
 * @author amit.gupta7
 */
public class AddressUserV1 implements Serializable {
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6913860715808943920L;
    /** The id. */
    private String addressUserId;

    private String customerId;
    
    private Address address;
    
    public Address getAddress() {
        return address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
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

}
