package com.example.TPJEE.mappers;

import com.example.TPJEE.dto.BankAccountResponseDTO;
import com.example.TPJEE.entities.BankAccount;

public interface AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount);
}
