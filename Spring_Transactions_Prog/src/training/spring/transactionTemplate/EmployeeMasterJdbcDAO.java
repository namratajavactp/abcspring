package training.spring.transactionTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.support.TransactionTemplate;

public class EmployeeMasterJdbcDAO extends JdbcDaoSupport implements EmployeeMasterDAO {

	public int incrementEmpMaster(EmpMaster e) {
		JdbcTemplate jt = getJdbcTemplate();
		String sql = "insert into emp_master(total_emp,id_master)  values (?, ?)";
        Object[] params = new Object[] { e.getTotal_emp(), e.getId_master()};
        int[] types = new int[] { Types.INTEGER, Types.INTEGER };
        return jt.update(sql, params, types);
	}

	
}

