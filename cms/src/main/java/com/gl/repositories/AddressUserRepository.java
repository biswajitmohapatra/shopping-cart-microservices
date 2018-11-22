package com.gl.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gl.domain.Address;
import com.gl.domain.AddressUser;

/**
 * The Interface CustomerRepository.
 */
public interface AddressUserRepository extends MongoRepository<AddressUser, String> {
}
