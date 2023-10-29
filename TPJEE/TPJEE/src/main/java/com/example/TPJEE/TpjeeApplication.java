package com.example.TPJEE;

import com.example.TPJEE.entities.BankAccount;
import com.example.TPJEE.enums.AccountType;
import com.example.TPJEE.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class TpjeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpjeeApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository){
		return args -> {
			BankAccount bankAccount=BankAccount.builder()
					.id(UUID.randomUUID().toString())
					.type(AccountType.CURRENT_ACCOUNT)
					.balance(10000.0)
					.createdAt(new Date())
					.currency("MAD")
					.build();

			BankAccount bankAccount2=BankAccount.builder()
					.id(UUID.randomUUID().toString())
					.type(AccountType.SAVING_ACCOUNT)
					.balance(10000.0)
					.createdAt(new Date())
					.currency("MAD")
					.build();

			bankAccountRepository.save(bankAccount);
			bankAccountRepository.save(bankAccount2);

		};
	}
}


