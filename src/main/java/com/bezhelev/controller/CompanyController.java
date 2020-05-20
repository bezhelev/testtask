package com.bezhelev.controller;

import com.bezhelev.model.Company;
import com.bezhelev.service.impl.CompanyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("company/")
@Slf4j
@AllArgsConstructor
public class CompanyController {

    private CompanyService companyService;

    @GetMapping("{id}")
    public Company get(@PathVariable long id) {
        log.info(String.format("CompanyController.get(). params: id: %d", id));
        return companyService.getEntity(id);
    }

    @PostMapping
    public Company save(@RequestBody Company company) {
        log.info(String.format("CompanyController.save(). params: company: %s", company));
        return companyService.saveEntity(company);
    }

    @PutMapping("{id}")
    public Company update(@PathVariable long id, @RequestBody Company company) {
        log.info(String.format("CompanyController.update(). params: company: %s", company));
        return companyService.updateEntity(id, company);
    }

    @DeleteMapping()
    public void delete(@RequestBody Company company) {
        log.info(String.format("CompanyController.save(). params: company: %s", company));
        companyService.deleteEntity(company);
    }

}
