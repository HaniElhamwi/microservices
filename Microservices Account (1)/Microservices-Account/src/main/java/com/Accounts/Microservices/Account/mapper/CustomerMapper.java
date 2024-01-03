package com.Accounts.Microservices.Account.mapper;


import com.Accounts.Microservices.Account.dto.CustomerDto;
import com.Accounts.Microservices.Account.entity.Customer;

public class CustomerMapper {

    public static CustomerDto mapToCustomerDto(Customer customer , CustomerDto customerDto){
        customerDto.setName(customer.getName());
        customerDto.setMobileNumber(customer.getMobileNumber());
        customerDto.setEmail(customer.getEmail());
        return customerDto;
    }

//    mapToCustomer


    public static Customer mapToCustomer(CustomerDto customerDto , Customer customer){
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setEmail(customerDto.getEmail());
        return customer;
    }


}
