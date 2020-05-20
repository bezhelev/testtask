package com.bezhelev.service.impl;

import com.bezhelev.model.Company;
import com.bezhelev.repository.CompanyRepository;
import com.bezhelev.service.AbstractCRUDService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CompanyService extends AbstractCRUDService<Company, Long> {

    public CompanyService(CompanyRepository companyRepository) {
        super(companyRepository);
    }

    @Override
    protected void updateFields(Company oldEntity, Company newEntity) {
        oldEntity.setName(newEntity.getName());
    }
}
