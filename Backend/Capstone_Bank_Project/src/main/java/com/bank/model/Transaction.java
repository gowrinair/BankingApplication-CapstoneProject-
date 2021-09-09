package com.bank.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class Transaction {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transactionId", updatable = false, nullable = false)
	private int transactionId;
	
	@OneToOne
    @JoinColumn(name = "accountNumber")
	private Customer_Details customer;
	private int toAccount;
	private LocalDateTime dot=LocalDateTime.now();
	private double transAmount;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public Customer_Details getCustomer() {
		return customer;
	}
	public void setCustomer(Customer_Details customer) {
		this.customer = customer;
	}
	public int getToAccount() {
		return toAccount;
	}
	public void setToAccount(int toAccount) {
		this.toAccount = toAccount;
	}
	public  LocalDateTime getDot() {
		return dot;
	}
	public void setDot(LocalDateTime dot) {
		this.dot = dot;
	}
	public double getTransAmount() {
		return transAmount;
	}
	public void setTransAmount(double transAmount) {
		this.transAmount = transAmount;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", customer=" + customer + ", toAccount=" + toAccount
				+ ", dot=" + dot + ", transAmount=" + transAmount + "]";
	}
	
}
