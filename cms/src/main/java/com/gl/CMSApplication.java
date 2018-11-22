package com.gl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gl.domain.AddressType;
import com.gl.repositories.AddressTypeRepository;

/**
 * The Class CMSApplication.
 */
@SpringBootApplication
public class CMSApplication implements CommandLineRunner {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(CMSApplication.class, args);
    }

    @Autowired
    private AddressTypeRepository addressTypeRepo;

    @Override
    public void run(String... args) throws Exception {
        addressTypeRepo.deleteAll();

        addressTypeRepo.save(new AddressType("1", "HOME", "Y"));
        addressTypeRepo.save(new AddressType("2", "WORK", "Y"));
        addressTypeRepo.save(new AddressType("3", "TEMP", "N"));
        
        /*System.out.println("==========Fetch aLL companies:==========");
        List<AddressType> addressTypes = addressTypeRepo.findAll();
        addressTypes.forEach(System.out::println);
*/
    }
}
