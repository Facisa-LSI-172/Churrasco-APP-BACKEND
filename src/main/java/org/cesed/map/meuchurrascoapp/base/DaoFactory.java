package org.cesed.map.meuchurrascoapp.base;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class DaoFactory {

	private DaoFactory(){}
	
	private static final String PERSISTENCE_UNIT_NAME = "wprojectPersistenceUnit";
	
	private static EntityManagerFactory entityManagerFactoryInstance;
	
	public static EntityManagerFactory entityManagerFactoryInstance(){
		if(entityManagerFactoryInstance == null){
			entityManagerFactoryInstance = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		return entityManagerFactoryInstance;
	}
	
}