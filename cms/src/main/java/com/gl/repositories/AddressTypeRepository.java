package com.gl.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gl.domain.AddressType;

/**
 * The Interface CustomerRepository.
 */
public interface AddressTypeRepository extends MongoRepository<AddressType, String> {
    
    List<AddressType> findByName(String name);
}
