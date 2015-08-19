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
        
        JpaTransactionManager tm = (JpaTransactionManager)factory.getBean("transactionManager");
        //if null argument is passed to getTransaction, then
        //DefaultTransactionDefinition instance is created in AbstractPlatformTransactionManager
        //where propagationBehavior = 0 and isolationLevel = -1;
        //getTransaction() will call doGetTransaction() and then doBegin() internally
        TransactionStatus ts = tm.getTransaction(null);
        
        
        //System.out.println("is completed bf::" + ts.isCompleted());
        //System.out.println("is new::" + ts.isNewTransaction());
        empdao.insertRecord(emp);
        /*System.out.println("is completed af::" + ts.isCompleted());
        System.out.println("is local rollback only::" + ((DefaultTransactionStatus)ts).isLocalRollbackOnly());
       
        System.out.println("is global rollback only::" + ((DefaultTransactionStatus)ts).isGlobalRollbackOnly());*/
        
        tm.commit(ts);
        System.out.println("Transaction is successfully committed");
        // emp.setFirstname("banesh");
        //empdao.updateRecord(emp);
        
        //System.out.println(empdao.retrieveRecord(1213));
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
