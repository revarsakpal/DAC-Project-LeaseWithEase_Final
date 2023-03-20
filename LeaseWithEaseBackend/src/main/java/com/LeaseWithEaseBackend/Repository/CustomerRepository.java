package com.LeaseWithEaseBackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LeaseWithEaseBackend.Model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
