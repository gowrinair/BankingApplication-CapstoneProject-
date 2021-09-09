package com.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.model.Transaction;



@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer>{

}
