package com.gl.services;

import java.util.List;

import com.gl.domain.Address;
import com.gl.domain.AddressUser;
import com.gl.domain.Address;

/**
 * The Interface CustomerService.
 */
public interface AddressUserService {

    /**
     * List all.
     *
     * @return the list
     */
    List<AddressUser> listAll();

    /**
     * Gets the by id.
     *
     * @param id the id
     * @return the by id
     */
    AddressUser getById(String id);

    /**
     * Save or update.
     *
     * @param product the product
     * @return the customer model
     */
    AddressUser saveOrUpdate(AddressUser product);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(String id);

}
