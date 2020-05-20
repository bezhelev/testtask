package com.bezhelev.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Customer {

    @Id
    private long customerId;

    private String name;

    private int age;

    @ManyToOne
    private Company company;

}
