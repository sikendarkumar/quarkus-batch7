package org.acme.commandmode;

import javax.transaction.Transactional;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class CommandoApplication implements QuarkusApplication {
	
//	@Inject
//	DataSource datasource;
//	
//	@io.quarkus.agroal.DataSource("auth")
//	DataSource authDataSource;

	@Transactional
    @Override
    public int run(String... args) throws Exception {
        //final String name = args.length > 0 ? String.join(" ", args) : "commando";
        //System.out.println("hello " + name);
        
    	
    	Account account=Account.findById("1"); // 
    	System.out.println(account);
    	
        
        
        return 0;
    }
    
    
}
