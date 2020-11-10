package org.acme.commandmode;

import java.util.Date;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import javax.transaction.Transactional.TxType;

import io.quarkus.narayana.jta.runtime.TransactionConfiguration;

@ApplicationScoped
//@Transactional(value = TxType.REQUIRED, rollbackOn = { RuntimeException.class }, dontRollbackOn = {})
//@TransactionConfiguration(timeout = 40)
public class TxrService {

	@Inject
	AccountRepository accountRepository;

//	@Inject
//	UserTransaction userTransaction;

	@Transactional(value = TxType.REQUIRED,rollbackOn = {RuntimeException.class},dontRollbackOn = {}) 
	public void doTxr(double amount, String fromAccNum, String toAccNum) {

		Account fromAccount = accountRepository.findById(fromAccNum);
		Account toAccount = accountRepository.findById(toAccNum);

		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);

//		Account.update("balance=?1 where num=?2", fromAccount.getBalance(),fromAccount.getNum());
//		Account.update("balance=?1 where num=?2", toAccount.getBalance(),toAccount.getNum());
//		

		Txn debitTxn = new Txn();
		debitTxn.setAmount(amount);
		debitTxn.setDate(new Date());
		debitTxn.setType(TxnType.DEBIT);
		debitTxn.setAccountNumber(fromAccNum);

		Txn creditTxn = new Txn();
		creditTxn.setAmount(amount);
		creditTxn.setDate(new Date());
		creditTxn.setType(TxnType.CREDIT);
		creditTxn.setAccountNumber(toAccNum);

		debitTxn.persist();
		creditTxn.persist();

	}

}
