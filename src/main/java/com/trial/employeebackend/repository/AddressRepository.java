package com.trial.employeebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trial.employeebackend.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
