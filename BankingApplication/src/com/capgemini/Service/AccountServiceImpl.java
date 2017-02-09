package com.capgemini.Service;

import com.capgemini.exception.InsufficientInitialAmountException;
import com.capgemini.exception.InvalidAccountNumberException;
import com.capgemini.model.Account;
import com.capgemini.repository.AccountRepository;

public class AccountServiceImpl implements AccountService{

	
	
	AccountRepository accountRepository;
	
	public AccountServiceImpl(AccountRepository accountRepository)
	{
		
		this.accountRepository=accountRepository;
		
	}
	
	
	
	@Override
	public Account createAccount(int accountNumber, int amount) throws InsufficientInitialAmountException 
	{
		
		if(amount<500){
			
			throw new InsufficientInitialAmountException();
		}
		
		Account account=new Account();
		
		account.setAccountNumber(accountNumber);
		
		account.setAmount(amount);
		
			
			if(accountRepository.save(account))
			{
		return account;
	}
		return null;
		
	}



	@Override
	public  int depositAmount(int accountNumber,int amount) throws InvalidAccountNumberException{
		Account account=accountRepository.searchAccount(accountNumber);
		if(account!=null)
		{
			account.setAmount(account.getAmount()+amount);	
			System.out.println("after deposit"+account.getAmount());		
			return account.getAmount();   
		}
		else
			throw new InvalidAccountNumberException();
				
	}
	
	}
	
	
	
	

