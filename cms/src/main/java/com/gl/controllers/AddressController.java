package com.gl.controllers;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gl.domain.Address;
import com.gl.domain.AddressType;
import com.gl.domain.AddressUser;
import com.gl.domain.AddressUserV1;
import com.gl.repositories.AddressTypeRepository;
import com.gl.services.AddressService;
import com.gl.services.AddressUserService;
import com.gl.util.CMSConstant;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;
    
    @Autowired
    private AddressUserService addressUserService;
    
    @Autowired
    private AddressTypeRepository addressTypeRepo;

    @GetMapping(CMSConstant.GET_ALL_ADDRESS_URI)
    public ResponseEntity<List<Address>> listCustomers() {
        return new ResponseEntity<>(addressService.listAll(), HttpStatus.OK);
    }

    @GetMapping(CMSConstant.ADDRESS_URI)
    public ResponseEntity<Address>
           getCustomer(@PathVariable String id) {
        ResponseEntity<Address> responseEntity;
        Address address = addressService.getById(id);
        if (ObjectUtils.isEmpty(address)) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        responseEntity = new ResponseEntity<>(address, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("/address/customer/{customerId}/addressType/{addressType}")
    public ResponseEntity<AddressUserV1> save(
            @RequestBody Address address,
            @PathVariable String customerId, @PathVariable String addressType) {
        
        List<AddressType> addressTypeDb = addressTypeRepo.findByName(addressType);
        if (ObjectUtils.isEmpty(addressTypeDb)) {
            addressTypeDb = Arrays.asList(new AddressType("1", "HOME", "Y"));
        }
        address.setAddressType(addressTypeDb.get(0).getName());
        address.setCreatedDate(new Date());
        address.setUpdatedDate(new Date());
        address.setCreatedBy("admin");
        address.setUpdatedBy("admin");
   
        Address savedAddress = addressService.saveOrUpdate(address);
        
        AddressUser addressUser = new AddressUser(savedAddress.getAddressId(), customerId, address.getAddressType());
        addressUserService.saveOrUpdate(addressUser);
        
        AddressUserV1 addressUserRes = new AddressUserV1();
        addressUserRes.setAddress(savedAddress);
        addressUserRes.setAddressUserId(addressUser.getAddressUserId());
        addressUserRes.setCustomerId(addressUser.getCustomerId());
        return new ResponseEntity<>(addressUserRes, HttpStatus.OK);
    }
    
    @PutMapping("/address")
    public ResponseEntity<Address> update(
            @RequestBody Address address) {
        Address addressDb = addressService.getById(address.getAddressId());
        if (ObjectUtils.isEmpty(addressDb)) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        
        List<AddressType> addressTypeDb = addressTypeRepo.findByName(address.getAddressType());
        if (ObjectUtils.isEmpty(addressTypeDb)) {
            addressTypeDb = Arrays.asList(new AddressType("1", "HOME", "Y"));
        }
        address.setAddressType(addressTypeDb.get(0).getName());
        address.setUpdatedDate(new Date());
        address.setUpdatedBy("admin");
        Address savedAddress = addressService.saveOrUpdate(address);
        return new ResponseEntity<>(savedAddress, HttpStatus.OK);
    }

    @DeleteMapping(CMSConstant.ADDRESS_URI)
    public ResponseEntity<String> delete(@PathVariable String id) {
        addressService.delete(id);
        return new ResponseEntity<>("DELETED", HttpStatus.OK);
    }

}
