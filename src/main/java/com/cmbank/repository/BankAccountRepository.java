package com.cmbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmbank.model.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

}
