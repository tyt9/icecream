package login.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import login.model.Admin;


public class AdminDao {

	private JdbcTemplate jdbcTemplate;
	
	public AdminDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Admin selectById(String id) {
		String sql = "select * from admin where adminId = ?";
		List<Admin> result = jdbcTemplate.query(sql, new RowMapper<Admin>() {

			@Override
			public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
				Admin admin = new Admin(rs.getString("adminId"),
						rs.getString("name"), rs.getString("password"), 
						rs.getTimestamp("regdate"));
				return admin;
			}
			
		},id);
		return result.isEmpty() ? null : result.get(0);
	}
}
