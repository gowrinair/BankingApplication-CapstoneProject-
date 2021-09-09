package com.bank.dto;

import java.util.List;

import com.bank.model.Transaction;



public class TransactionResponseDTO {
	private String status; 
	private String msg;
	private List<Transaction> transaction;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<Transaction> getTransaction() {
		return transaction;
	}
	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}
	@Override
	public String toString() {
		return "TransactionResponseDTO [status=" + status + ", msg=" + msg + ", transaction=" + transaction + "]";
	}
	
	

}
