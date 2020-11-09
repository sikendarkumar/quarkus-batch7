package com.example.repository;

import java.util.logging.Logger;

import com.example.entity.Account;

public class JpaAccountRepository implements AccountRepository {

	private static Logger logger = Logger.getLogger("txr-service");

	public JpaAccountRepository() {
		logger.info("JdbcAccountRepository instance created..");
	}

	public Account loadAccount(String number) {
		// ...
		logger.info("loading account " + number);
		return new Account(number, 1000.00);
	}

	public Account updateAccount(Account account) {
		// ..
		logger.info("updating account " + account.getNum());
		return account;
	}

}
