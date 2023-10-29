package com.example.TPJEE.service;

import com.example.TPJEE.dto.BankAccountRequestDTO;
import com.example.TPJEE.dto.BankAccountResponseDTO;
import com.example.TPJEE.entities.BankAccount;
import com.example.TPJEE.mappers.AccountMapper;
import com.example.TPJEE.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private AccountMapper accountMapper;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .balance(bankAccountDTO.getBalance())
                .createdAt(new Date())
                .currency(bankAccountDTO.getCurrency())
                .type(bankAccountDTO.getType())
                .build();

        BankAccount bankAcc = bankAccountRepository.save(bankAccount);


         BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(bankAcc)
        return bankAccountResponseDTO;
    }
}
