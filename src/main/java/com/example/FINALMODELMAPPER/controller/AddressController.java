package com.example.FINALMODELMAPPER.controller;

import com.example.FINALMODELMAPPER.dto.AddressDto;
import com.example.FINALMODELMAPPER.model.Address;
import com.example.FINALMODELMAPPER.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/address")
    public List<Address> getAddress(){
        return addressService.getallAddress();
    }
    @PostMapping("/address")
    public void addAdress(@RequestBody AddressDto addressDto){
        addressService.addallAddress(addressDto);
    }

    @PutMapping("/address/{id}")
    public void updateadd(@RequestBody AddressDto address, @PathVariable int id) {
        addressService.updateAddress(address, id);
    }
    @DeleteMapping("/address/{id}")
    public  void deleteAdd(@PathVariable int id){
        addressService.deleteAdd(id);
    }
}
