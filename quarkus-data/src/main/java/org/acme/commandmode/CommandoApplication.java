package org.acme.commandmode;

import javax.inject.Inject;
import javax.transaction.Transactional; // JTA
import javax.transaction.Transactional.TxType;

import io.quarkus.narayana.jta.runtime.TransactionConfiguration;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class CommandoApplication implements QuarkusApplication {

//	@Inject
//	DataSource datasource;
//	
//	@io.quarkus.agroal.DataSource("auth")
//	DataSource authDataSource;

	@Inject
	AccountRepository accountRepository;
	
	
	@Inject
	TxrService txrService;

	@Transactional(value = TxType.REQUIRED)
	@TransactionConfiguration(timeout = 40)
	@Override
	public int run(String... args) throws Exception {
		// final String name = args.length > 0 ? String.join(" ", args) : "commando";
		// System.out.println("hello " + name);

		// # active record design pattern

//    	Account account=Account.findById("1"); // 
//    	System.out.println(account);
//    	
//    	long count=Account.count();
//    	System.out.println(count);

//		Account.findByBalane(1000).forEach(System.out::println);

//		# repository design pattern

//		Account account = accountRepository.findById("1");
//		System.out.println(account);

//		Account account = new Account();
//		account.setNum("5");
//		account.setBalance(1000.00);
//
//		account.persist();
		
		
		txrService.doTxr(1000.00, "5", "4");
		
		
	
		

		return 0;
	}

}
