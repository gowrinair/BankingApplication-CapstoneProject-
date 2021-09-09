package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.BankResponseDTO;
import com.bank.dto.TransactionResponseDTO;
import com.bank.model.Customer_Details;
import com.bank.model.Transaction;
import com.bank.service.TransactionService;


@RestController
@RequestMapping(value="/transaction")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	/*--------------------------------Transaction ---------------------------*/
	@RequestMapping(value = "/transfer",consumes = "application/json",produces = "application/json",method = RequestMethod.POST)
	public ResponseEntity<TransactionResponseDTO>transfer(@RequestBody Transaction transaction ){
		TransactionResponseDTO response=transactionService.transfer(transaction);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
//
//	/*--------------------------------View Transaction History---------------------------*/
//	@RequestMapping(value = "/listTransaction/{accountNumber}",consumes = "application/json",produces = "application/json",method = RequestMethod.GET)
//	public ResponseEntity<TransactionResponseDTO> transactionHistory(@PathVariable int  accountNumber){
//		TransactionResponseDTO response=transactionService.transactionHistory(accountNumber);
//		return new ResponseEntity<TransactionResponseDTO>(response ,HttpStatus.OK);
//
//	}
		

}
