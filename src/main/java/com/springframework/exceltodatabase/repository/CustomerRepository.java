package com.springframework.exceltodatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springframework.exceltodatabase.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
        
}
