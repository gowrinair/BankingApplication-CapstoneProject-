package com.bank.dto;

import java.util.List;

import com.bank.model.Bank;


public class BankResponseDTO {
	
	private String status; 
	private String msg;
	private List<Bank> bank;
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
	
	@Override
	public String toString() {
		return "BankResponseDTO [status=" + status + ", msg=" + msg + ", bank=" + bank + "]";
	}
	public List<Bank> getBank() {
		return bank;
	}
	public void setBank(List<Bank> bank) {
		this.bank = bank;
	}
	


}
