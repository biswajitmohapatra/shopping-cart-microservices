package com.gl.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.domain.Customer;
import com.gl.repositories.CustomerRepository;

/**
 * The Class CustomerServiceImpl.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    /** The customer repository. */
    @Autowired
    private CustomerRepository customerRepository;

    /* (non-Javadoc)
     * @see com.gl.services.CustomerService#listAll()
     */
    @Override
    public List<Customer> listAll() {
        List<Customer> products = new ArrayList<>();
        customerRepository.findAll().forEach(products::add);
        return products;
    }

    /* (non-Javadoc)
     * @see com.gl.services.CustomerService#getById(java.lang.String)
     */
    @Override
    public Customer getById(String id) {
        return customerRepository.findById(id).orElse(null);
    }

    /* (non-Javadoc)
     * @see com.gl.services.CustomerService#saveOrUpdate(com.gl.domain.CustomerModel)
     */
    @Override
    public Customer saveOrUpdate(Customer product) {
        customerRepository.save(product);
        return product;
    }

    /* (non-Javadoc)
     * @see com.gl.services.CustomerService#delete(java.lang.String)
     */
    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }

}
