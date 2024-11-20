package com.mohitgupta.yummyapp.mapper;

import com.mohitgupta.yummyapp.dto.CustomerRequest;
import com.mohitgupta.yummyapp.dto.CustomerResponse;
import com.mohitgupta.yummyapp.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest request) {
        return Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(request.password())
                .build();
    }

    public CustomerResponse toCustomerResponse(Customer customer) {
        return new CustomerResponse(customer.getFirstName(), customer.getLastName(), customer.getEmail());
    }
}
