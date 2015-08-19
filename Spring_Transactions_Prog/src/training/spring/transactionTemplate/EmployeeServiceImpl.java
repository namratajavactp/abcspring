package training.spring.transactionTemplate;

import java.util.List;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDAO employeeDAO;
	
	EmployeeMasterDAO empDao;
	public EmployeeMasterDAO getEmpDao() {
		return empDao;
	}


	public void setEmpDao(EmployeeMasterDAO empDao) {
		this.empDao = empDao;
	}

	TransactionTemplate txTemplate;
	
	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}

	
	public TransactionTemplate getTxTemplate() {
		return txTemplate;
	}

	public void setTxTemplate(TransactionTemplate txTemplate) {
		this.txTemplate = txTemplate;
	}
	
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	  
	public EmployeeServiceImpl() {}

	
	public List getAllEmployees() {
		List emps = employeeDAO.getAllEmployees();
		return emps;
	}// getAllEmployees()

	public long getSalarySum() {
		return employeeDAO.getSalarySum();
	}// getSalarySum

	public int insertEmp(final Emp e,final EmpMaster x) {
       
		txTemplate.execute(new TransactionCallback<Void>() {

			public Void doInTransaction(TransactionStatus txStatus) {
				try {
					System.out.print("Am in transaction");
					employeeDAO.insertEmp(e);
					System.out.println("employee inserted");
					empDao.incrementEmpMaster(x);
					System.out.println("empmaster incremented");
				} catch (RuntimeException e) {
					txStatus.setRollbackOnly();
					throw e;
				}
				return null;
			}
		});
		return 0;
/*
		employeeDAO.insertEmp(e);
		System.out.println("employee inserted");
		empDao.incrementEmpMaster(x);
		System.out.println("empmaster incremented");
		return 1;*/
	}


	
}