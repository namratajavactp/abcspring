import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.emp.Employee;
import com.emp.dao.EmployeeDAO;
import com.emp.dao.IDAO;


public class EmployeeTest {

	public static void main(String[] args)
	{
		Resource resource = new FileSystemResource(".\\config\\employees.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
        Employee emp = (Employee) factory.getBean("employee");
        
        IDAO empdao = (EmployeeDAO)factory.getBean("idao");
        
        
        empdao.insertRecord(emp);
        
  /*      emp.setFirstname("banesh");
        
        empdao.updateRecord(emp);
        
        System.out.println(empdao.retrieveRecord(1213));   */
        
		
	}
	
	
}
