package com.bank.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dto.BankResponseDTO;
import com.bank.model.Bank;
import com.bank.repo.BankRepo;




@Service
public class BankService {

	@Autowired
	private BankRepo repo;

	List<Bank> list=new ArrayList<>();

	//To add new bank
	public BankResponseDTO addBank(Bank bank) {

		Bank bnk=repo.save(bank);
		BankResponseDTO bnkResponseDTO=new BankResponseDTO();
		if(bnk!=null) {
			list.add(bnk);
			bnkResponseDTO.setStatus("SUCCESS");
			bnkResponseDTO.setMsg("Bank created");
		}else {
			list.add(bank);
			bnkResponseDTO.setStatus("FAIL");
			bnkResponseDTO.setMsg("created");
			bnkResponseDTO.setBank(list);


		}
		return bnkResponseDTO;
	}

	//To view all banks
	public BankResponseDTO bankList() {

		list=repo.findAll();
		BankResponseDTO res=new BankResponseDTO();
		if(!list.isEmpty()) {
			res.setStatus("Below List of Bank available In DB");
			res.setMsg("List of bank is displayed successfully");
			res.setBank(list);
		}
		else {
			res.setStatus("list is empty..!");
		}
		return res;

	}


	//To update an existing bank
	public BankResponseDTO updateBank(Bank bank,int branchId) {

		BankResponseDTO res=new BankResponseDTO();

		if (repo.findById(branchId).isPresent()){
			Bank existing = repo.findById(branchId).get();

			existing.setBranchName(bank.getBranchName());
			existing.setIfsc(bank.getIfsc());

			Bank updated = repo.save(existing);
			list.clear();
			list.add(updated);
			res.setStatus("Updated");
			res.setMsg("Bank updated successfully in DB");
			res.setBank(list);


		}
		else{
			res.setStatus("Not updated");
		}
		return res;
	}

}







