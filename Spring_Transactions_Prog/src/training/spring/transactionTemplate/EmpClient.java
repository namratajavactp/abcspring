package training.spring.transactionTemplate;
import java.util.Iterator;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class EmpClient {

	public static void main(String[] args)  throws Exception {

	    ApplicationContext ctx = new ClassPathXmlApplicationContext("tx-transaction.xml");
	    EmployeeService employeeService = (EmployeeService)ctx.getBean("employeeService");
		 //EmployeeJdbcDAO empDao = new EmployeeJdbcDAO();
		 //empDao.setDataSource(ds);

/*		 Iterator empIter = employeeService.getAllEmployees().iterator();
		 while (empIter.hasNext()) {
			Emp emp = (Emp)empIter.next();
			System.out.println(emp.getEname()+" ("+emp.getJob()+")");
		 }
		 
		 System.out.println("The Salary Sum = "+employeeService.getSalarySum()); */
		 
		 Emp emp = new Emp(8999,"Lata","SALESMAN",2000);
		 EmpMaster em=new EmpMaster(1,4);
		 employeeService.insertEmp(emp,em);
		 
	}// main
}//EmployeeClient