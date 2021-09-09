package com.bank.model;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicInsert;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "customer_details",
uniqueConstraints = {
        @UniqueConstraint(columnNames = "aadharNumber"),
        @UniqueConstraint(columnNames = "userName")
})
//@SequenceGenerator(name="seq", initialValue=1000)
//@DynamicInsert
public class Customer_Details {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy=GenerationType.AUTO, generator="se
    @Column(name = "accountNumber", updatable = false, nullable = false)
	
	private int accountNumber;
	private String firstName;
	private String lastName;
	
	
    @JoinColumn(name = "branchId")
	@ManyToOne
	private Bank bank;
	
	private long aadharNumber;
	private long phoneNumber;
	private String userName;
	private String password;
	private double balance;
	private LocalDateTime aod=LocalDateTime.now();
	
	@Column(name = "status", nullable = false, columnDefinition = "int default 1") 

	private int status;
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	public long getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public LocalDateTime getAod() {
		
		return aod;
	}
	public void setAod(LocalDateTime aod)  {
		
//		 aod=new Date(); 
//		Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(aod.toString());
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ").parse(aod);
//		
//		//System.out.println(dateFormat.format(aod));  
//	 aod = dateFormat.format(aod);
		this.aod=aod;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Customer_Details [accountNumber=" + accountNumber + ", firstName=" + firstName + ", lastName="
				+ lastName + ", bank=" + bank + ", aadharNumber=" + aadharNumber + ", phoneNumber=" + phoneNumber
				+ ", userName=" + userName + ", password=" + password + ", balance=" + balance + ", aod=" + aod
				+ ", status=" + status + "]";
	}
	
}
