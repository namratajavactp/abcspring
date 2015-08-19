package com.emp.dao;



import javax.persistence.*;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.emp.Employee;

public class EmployeeDAO extends HibernateDaoSupport implements IDAO {

	
	
	public void insertRecord(Object obj) throws Exception {
		// TODO Auto-generated method stub
		//No need to fire the following parameterized query (normal JDBC) as here we are
		//gonna use ORM (hibernate with JPA), which will persist an Object inside underlying DB.
		//String empInsert = "insert into EMP (empid,firstname,lastname) values (?,?,?)";
		
		if(obj instanceof Employee)
		{	
				//No need to catch as it is RunTime Exception, but you CAN if you can handle it	
			try
			{
				
			    Employee emp = (Employee)obj;
			    
			  
			   
				getHibernateTemplate().saveOrUpdate(emp);
				
				System.out.println("employee is persisted");
			 
			}
			catch(Exception exp)
			{
				exp.printStackTrace();
				throw exp;
			}
			
		}
		
	}
	
	public void updateRecord(Object obj)
	{
		/*String empUpdate = "update EMP set  firstname=?, lastname=?  where empid=?";
		
		if(obj instanceof Employee)
		{
			Employee emp = (Employee)obj;
			simpleJdbctemplate.update(empUpdate,new Object[] {emp.getFirstname(),emp.getLastname(),emp.getEmpid()});
		}*/
	}

	
	public Object retrieveRecord(int empid)
	{
		/*String empSelect = "select empid,firstname,lastname from EMP where empid=?";
		

		List emps = simpleJdbctemplate.query(empSelect,new ParameterizedRowMapper() {
			
			public Object mapRow(ResultSet rs,int rowNum) throws SQLException,DataAccessException
			{
				Employee emp = new Employee();
				
				emp.setEmpid(rs.getInt(1));
				emp.setFirstname(rs.getString(2));
				emp.setLastname(rs.getString(3));
				
				return emp;
			}
			
		},empid );
		
		return emps.get(0); */
		return null;
	}

	
	
}

/*
 
CREATE TABLE "EMP"
(
	empid INTEGER NOT NULL,
	firstname VARCHAR2(100) NOT NULL,
	lastname VARCHAR2(100) NOT NULL,
	PRIMARY KEY (empid)	
)
;
  
*/