package com.example.TPJEE.dto;

import com.example.TPJEE.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccountRequestDTO {
    private Double balance;

    private String currency;

    private AccountType type;
}
