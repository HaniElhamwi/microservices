package com.Accounts.Microservices.Account.service.impl;


import com.Accounts.Microservices.Account.dto.CustomerDto;
import com.Accounts.Microservices.Account.entity.Accounts;
import com.Accounts.Microservices.Account.entity.Customer;
import com.Accounts.Microservices.Account.exception.CustomerAlreadyExistException;
import com.Accounts.Microservices.Account.mapper.CustomerMapper;
import com.Accounts.Microservices.Account.respository.AccountsRespository;
import com.Accounts.Microservices.Account.respository.CustomerRespository;
import com.Accounts.Microservices.Account.service.IAccountService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountService {


    private AccountsRespository accountsRespository;
    private CustomerRespository customerRespository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto,new Customer());
    Optional<Customer> optionalCustomer =  customerRespository.findByMobileNumber(customer.getMobileNumber());

    if(optionalCustomer.isPresent()){
        throw new CustomerAlreadyExistException("Customer already exists" + customer.getMobileNumber());
    }
        Customer savedCustomer = customerRespository.save(customer);
        accountsRespository.save(createNewAccount(savedCustomer));

    }

//    create new account

    private Accounts createNewAccount(Customer customer){
        Accounts newAccount = new Accounts();
        newAccount.setAccountNumber(customer.getCustomerId());
        long randomAccNumber = 10000000000L + new Random().nextInt(900000000);
        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType("SAVINGS");
        newAccount.setBranchAddress("Bangalore");
        return newAccount;
    }



}
