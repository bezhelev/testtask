package com.bezhelev.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Company {

    @Id
    private long companyId;

    private String name;

    @OneToMany
    private List<Customer> customers;

}
