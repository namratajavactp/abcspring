import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionStatus;

import com.emp.Employee;
import com.emp.dao.EmployeeDAO;
import com.emp.dao.IDAO;


public class EmployeeTest {

	public static void main(String[] args)
	{
		try
		{
		Resource resource = new FileSystemResource(".\\config\\employees.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
        Employee emp = (Employee) factory.getBean("employee");
		
        IDAO empdao = (EmployeeDAO)factory.getBean("idao");
        
        System.out.println("dao is retrieved successfully ........");
        
       
        empdao.insertRecord(emp);
       
        System.out.println("Transaction is successfully committed");
       
		}
		catch(TransactionException trexp)
		{
			trexp.printStackTrace();
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
        
		
	}
	
	
}
