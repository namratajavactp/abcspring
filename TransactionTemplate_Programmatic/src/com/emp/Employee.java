package com.emp;

public class Employee {
	
	private int empid;
	private String firstname;
	private String lastname;
	
	public Employee()
	{
		System.out.println("am inside default constructor");
	}
	
	public String getFirstname()
	{
		return firstname;
	}
	
	public String getLastname()
	{
		return lastname;
	}
	
	public void setFirstname(String name)
	{
		firstname = name;
	}
	
	public void setLastname(String name)
	{
		lastname = name;
	}
	
	public int getEmpid()
	{
		return empid;
	}
	
	public void setEmpid(int id)
	{
		empid = id;
	}
	
	public String toString()
	{
		return "name-- "+firstname + " " + lastname;
	}

}
