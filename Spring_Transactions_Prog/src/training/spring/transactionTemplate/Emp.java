package training.spring.transactionTemplate;

import java.util.Date;

public class Emp {
	String ename;

	public Emp(int empno, String ename, String job, int sal) {
		super();
		this.ename = ename;
		this.job = job;
		this.sal = sal;
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	String job;
	int sal;
	int empno;

	public Emp() {
	}

}