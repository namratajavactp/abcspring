package training.spring.transactionTemplate;
import java.util.List;

public interface EmployeeDAO {

    public long getSalarySum();
    public List getAllEmployees ();
    public int insertEmp(Emp e);
}
