package com.Accounts.Microservices.Account.respository;


import com.Accounts.Microservices.Account.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRespository extends JpaRepository<Accounts,Long> {
}
