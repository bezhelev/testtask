package com.bezhelev.service.impl;

import com.bezhelev.model.Customer;
import com.bezhelev.repository.CustomerRepository;
import com.bezhelev.service.AbstractCRUDService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class CustomerService extends AbstractCRUDService<Customer, Long> {

    public CustomerService(CustomerRepository customerRepository) {
        super(customerRepository);
    }

    @Override
    protected void updateFields(Customer oldEntity, Customer newEntity) {
        if (Objects.nonNull(newEntity.getName())) {
            oldEntity.setName(newEntity.getName());
        }
        if (newEntity.getAge() > 0) {
            oldEntity.setAge(newEntity.getAge());
        }
        if (Objects.nonNull(newEntity.getCompany())) {
            oldEntity.setCompany(newEntity.getCompany());
        }
    }

    public Customer getCustomerByName(String name) {
        log.info(String.format("Customer.getCustomerByName(), params: name = %s", name));
        Customer entity = null;
        if (Objects.nonNull(name)) {
            entity = ((CustomerRepository) getJpaRepository()).getByName(name);
        }
        return entity;
    }

    public List<Customer> getCustomersByCompanyName(String name) {
        log.info(String.format("Customer.getCustomerByName(), params: name = %s", name));
        List<Customer> entity = new ArrayList<>();
        if (Objects.nonNull(name)) {
            entity = ((CustomerRepository) getJpaRepository()).getAllByCompany_Name(name);
        }
        return entity;
    }


}
