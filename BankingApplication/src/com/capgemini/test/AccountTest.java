package com.capgemini.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;

import com.capgemini.Service.AccountService;
import com.capgemini.Service.AccountServiceImpl;
import com.capgemini.exception.InsufficientInitialAmountException;
import com.capgemini.exception.InvalidAccountNumberException;
import com.capgemini.model.Account;
import com.capgemini.repository.AccountRepository;

public class AccountTest {

	@Mock
	AccountRepository accountRepository;
	
	AccountService accountService;
	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		accountService = new AccountServiceImpl(accountRepository);
	}
	
	
	/*
	 * create account
	 * 1.when the amount is less than 500 system should throw exception
	 * 2.when the valid info is passed account should be created successfully
	 * 3.
	 */

	@Test(expected=com.capgemini.exception.InsufficientInitialAmountException.class)
    public void whenTheAmountIsLessThanFiveHundredSystemShouldThrowException() throws InsufficientInitialAmountException
    {
		accountService.createAccount(101, 400);
    }
	
	@Test(expected=com.capgemini.exception.InvalidAccountNumberException.class)
	public void whenAccountIsNotPresentSystemShouldThrowInvalidAccountNumberException() throws InvalidAccountNumberException
	{
		
		when(accountRepository.searchAccount(101)).thenReturn(null);
		accountService.depositAmount(101, 211);
		
	}
	
	
	


	//@Test
	//public void whenTheValidInfoIsPassedAccountShouldBeCreatedSuccessfully() throws InsufficientInitialAmountException
	//{
		@Test
		public void whenTheValidInfoIsPassedAccountShouldBeCreatedSuccessfully() throws InsufficientInitialAmountException
		{
			Account account =new Account();
			account.setAccountNumber(101);
			account.setAmount(5000);
			
			when(accountRepository.save(account)).thenReturn(true);
			assertEquals(account,accountService.createAccount(101, 5000));
		}
		
	}

