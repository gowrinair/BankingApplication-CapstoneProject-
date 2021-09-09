package com.bank.dto;

import java.util.List;

import com.bank.model.Bank;
import com.bank.model.Customer_Details;

public class CustomerResponseDTO {
	
	private String status; 
	private String msg;
	private List<Customer_Details> customer;
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
	public List<Customer_Details> getCustomer() {
		return customer;
	}
	public void setCustomer(List<Customer_Details> customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "CustomerResponseDTO [status=" + status + ", msg=" + msg + ", customer=" + customer + "]";
	}
	

}
