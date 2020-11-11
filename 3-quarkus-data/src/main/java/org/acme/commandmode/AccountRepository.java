package org.acme.commandmode;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class AccountRepository implements PanacheRepositoryBase<Account, String> {

	@Inject
	EntityManager em;
	
	

}
