package org.cesed.map.meuchurrascoapp.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;


@SuppressWarnings("unchecked")
public abstract class GenericDao<T, PK> {

	private final EntityManager entityManager;
	
	private final EntityManagerFactory factory;
	
	private Class<?> clazz;

	
	public GenericDao(){
		this(DaoFactory.entityManagerFactoryInstance());
	}
	
	public GenericDao(EntityManagerFactory factory){
		this.factory = factory;
		this.entityManager = factory.createEntityManager();
		this.clazz = (Class<?>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	
	public Object executeQuery(String query, Object... params){
		Query createdQuery = this.entityManager.createQuery(query);
		for(int i=0; i< params.length; i++){
			createdQuery.setParameter(i,  params[0]);
		}	
		return createdQuery.getResultList();
	}
	
	public List<T> findAll(){
		return this.entityManager.createQuery("FROM " + this.clazz.getName()).getResultList();
	}
	
	public T findById(PK pk){
		return (T) this.entityManager.find(this.clazz, pk);
	}
	
	public T save(T entity){
		try{
			this.beginTransaction();
			this.entityManager.persist(entity);
			this.commit();
			return entity;
		}
		catch(Exception ex){
			this.rollback();
			throw ex;
		}
	}
	
	public void update(T entity){
		try{
			this.beginTransaction();
			this.entityManager.merge(entity);
			this.commit();
		}
		catch(Exception ex){
			this.rollback();
			throw ex;
		}
	}
	
	public void remove(T entity){
		try{
			this.beginTransaction();
			this.entityManager.remove(entity);
			this.commit();
		}
		catch(Exception ex){
			this.rollback();
			throw ex;
		}
	}
	
	/////////////////////////////////////////////
	// Métodos de transação
	////////////////////////////////////////////
	
	public void beginTransaction(){
		this.entityManager.getTransaction().begin();
	}
	
	public void commit(){
		this.entityManager.getTransaction().commit();
	}
	
	public void close(){
		this.entityManager.close();
		this.factory.close();
	}
	
	public void rollback(){
		this.entityManager.getTransaction().rollback();
	}
	
	public EntityManager getEntityManager(){
		return this.entityManager;
	}
	
}

