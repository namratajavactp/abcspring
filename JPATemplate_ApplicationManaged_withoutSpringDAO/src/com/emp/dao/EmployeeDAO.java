package com.emp.dao;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.emp.Employee;

@Transactional
public class EmployeeDAO extends JpaDaoSupport implements IDAO {

	private JpaTemplate jpaTemplate;
	
	
	
	public void insertRecord(Object obj) {
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
			    System.out.println("bfore commting:"+emp.getFirstname());
			    System.out.println("now gonna persist employee");
				//getJpaTemplate().persist(emp);
			    
			 //   EntityManager mg=getJpaTemplate().getEntityManager();
			   // EntityTransaction et=mg.getTransaction();
			    //et.begin();
			    getJpaTemplate().persist(emp);
				System.out.println("employee is persisted");
	
			//	et.commit();
			    
			    //Code below is Hibernate with JPA
			    /*Map myProperties = new HashMap();
			    myProperties.put("hibernate.hbm2ddl.auto", "create-drop");
			    
			    
				System.out.println("am inside insertRecord() method ...");
			    EntityManagerFactory emf = Persistence.createEntityManagerFactory("empperunit",myProperties);
			    System.out.println("emf:::" + emf);
			    EntityManager em = emf.createEntityManager();
			    System.out.println("em:::" + em);
			    EntityTransaction tx = em.getTransaction();
			    tx.begin();
			    
			    em.persist(emp);
			    tx.commit();
			    em.close();*/
				

				//jpaTemplate.update(empInsert,new Object[] {emp.getEmpid(),emp.getFirstname(),emp.getLastname()});
			}
			catch(Exception exp)
			{
				exp.printStackTrace();
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
		
		Employee e=(Employee)getJpaTemplate().find(com.emp.Employee.class,empid);
		System.out.println(e.getFirstname());
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