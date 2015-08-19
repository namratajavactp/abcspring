package training.spring.transactionTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.support.TransactionTemplate;

public class EmployeeJdbcDAO extends JdbcDaoSupport implements EmployeeDAO {

	public long getSalarySum() {
		JdbcTemplate jt = getJdbcTemplate();
		return jt.queryForLong("select sum(sal) from employee");
	}

	@SuppressWarnings("unchecked")
	public List getAllEmployees() {
		JdbcTemplate jt = getJdbcTemplate();
		return jt.query("select empno, ename, job, sal from employee", new EmployeeRowMapper());
	}
	
	@SuppressWarnings("unchecked")
	class EmployeeRowMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int index) throws SQLException {
			Emp emp = new Emp();
			emp.setEmpno(rs.getInt(1));
			emp.setEname(rs.getString(2));
			emp.setJob(rs.getString(3));
			emp.setSal(rs.getInt(4));
			return emp;
		}
	}

	public int insertEmp(Emp e) {
		JdbcTemplate jt = getJdbcTemplate();
		String sql = "insert into employee (empno, ename, job, sal)  values (?, ?, ?, ?)";
        Object[] params = new Object[] { e.getEmpno(), e.getEname(), e.getJob(),e.getSal()};
        int[] types = new int[] { Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.INTEGER };
        return jt.update(sql, params, types);
	}
}

