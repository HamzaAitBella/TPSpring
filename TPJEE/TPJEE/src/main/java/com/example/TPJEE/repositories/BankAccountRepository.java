package com.example.TPJEE.repositories;

import com.example.TPJEE.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {

}