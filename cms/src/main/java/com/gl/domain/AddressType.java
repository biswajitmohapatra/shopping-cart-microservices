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
public class AddressType implements Serializable {
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6913860715808943920L;
    //Customer_address_type[address_type_id,name,status]-cms
    /** The id. */
    @Id
    private String addressTypeId;
    
    /** The first name. */
    private String name;
    
    /** The last name. */
    private String status;

    public AddressType(String addressTypeId, String name, String status) {
        super();
        this.addressTypeId = addressTypeId;
        this.name = name;
        this.status = status;
    }

    public String getAddressTypeId() {
        return addressTypeId;
    }

    public void setAddressTypeId(String addressTypeId) {
        this.addressTypeId = addressTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AddressType [addressTypeId=" + addressTypeId + ", name=" + name
                + ", status=" + status + "]";
    }
    
}
