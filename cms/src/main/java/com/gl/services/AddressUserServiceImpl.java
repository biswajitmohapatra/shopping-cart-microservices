package com.gl.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.domain.AddressUser;
import com.gl.repositories.AddressUserRepository;

@Service
public class AddressUserServiceImpl implements AddressUserService {

    @Autowired
    private AddressUserRepository addressUserRepo;

    @Override
    public List<AddressUser> listAll() {
        List<AddressUser> addresses = new ArrayList<>();
        addressUserRepo.findAll().forEach(addresses::add);
        return addresses;
    }

    @Override
    public AddressUser getById(String id) {
        return addressUserRepo.findById(id).orElse(null);
    }

    @Override
    public AddressUser saveOrUpdate(AddressUser address) {
        addressUserRepo.save(address);
        return address;
    }

    @Override
    public void delete(String id) {
        addressUserRepo.deleteById(id);
    }

}
