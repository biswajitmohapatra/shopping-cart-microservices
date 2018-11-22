package com.gl.services;

import java.util.List;

import com.gl.domain.Address;
import com.gl.domain.Address;

/**
 * The Interface CustomerService.
 */
public interface AddressService {

    /**
     * List all.
     *
     * @return the list
     */
    List<Address> listAll();

    /**
     * Gets the by id.
     *
     * @param id the id
     * @return the by id
     */
    Address getById(String id);

    /**
     * Save or update.
     *
     * @param product the product
     * @return the customer model
     */
    Address saveOrUpdate(Address product);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(String id);

}
