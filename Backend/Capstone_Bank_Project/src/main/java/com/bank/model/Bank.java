package com.bank.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "bank",
uniqueConstraints = {
		@UniqueConstraint(columnNames = "ifsc")

})
public class Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "branchId", updatable = false, nullable = false)

	//@JoinColumn(name = "branchId")
	private int branchId;
	@Column(nullable = false)
	private String branchName;
	@Column(nullable = false)
	private String ifsc;

	@OneToMany(mappedBy="bank")
	private List<Customer_Details> cust;

	public int getBranchId() {
		return branchId;
	}
	@JsonIgnore
	public List<Customer_Details> getCust() {
		return cust;
	}
	public void setCust(List<Customer_Details> cust) {
		this.cust = cust;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	@Override
	public String toString() {
		return "Bank [branchId=" + branchId + ", branchName=" + branchName + ", ifsc=" + ifsc + ", cust=" + cust + "]";
	}


}
