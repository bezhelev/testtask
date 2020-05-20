package com.bezhelev.controller;


import com.bezhelev.model.Customer;
import com.bezhelev.service.impl.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer/")
@Slf4j
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @GetMapping("{id}")
    public Customer get(@PathVariable long id) {
        log.info(String.format("CustomerController.get(). params: id: %d", id));
        return customerService.getEntity(id);
    }

    @PostMapping
    public Customer save(@RequestBody Customer customer) {
        log.info(String.format("CustomerController.save(). params: Customer: %s", customer));
        return customerService.saveEntity(customer);
    }

    @PutMapping("{id}")
    public Customer update(@PathVariable long id, @RequestBody Customer customer) {
        log.info(String.format("CustomerController.update(). params: Customer: %s", customer));
        return customerService.updateEntity(id, customer);
    }

    @DeleteMapping()
    public void delete(@RequestBody Customer customer) {
        log.info(String.format("CustomerController.save(). params: Customer: %s", customer));
        customerService.deleteEntity(customer);
    }

    @GetMapping("name/{name}")
    public Customer getByCustomer(@PathVariable String name) {
        log.info(String.format("CustomerController.getByCustomer(). params: name: %s", name));
        return customerService.getCustomerByName(name);
    }

    @GetMapping("company/{name}")
    public List<Customer> getByCompanyName(@PathVariable String name) {
        log.info(String.format("CustomerController.getByCompanyName(). params: name: %s", name));
        return customerService.getCustomersByCompanyName(name);
    }
}
