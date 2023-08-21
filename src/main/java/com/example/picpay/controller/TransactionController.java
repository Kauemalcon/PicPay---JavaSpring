package com.example.picpay.controller;

import com.example.picpay.domain.transaction.Transaction;
import com.example.picpay.domain.user.User;
import com.example.picpay.dtos.TransactionDTO;
import com.example.picpay.dtos.UserDTO;
import com.example.picpay.service.TransactionService;
import com.example.picpay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;
    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transactionDTO) throws Exception {
       Transaction transaction = this.transactionService.createTransaction(transactionDTO);
       return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }
}
