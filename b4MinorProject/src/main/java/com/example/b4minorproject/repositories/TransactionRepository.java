package com.example.b4minorproject.repositories;

import com.example.b4minorproject.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    Transaction findTopByBookAndStudentAndTransactionTypeAndTransactionStatusOrderByIdDesc(Book book, Student student, TransactionType transactionType, TransactionStatus transactionStatus);
}
