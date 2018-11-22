package com.gl.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.domain.Address;
import com.gl.repositories.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> listAll() {
        List<Address> addresses = new ArrayList<>();
        addressRepository.findAll().forEach(addresses::add);
        return addresses;
    }

    @Override
    public Address getById(String id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public Address saveOrUpdate(Address address) {
        addressRepository.save(address);
        return address;
    }

    @Override
    public void delete(String id) {
        addressRepository.deleteById(id);
    }

}
