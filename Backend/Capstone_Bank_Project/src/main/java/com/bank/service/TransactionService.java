package com.bank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dto.BankResponseDTO;
import com.bank.dto.TransactionResponseDTO;
import com.bank.model.Customer_Details;
import com.bank.model.Transaction;
import com.bank.repo.CustomerRepo;
import com.bank.repo.TransactionRepo;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepo transactRepo;
	@Autowired
	private CustomerRepo custRepo;
	
	List<Transaction> list=new ArrayList<>();

	public TransactionResponseDTO transfer(Transaction transaction) {
		// TODO Auto-generated method stub
		TransactionResponseDTO transResponseDTO=new TransactionResponseDTO();
		try {
		Customer_Details toCust=custRepo.findById(transaction.getToAccount()).get();
		System.out.println(toCust.getAccountNumber());
		Customer_Details fromCust=custRepo.findById(transaction.getCustomer().getAccountNumber()).get();
		
		
		double fromBalance=fromCust.getBalance();
		double toBalance=toCust.getBalance();
		double transAmount=transaction.getTransAmount();
		if((toCust!=null) && (toCust.getStatus()==0) && (fromBalance>=transAmount)) {
			
			
			//deducting from FromCustomer
			double balance=fromBalance-transAmount;
			fromCust.setBalance(balance);
			fromCust=custRepo.save(fromCust);
			
			
			//adding to ToCustomer
			balance=toBalance+transAmount;
			toCust.setBalance(balance);
			toCust=custRepo.save(toCust);
			list.add(transaction);		
			transactRepo.save(transaction);
		
			transResponseDTO.setStatus("SUCCESS");
			transResponseDTO.setMsg("transaction done successfully");
			transResponseDTO.setTransaction(list);
		}else {
			transResponseDTO.setStatus("FAIL");
			transResponseDTO.setMsg("something went wrong..!");
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			transResponseDTO.setStatus("FAIL");
			transResponseDTO.setMsg(e.toString());
		}
		return transResponseDTO;
		
	}

//	public TransactionResponseDTO transactionHistory(int accountNumber) {
//		// TODO Auto-generated method stub
//		Transaction transaction=transactRepo.findById(accountNumber).get();
//		
//	
//		
////		BankResponseDTO res=new BankResponseDTO();
////		if(!list.isEmpty()) {
////			res.setStatus("Below List of Bank available In DB");
////			res.setMsg("List of bank is displayed successfully");
////			res.setBank(list);
////		}
////		else {
////			res.setStatus("list is empty..!");
////		}
////		return res;
//
//		return null;
//	}

}
