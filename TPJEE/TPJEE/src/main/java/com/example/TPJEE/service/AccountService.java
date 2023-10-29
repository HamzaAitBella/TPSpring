package com.example.TPJEE.service;

import com.example.TPJEE.dto.BankAccountRequestDTO;
import com.example.TPJEE.dto.BankAccountResponseDTO;
import com.example.TPJEE.entities.BankAccount;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
}
