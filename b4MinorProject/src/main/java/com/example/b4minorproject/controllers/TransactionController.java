package com.example.b4minorproject.controllers;

import com.example.b4minorproject.models.TransactionType;
import com.example.b4minorproject.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/txn")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/initiate")
    private String initiateTxn(@RequestParam("bookId") Integer bookId,
                               @RequestParam("studentId") Integer studentId,
                               @RequestParam("txnType")TransactionType txnType) throws Exception {

        return this.transactionService.initiate(bookId,studentId,txnType);
    }
}
