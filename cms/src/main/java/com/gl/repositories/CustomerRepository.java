package com.gl.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gl.domain.Customer;

/**
 * The Interface CustomerRepository.
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {
    Customer findByLoginId(String loginId);
}
