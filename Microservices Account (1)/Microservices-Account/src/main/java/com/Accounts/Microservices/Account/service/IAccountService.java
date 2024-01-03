package com.Accounts.Microservices.Account.service;

import com.Accounts.Microservices.Account.dto.CustomerDto;



public interface IAccountService {

    void createAccount(CustomerDto customerDto);
}
