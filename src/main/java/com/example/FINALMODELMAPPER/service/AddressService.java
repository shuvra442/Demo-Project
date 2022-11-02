package com.example.FINALMODELMAPPER.service;

import com.example.FINALMODELMAPPER.dto.AddressDto;
import com.example.FINALMODELMAPPER.model.Address;
import com.example.FINALMODELMAPPER.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getallAddress(){
        return addressRepository.findAll();
    }

    public void addallAddress(AddressDto addressDto){
        Address address = new Address();
        address.setCity(addressDto.getCity());
        address.setState(addressDto.getState());
        addressRepository.save(address);
    }

    public void updateAddress(AddressDto address,int id){
        Address data=addressRepository.findById(id).orElse(null);
        assert data!=null;
        data.setCity(address.getCity());

        addressRepository.save(data);
    }

    public void deleteAdd(int id){
        addressRepository.deleteById(id);
    }
}
