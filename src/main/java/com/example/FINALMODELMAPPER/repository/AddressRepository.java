package com.example.FINALMODELMAPPER.repository;

import com.example.FINALMODELMAPPER.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
