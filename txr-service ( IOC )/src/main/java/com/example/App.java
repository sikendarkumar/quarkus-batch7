package com.example;

import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import com.example.service.TxrService;
import com.example.service.TxrServiceIpl;

public class App {

	public static void main(String[] args) {

		// init
		AccountRepository accountRepository=new JdbcAccountRepository();
		TxrService txrService = new TxrServiceIpl(accountRepository); // DI

		// use

		txrService.txr(100.00, "1", "2");
		System.out.println();
		txrService.txr(100.00, "1", "2");

		// destroy

	}

}
