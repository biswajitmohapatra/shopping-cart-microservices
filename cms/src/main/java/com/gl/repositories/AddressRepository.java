package com.gl.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gl.domain.Address;

/**
 * The Interface CustomerRepository.
 */
public interface AddressRepository extends MongoRepository<Address, String> {
    //List<Address> findByCustomerId(String name);
    
}
