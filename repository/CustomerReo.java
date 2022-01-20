package com.example.springboot.h2crud.springbootfirst.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.h2crud.springbootfirst.entity.Customer;

public interface CustomerReo extends JpaRepository<Customer, Long> {

}
