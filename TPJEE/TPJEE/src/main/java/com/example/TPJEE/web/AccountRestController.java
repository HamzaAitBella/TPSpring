package com.example.TPJEE.web;


import com.example.TPJEE.dto.BankAccountRequestDTO;
import com.example.TPJEE.dto.BankAccountResponseDTO;
import com.example.TPJEE.entities.BankAccount;
import com.example.TPJEE.mappers.AccountMapper;
import com.example.TPJEE.repositories.BankAccountRepository;
import com.example.TPJEE.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    private BankAccountRepository bankAccountRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountMapper accountMapper;



    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @GetMapping("bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("bankAccounts/{id}")
    public BankAccount bankAccounts(@PathVariable String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Le Compte n'existe pas"));
    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO bankAccountRequestDTO){
        return accountService.addAccount(bankAccountRequestDTO);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id, @RequestBody BankAccount bankAccount){
        BankAccount acc= bankAccountRepository.findById(id).orElseThrow();
        if(bankAccount.getBalance()!=null)
            acc.setBalance(bankAccount.getBalance());
        if(bankAccount.getType()!=null)
            acc.setType(bankAccount.getType());
        if(bankAccount.getCreatedAt()!=null)
            acc.setCreatedAt(new Date());
        if(bankAccount.getCurrency()!=null)
            acc.setCurrency(bankAccount.getCurrency());


        return bankAccountRepository.save(acc);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id)
    {
        bankAccountRepository.deleteById(id);
    }






}
