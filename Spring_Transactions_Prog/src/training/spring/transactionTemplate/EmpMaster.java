package training.spring.transactionTemplate;



public class EmpMaster {
	int total_emp;
	int id_master;

	public int getTotal_emp() {
		return total_emp;
	}

	public void setTotal_emp(int total_emp) {
		this.total_emp = total_emp;
	}

	public int getId_master() {
		return id_master;
	}

	public void setId_master(int id_master) {
		this.id_master = id_master;
	}

	public EmpMaster(int total_emp, int id_master) {
		super();
		this.total_emp=this.total_emp+1;
		
	    this.id_master=id_master;	
	}

	

	

}