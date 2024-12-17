package com.tekarch.accountservice.Repository;




import com.tekarch.accountservice.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface AccountRepository extends JpaRepository<Account, Long> {
        // Spring Data JPA provides basic CRUD operations automatically
    }
