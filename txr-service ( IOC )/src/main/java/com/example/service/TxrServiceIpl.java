package com.example.service;

import java.util.logging.Logger;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;

/*
 * 
 * design & performance issues
 * ---------------------------
 * 
 * => tight-coupling b/w dependent & dependency  ( design issue )
 * 
 * 		==> can't extend with new features
 * 
 * => too many duplicate dependency instances created & discarded ( performance issue )
 * 
 * 		==> resource use high 
 * 
 * => unit-testing not possible
 * 
 * 		==> dev & bug fix slow
 * 
 * 
 * 
 * why these issues are here ?
 * 
 
 * ==> dependent itself creating it's own dependency 
 * 
 * 
 * soln : use 'factory design pattern' ( don't create dependency in dependent's home, do lookup )
 * 
 * limitation with factory lookup :
 * 
 * 	=> factory-location tightly coupled.
 * 
 * best soln :
 * 
 * 
 *  ==> don't create/lookup , inject by  third-party ( inversion of control )
 *  
 *  
 *  how to implement IOC ?
 *  
 *  
 *    => dependency injection ( DI )
 *    => proxy / interceptors 
 *    
 *    
 *  ----------------------------------------------------------------------------------------
 *  
 *    
 *    OO concepts
 *    OO principles a.k.a SOLID principles 
 *    
 *    
 *    SOLID principles
 *    
 *    S.O.L.I.D stands for:
		S - Single-responsiblity principle
		O - Open-closed principle
		L - Liskov substitution principle
		I - Interface segregation principle
		D - Dependency Inversion Principle
 *    
 *    OO patterns
 *    
 *   
 *  ----------------------------------------------------------------------------------------
 *  
 * 
 */

public class TxrServiceIpl implements TxrService {

	private static Logger logger = Logger.getLogger("txr-service");

	private AccountRepository accountRepository;

	public TxrServiceIpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
		logger.info("TxrService instance created....");
	}

	public void txr(double amount, String fromAccNum, String toAccNum) {

		logger.info("txr initiated..");

//		JdbcAccountRepository accountRepository = new JdbcAccountRepository();

		Account fromAccount = accountRepository.loadAccount(fromAccNum);
		Account toAccount = accountRepository.loadAccount(toAccNum);

		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);

		accountRepository.updateAccount(fromAccount);
		accountRepository.updateAccount(toAccount);

		logger.info("txr completed..");

	}

}
