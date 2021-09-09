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
import com.bank.model.Bank;
import com.bank.service.BankService;




@RestController
@RequestMapping(value="/admin")
public class BankController {


	@Autowired
	private BankService bankService;

	/*--------------------------------Add Bank---------------------------*/

	@RequestMapping(value = "/addBank",consumes = "application/json",produces = "application/json",method = RequestMethod.POST)
	public ResponseEntity<BankResponseDTO>addBank(@RequestBody Bank bank ){
		BankResponseDTO response=bankService.addBank(bank);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}



	/*--------------------------------View Banks---------------------------*/

	@RequestMapping(value = "/listBank",consumes = "application/json",produces = "application/json",method = RequestMethod.GET)
	public ResponseEntity<BankResponseDTO> bankList(){
		BankResponseDTO response=bankService.bankList();
		return new ResponseEntity<BankResponseDTO>(response ,HttpStatus.OK);

	}

	/*--------------------------------Edit Bank---------------------------*/

	@RequestMapping(value = "/updateBank/{branchId}",consumes = "application/json",produces = "application/json",method = RequestMethod.PUT)
	public ResponseEntity<BankResponseDTO> updateBank(@RequestBody Bank bank,@PathVariable int  branchId){
		BankResponseDTO response=bankService.updateBank(bank, branchId);
		return new ResponseEntity<BankResponseDTO>(response ,HttpStatus.OK);

	}


}
