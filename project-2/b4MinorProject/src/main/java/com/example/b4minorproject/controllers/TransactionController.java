package com.example.b4minorproject.controllers;

import com.example.b4minorproject.models.TransactionType;
import com.example.b4minorproject.models.User;
import com.example.b4minorproject.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.User;
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
//                               @RequestParam("studentId") Integer studentId,
                               @RequestParam("txnType")TransactionType txnType) throws Exception {

        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        User user = (User) authentication.getPrincipal();
        Integer studentId = user.getStudent().getId();

        return this.transactionService.initiate(bookId,studentId,txnType);
    }
}
