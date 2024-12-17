package com.tekarch.accountservice.Service;



import com.tekarch.accountservice.Model.Account;
import com.tekarch.accountservice.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

    @Service
    public class AccountService {

        @Autowired
        private AccountRepository accountRepository;

        // Create a new account
        public Account createAccount(Account account) {
            return accountRepository.save(account);
        }

        // Get account by ID
        public Optional<Account> getAccountById(Long id) {
            return accountRepository.findById(id);
        }

        // Update account
        public Account updateAccount(Long id, Account accountDetails) {
            Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
            account.setAccountHolderName(accountDetails.getAccountHolderName());
            account.setAccountType(accountDetails.getAccountType());
            account.setBalance(accountDetails.getBalance());
            return accountRepository.save(account);
        }

        // Delete account
        public void deleteAccount(Long id) {
            Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
            accountRepository.delete(account);
        }
    }
