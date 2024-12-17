package com.tekarch.accountservice.Controller;



import com.tekarch.accountservice.Model.Account;
import com.tekarch.accountservice.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.Optional;

    @RestController
    @RequestMapping("/api/accounts")
    @Validated  // Enable validation at the controller level
    public class AccountController {

        @Autowired
        private AccountService accountService;

        // Create a new account
        @PostMapping
        public ResponseEntity<Account> createAccount(@Valid @RequestBody Account account) {
            Account createdAccount = accountService.createAccount(account);
            return ResponseEntity.ok(createdAccount);
        }

        // Get account by ID
        @GetMapping("/{id}")
        public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
            Optional<Account> account = accountService.getAccountById(id);
            return account.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        // Update account
        @PutMapping("/{id}")
        public ResponseEntity<Account> updateAccount(@PathVariable Long id, @Valid @RequestBody Account accountDetails) {
            Account updatedAccount = accountService.updateAccount(id, accountDetails);
            return ResponseEntity.ok(updatedAccount);
        }

        // Delete account
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
            accountService.deleteAccount(id);
            return ResponseEntity.noContent().build();
        }
    }

