package com.capgemini.Service;

import com.capgemini.exception.InsufficientInitialAmountException;
import com.capgemini.exception.InvalidAccountNumberException;
import com.capgemini.model.Account;

public interface AccountService {
	
	/*public  createAccount(int accountNumber,int amount) t*/
	
	
	Account createAccount(int accountNumber,int amount) throws InsufficientInitialAmountException;

	//int depositAmount(int i, int j) throws InvalidAccountNumberException;

	
	int depositAmount(int accountNumber, int amount) throws InvalidAccountNumberException;
}
