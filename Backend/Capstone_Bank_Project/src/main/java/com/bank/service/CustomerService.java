package com.bank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dto.BankResponseDTO;
import com.bank.dto.CustomerResponseDTO;
import com.bank.model.Bank;
import com.bank.model.Customer_Details;

import com.bank.repo.CustomerRepo;


@Service
public class CustomerService {

	@Autowired
	private CustomerRepo repo;

	List<Customer_Details> list=new ArrayList<>();

	public CustomerResponseDTO addCustomer(Customer_Details customer) {
		// TODO Auto-generated method stub
		System.out.print(customer);
		Customer_Details cust=repo.save(customer);
		CustomerResponseDTO custResponseDTO=new CustomerResponseDTO();
		if(cust!=null) {

			list.add(cust);
			custResponseDTO.setStatus("SUCCESS");
			custResponseDTO.setMsg("Customer created");
			custResponseDTO.setCustomer(list);

		}else {
			custResponseDTO.setStatus("FAIL");
			custResponseDTO.setMsg("not created");
			list.add(customer);
			custResponseDTO.setCustomer(list);


		}
		return custResponseDTO;
	}

	public CustomerResponseDTO customerList() {

		list=repo.findAll();
		CustomerResponseDTO res=new CustomerResponseDTO();
		if(!list.isEmpty()  ) {  
			res.setStatus("Below List of Customers available In DB");
			res.setMsg("List of Customers is displayed successfully");
			res.setCustomer(list);
		}
		else {
			res.setStatus("list is empty..!");
		}
		return res;
	}

	public Customer_Details updateCustomer(Customer_Details customer, String userName) {
		CustomerResponseDTO res=new CustomerResponseDTO();

		
			Customer_Details existing = repo.findByuserName(userName);

			existing.setFirstName(customer.getFirstName());
			existing.setLastName(customer.getLastName());
			existing.setAadharNumber(customer.getAadharNumber());
			existing.setPhoneNumber(customer.getPhoneNumber());
			existing.setUserName(customer.getUserName());
			existing.setPassword(customer.getPassword());


			Customer_Details updated = repo.save(existing);
			list.clear();
			list.add(updated);
			res.setStatus("Updated");
			res.setMsg("Customer updated successfully in DB");
			res.setCustomer(list);


	
		return updated;
	}

	public CustomerResponseDTO deleteCustomer(int acc) {
		Customer_Details cust=repo.findById(acc).get();
		CustomerResponseDTO response=new CustomerResponseDTO();
		if(cust!=null && cust.getStatus()==0) {

			cust.setStatus(1);
			Customer_Details updated = repo.save(cust);
			list.clear();
			list.add(updated);
			response.setStatus("Updated");
			response.setMsg("Customer deleted successfully in DB");
			response.setCustomer(list);

		}
		else {
			response.setStatus("Data Not Avilable in DB ...!");
		}
		return response;
	}


	public CustomerResponseDTO viewCustomer(int accountNumber) {
		CustomerResponseDTO res=new CustomerResponseDTO();
		Customer_Details cust=repo.findById(accountNumber).get();
		list.clear();
		list.add(cust);
		if(!list.isEmpty()  ) {
			res.setStatus("Customer is  available In DB");
			res.setMsg("Customer details is displayed successfully");
			res.setCustomer(list);
		}
		else {
			res.setStatus("No such customer...!");
		}
		return res;


	}

	public CustomerResponseDTO customerLogin(String username, String password) {
		// TODO Auto-generated method stub
		Customer_Details cust=repo.findByuserName(username);
		CustomerResponseDTO res=new CustomerResponseDTO();


		if(cust!=null  &&(cust.getPassword().equals(password))  ) {
			int acc=cust.getAccountNumber();


			String pw1=cust.getPassword();

			System.out.println("Given"+pw1);

			System.out.println("Service"+password);
			list.clear();
			list.add(cust);
			res.setStatus("Customer is  available In DB");
			res.setMsg("Customer details is displayed successfully");

			res.setCustomer(list);
			System.out.println(cust.getAccountNumber());
		}


		else {
			res.setStatus("No such customer...!");
			res.setMsg("Invalid credential or user is not present registered");
			list.clear();
			res.setCustomer(list);
		}
		return res;


	}

	public Customer_Details customerProfile(String username) {
		// TODO Auto-generated method stub

		Customer_Details cust=repo.findByuserName(username);
		
		return cust;
	
	}
	
	public int customerAccNo(String username) {
		// TODO Auto-generated method stub

		Customer_Details cust=repo.findByuserName(username);
		
		return cust.getAccountNumber();
	
	}


}

