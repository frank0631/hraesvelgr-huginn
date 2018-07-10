package com.frank0631.huginn.customer;

import com.frank0631.nidhogg.customer.Customer;


import javax.persistence.*;

/**
 * Created by frank0631 on 5/13/15.
 */
@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity extends Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public CustomerEntity() {
    }

    public CustomerEntity(Customer customer) {
        super(customer);
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%d, firstName='%s', lastName='%s']", id, getFirstName(), getLastName());
    }
}
