package com.emp.trans;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.hibernate.TransactionException;
import org.springframework.jdbc.datasource.JdbcTransactionObjectSupport;
import org.springframework.orm.jpa.EntityManagerHolder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.NestedTransactionNotSupportedException;
import org.springframework.transaction.SavepointManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionStatus;



public class MyJPATransactionManager extends JpaTransactionManager {

	

	
	
	public MyJPATransactionManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyJPATransactionManager(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

	public Object doGetTransaction()
	{
		return super.doGetTransaction();
	}
	
	public void doBegin(Object transaction, TransactionDefinition definition)
	{
		super.doBegin(transaction, definition);
	}
	
	public void doCommit(DefaultTransactionStatus status)
	{
		super.doCommit(status);
	}
	
	
	private static class JpaTransactionObject extends JdbcTransactionObjectSupport
    {

        public void setEntityManagerHolder(EntityManagerHolder entityManagerHolder, boolean newEntityManagerHolder)
        {
            this.entityManagerHolder = entityManagerHolder;
            this.newEntityManagerHolder = newEntityManagerHolder;
        }

        public EntityManagerHolder getEntityManagerHolder()
        {
            return entityManagerHolder;
        }

        public boolean isNewEntityManagerHolder()
        {
            return newEntityManagerHolder;
        }

        public boolean hasTransaction()
        {
           // return entityManagerHolder != null && entityManagerHolder.isTransactionActive();
        	return false;
        }

        public void setTransactionData(Object transactionData)
        {
            /*this.transactionData = transactionData;
            entityManagerHolder.setTransactionActive(true);
            if(transactionData instanceof SavepointManager)
                entityManagerHolder.setSavepointManager((SavepointManager)transactionData);*/
        }

        public Object getTransactionData()
        {
            return transactionData;
        }

        public void setRollbackOnly()
        {
            EntityTransaction tx = entityManagerHolder.getEntityManager().getTransaction();
           /* if(tx.isActive())
                tx.setRollbackOnly();
            if(hasConnectionHolder())
                getConnectionHolder().setRollbackOnly(); */
        }

        public boolean isRollbackOnly()
        {
            EntityTransaction tx = entityManagerHolder.getEntityManager().getTransaction();
            //return tx.getRollbackOnly();
            return false;
        }

        public Object createSavepoint()
            throws TransactionException
        {
            return getSavepointManager().createSavepoint();
        }

        public void rollbackToSavepoint(Object savepoint)
            throws TransactionException
        {
            getSavepointManager().rollbackToSavepoint(savepoint);
        }

        public void releaseSavepoint(Object savepoint)
            throws TransactionException
        {
            getSavepointManager().releaseSavepoint(savepoint);
        }

        private SavepointManager getSavepointManager()
        {
           /* if(!isSavepointAllowed())
                throw new NestedTransactionNotSupportedException("Transaction manager does not allow nested transactions");
            SavepointManager savepointManager = getEntityManagerHolder().getSavepointManager();
            if(savepointManager == null)
                throw new NestedTransactionNotSupportedException("JpaDialect does not support savepoints - check your JPA provider's capabilities");
            else
                return savepointManager;*/
        	return null;
        }

        private EntityManagerHolder entityManagerHolder;
        private boolean newEntityManagerHolder;
        private Object transactionData;

        private JpaTransactionObject()
        {
        }

    }

	 private final EntityManagerHolder entityManagerHolder=null;
   //  private final ConnectionHolder connectionHolder;
}
