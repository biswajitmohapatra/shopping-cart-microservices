package com.gl.services;

import java.util.List;

import com.gl.domain.Customer;

/**
 * The Interface CustomerService.
 */
public interface CustomerService {

    /**
     * List all.
     *
     * @return the list
     */
    List<Customer> listAll();

    /**
     * Gets the by id.
     *
     * @param id the id
     * @return the by id
     */
    Customer getById(String id);

    /**
     * Save or update.
     *
     * @param product the product
     * @return the customer model
     */
    Customer saveOrUpdate(Customer product);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(String id);

}
