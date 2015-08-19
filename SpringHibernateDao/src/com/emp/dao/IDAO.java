package com.emp.dao;

public interface IDAO {
	public void insertRecord(Object obj) throws Exception;
	
	public void updateRecord(Object obj);
	
	public Object retrieveRecord(int empid);
	
	
}
