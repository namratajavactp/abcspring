package com.emp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import com.emp.Employee;

public class EmployeeDAO implements IDAO {

	private SimpleJdbcTemplate simpleJdbctemplate;
	
	public void setJdbcTemplate(SimpleJdbcTemplate  simpleJdbctemplate)
	{
		this. simpleJdbctemplate =  simpleJdbctemplate;
	}
	
	public void insertRecord(Object obj) {
		// TODO Auto-generated method stub
		String empInsert = "insert into EMP (empid,firstname,lastname) values (?,?,?)";
		
		if(obj instanceof Employee)
		{
		
			//No need to catch as it is RunTime Exception, but you CAN if you can handle it	
			try
			{	
				Employee emp = (Employee)obj;
				simpleJdbctemplate.update(empInsert,new Object[] {emp.getEmpid(),emp.getFirstname(),emp.getLastname()});
			}
			
			//if DataBase is not running or there is some connectivity issue
			catch(CannotGetJdbcConnectionException exp)
			{
				exp.printStackTrace();
			}
			//if sql is incorrect or mentioned table is not created in underlying database
			catch(UncategorizedSQLException uexp)
			{
				uexp.printStackTrace();
			}
			//DataIntegrityViolationException will be thrown if constraint violation is there
			
		}
		
	}
	
	public void updateRecord(Object obj)
	{
		String empUpdate = "update EMP set  firstname=?, lastname=?  where empid=?";
		
		if(obj instanceof Employee)
		{
			Employee emp = (Employee)obj;
			simpleJdbctemplate.update(empUpdate,new Object[] {emp.getFirstname(),emp.getLastname(),emp.getEmpid()});
		}
	}

	
	public Object retrieveRecord(int empid)
	{
		String empSelect = "select empid,firstname,lastname from EMP where empid=?";
		

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
		
		return emps.get(0);
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