package com.example.TPJEE.mappers;

import com.example.TPJEE.dto.BankAccountResponseDTO;
import com.example.TPJEE.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapperImpl implements AccountMapper {
    @Override
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount) {
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }
}
