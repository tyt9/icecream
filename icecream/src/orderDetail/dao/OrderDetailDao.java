package orderDetail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import toppingDetailDao.ToppingDetailDao;

public class OrderDetailDao {

	private JdbcTemplate jdbcTemplate;
	
	public OrderDetailDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Autowired
	private ToppingDetailDao toppingDetailDao;
	
	public void createOrderDetail(String json, int orderId) {
		
		Number keyValue = 0;
		String sql = "";
//		System.out.println(json);
//		List<String> pdList = new ArrayList<String>();
		String jsonList[] = splitString(json);
		for(String list : jsonList) {
			System.out.println(list);
		}
		 for(int j=1;j<=jsonList.length;j++) {
			 List<String> list = splitAndFilterValues(json, Integer.toString(j));
			 if(list.isEmpty()) {
//				 System.out.println("list.isEmpty()");
			 }else {
				 sql = "insert into orderdetail(detailId,orderId,productId,quantity) "
					 		+ " values(0,"+orderId+",'"+list.get(0)+"',1)";
				 
//					 jdbcTemplate.update(sql);
					 KeyHolder keyHolder = new GeneratedKeyHolder();
					 final String sql1 = sql;
						jdbcTemplate.update(new PreparedStatementCreator() {
							
							@Override
							public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
								PreparedStatement pstmt = con.prepareStatement(sql1,
										new String[] { "ID" });
								return pstmt;
							}
						}, keyHolder);
						keyValue = keyHolder.getKey();
						String key = String.valueOf(keyValue);
						int keyId = Integer.parseInt(key);
						toppingDetailDao.createToppingDetail(json, keyId, list);
			 }
			 
		 }
	}
	
	private List<String> splitAndFilterValues(String input, String prefix) {
        List<String> values = new ArrayList<>();
        
        String[] parts = splitString(input);

        for (int i = 0; i < parts.length; i += 2) {
            String key = parts[i];
            if (key.startsWith(prefix)) {
                values.add(parts[i + 1]);
            }
        }
        
        return values;
    }

    private String[] splitString(String input) {
        return input.split("[=&]");
    }
    
    public List<String> selectProductIdByOrderID(int orderId){
    	String sql = "select productId from orderdetail where orderId = "+orderId;
    	List<String> list = jdbcTemplate.query(sql, new RowMapper<String>() {

			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				String product = rs.getString("productId");
				return product;
			}
    		
    	});
    	return list;
    }
    
    public List<Integer> selectDetailIdsByOrderID(int orderId){
    	String sql = "select detailId from orderdetail where orderId = "+orderId;
    	List<Integer> list = jdbcTemplate.query(sql, new RowMapper<Integer>() {

			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				int detailId = rs.getInt("detailID");
				return detailId;
			}
    		
    	});
    	return list;
    }
}
