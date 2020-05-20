package com.bezhelev.repository;

import com.bezhelev.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer getByName(String name);

    List<Customer> getAllByCompany_Name(String name);

}
