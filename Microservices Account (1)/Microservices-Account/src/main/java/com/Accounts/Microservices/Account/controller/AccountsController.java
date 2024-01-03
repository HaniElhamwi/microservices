package com.Accounts.Microservices.Account.controller;



import com.Accounts.Microservices.Account.dto.CustomerDto;
import com.Accounts.Microservices.Account.dto.ResponseDto;
import com.Accounts.Microservices.Account.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api", produces = "application/json")
@AllArgsConstructor
public class AccountsController {

    private IAccountService iAccountService;

    @PostMapping(path = "/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto){
        iAccountService.createAccount(customerDto);
        return ResponseEntity.ok(new ResponseDto("200","Account created successfully"));
    }

}
