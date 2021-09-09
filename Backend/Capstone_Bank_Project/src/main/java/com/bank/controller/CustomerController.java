package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.bank.dto.CustomerResponseDTO;

import com.bank.model.Customer_Details;
import com.bank.service.CustomerService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	/*--------------------------------Add Customer--------------(admin and customer privilege)-------------*/

	@RequestMapping(value = "/addCustomer",consumes = "application/json",produces = "application/json",method = RequestMethod.POST)
	public ResponseEntity<CustomerResponseDTO>addCustomer(@RequestBody Customer_Details customer ){
		CustomerResponseDTO response=customerService.addCustomer(customer);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}

	/*--------------------------------View Customers-------------(admin privilege)--------------*/

	@RequestMapping(value = "/listCustomer",consumes = "application/json",produces = "application/json",method = RequestMethod.GET)
	public ResponseEntity<CustomerResponseDTO> customerList(){
		CustomerResponseDTO response=customerService.customerList();
		return new ResponseEntity<CustomerResponseDTO>(response ,HttpStatus.OK);

	}


	//	/*--------------------------------View a single Customer-------------(customer privilege)--------------*/
	//	   
	//    @RequestMapping(value = "/{accountNumber}",consumes = "application/json",produces = "application/json",method = RequestMethod.GET)
	//    public ResponseEntity<CustomerResponseDTO> viewCustomer(@PathVariable int  accountNumber){
	//        CustomerResponseDTO response=customerService.viewCustomer(accountNumber);
	//        return new ResponseEntity<CustomerResponseDTO>(response ,HttpStatus.OK);
	//    }



	

	/*--------------------------------Delete Customers-------(admin privilege)--------------------*/
	@RequestMapping(value = "/deleteCustomer/{accountNumber}",consumes = "application/json",produces = "application/json",method = RequestMethod.PUT)	
	public ResponseEntity<CustomerResponseDTO> deleteCustomer(@PathVariable int  accountNumber){
		CustomerResponseDTO response=customerService.deleteCustomer(accountNumber);
		return new ResponseEntity<CustomerResponseDTO>(response ,HttpStatus.OK);

	}


	/*--------------------------------Customer login-------------(customer privilege)--------------*/
	@RequestMapping(value = "/{username}/{password}",consumes = "application/json",produces = "application/json",method = RequestMethod.GET)
	public ResponseEntity<CustomerResponseDTO> loginCustomer(@PathVariable String  username,@PathVariable String  password){
		CustomerResponseDTO response=customerService.customerLogin(username,password);
		return new ResponseEntity<CustomerResponseDTO>(response ,HttpStatus.OK);
	}


	// To get balance by id
	// 	@RequestMapping(value = "/{username}/{password}", method = RequestMethod.GET)
	// 	public Customer_Details viewBalance(@PathVariable String  username,@PathVariable String  password) {
	// 		return customerService.customerLogin(username,password);
	// 	}

	// To get profile
	@RequestMapping(value = "getProfile/{username}", method = RequestMethod.GET)
	public Customer_Details getProfile(@PathVariable String  username) {
		return customerService.customerProfile(username);
	}
	
	@RequestMapping(value = "getAccNumber/{username}", method = RequestMethod.GET)
	public int getAccNo(@PathVariable String  username) {
		return customerService.customerAccNo(username);
	}
	/*--------------------------------Edit Customers----------(customer privilege)-----------------*/

	@RequestMapping(value = "/updateCustomer/{userName}",consumes = "application/json",produces = "application/json",method = RequestMethod.PUT)
	public Customer_Details updateCust(@RequestBody Customer_Details customer,@PathVariable String  userName){
		return customerService.updateCustomer(customer, userName);
		

	}
}
