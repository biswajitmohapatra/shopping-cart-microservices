package com.gl.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gl.domain.Customer;
import com.gl.domain.LoginForm;
import com.gl.services.CustomerService;
import com.gl.util.CMSConstant;

/**
 * The Class CustomerController.
 */
@RestController
public class CustomerController {

    private static final String AUTHENTICATED = "Authenticated";
    private static final String AUTHENTICATION_FAILED = "Authentication Failed";
    private static final String ADMIN_PWD = "password";
    private static final String USERNAME_ADMIN = "admin";
    /** The customer service. */
    @Autowired
    private CustomerService customerService;

    /**
     * List customers.
     *
     * @return the list
     */
    @GetMapping(CMSConstant.GET_ALL_CUSTOMER_URI)
    public ResponseEntity<List<Customer>> listCustomers() {
        return new ResponseEntity<>(customerService.listAll(), HttpStatus.OK);
    }

    /**
     * Gets the customer.
     *
     * @param id
     *            the id
     * @return the customer
     */
    @GetMapping(CMSConstant.CUSTOMER_URI)
    public ResponseEntity<Customer> getCustomer(@PathVariable String id) {
        ResponseEntity<Customer> responseEntity;
        Customer customer = customerService.getById(id);
        if (ObjectUtils.isEmpty(customer)) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        responseEntity = new ResponseEntity<>(customer, HttpStatus.OK);
        return responseEntity;
    }

    @Autowired 
    private PasswordEncoder encoder; 
    /**
     * Save.
     *
     * @param customerModel
     *            the customer model
     * @return the customer model
     */
    @PostMapping(CMSConstant.GET_ALL_CUSTOMER_URI)
    public ResponseEntity<Customer>
           save(@RequestBody Customer customerModel) {
        System.out.println("1 pwd: " + customerModel.getPassword());
        String demoPasswordEncoded = encoder.encode(customerModel.getPassword());
        System.out.println("2 demoPasswordEncoded: " + demoPasswordEncoded);
        customerModel.setPassword(demoPasswordEncoded);
        Customer savedCustomer = customerService
                .saveOrUpdate(customerModel);
        System.out.println("Saved Product Id: " + savedCustomer.getCustomerId());
        return new ResponseEntity<>(savedCustomer, HttpStatus.OK);
    }

    /**
     * Delete.
     *
     * @param id
     *            the id
     * @return the string
     */
    @DeleteMapping(CMSConstant.CUSTOMER_URI)
    public ResponseEntity<String> delete(@PathVariable String id) {
        customerService.delete(id);
        return new ResponseEntity<>("DELETED", HttpStatus.OK);
    }

    @PostMapping(CMSConstant.LOGIN_URI)
    public ResponseEntity<String> login(@RequestBody LoginForm form) {
        if (!ObjectUtils.isEmpty(form) && USERNAME_ADMIN.equals(form.getUsername())
                && ADMIN_PWD.equals(form.getPassword())) {
            return new ResponseEntity<>(AUTHENTICATED, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(AUTHENTICATION_FAILED,
                    HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping(CMSConstant.REGISTER_URI)
    public ResponseEntity<String> register(@RequestBody LoginForm form) {
        // name last name email, pwd , confirm pwd
        if (!ObjectUtils.isEmpty(form) && USERNAME_ADMIN.equals(form.getUsername())
                && ADMIN_PWD.equals(form.getPassword())) {
            return new ResponseEntity<>(AUTHENTICATED, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(AUTHENTICATION_FAILED,
                    HttpStatus.UNAUTHORIZED);
        }
    }
}
