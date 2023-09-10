package orders.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import orders.model.OrderInfo;
import product.model.Product;
import topping.model.Topping;

public class OrdersDao {

private JdbcTemplate jdbcTemplate;
	
	public OrdersDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private int selectPriceById(String id) {
		String sql = "select * from icecream.product where ProductID = ?";
		List<Product> list = jdbcTemplate.query(sql, new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product(rs.getString(1), rs.getString(2),
						rs.getInt(3), rs.getInt(4));
				return product;
			}
			
		},id);
		return list.isEmpty() ? null : list.get(0).getPrice();
	}
	
	private int selectAdditionalPriceById(String id) {
		String sql = "select * from icecream.topping where toppingID = ?";
		List<Topping> list = jdbcTemplate.query(sql, new RowMapper<Topping>() {

			@Override
			public Topping mapRow(ResultSet rs, int rowNum) throws SQLException {
				Topping topping = new Topping(rs.getString(1), rs.getString(2),
						rs.getInt(3), rs.getInt(4));
				return topping;
			}
			
		},id);
		return list.isEmpty() ? null : list.get(0).getAdditionalPrice();
	}
	
	public Number createOrder(String json) {
		String sql1 = "insert into orders values(0,now(),?,0)";

		// -- 가격 총합 구하기
		String sql = "";
		int total = 0;
		
		String jsonList[] = splitString(json);
		 for(int j=1;j<=jsonList.length;j++) {
			 List<String> list = splitAndFilterValues(json, Integer.toString(j));
			 for(int i = 0; i<list.size();i++) {
				 if(i == 0) {
					 sql = "select price from icecream.product where ProductID = '"+list.get(i)+"'";
				 }else {
					 sql = "select additionalprice from icecream.topping where toppingID = '"+list.get(i)+"'";
				 }
				 //오류 가능성
				 total = total + jdbcTemplate.queryForObject(sql, Integer.class);
			 }
		 }
		 System.out.println(total);
			
		 KeyHolder keyHolder = new GeneratedKeyHolder();
		 final int total1 = total;
			jdbcTemplate.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement pstmt = con.prepareStatement(sql1,
							new String[] { "ID" });
					
					pstmt.setInt(1, total1);
					return pstmt;
				}
			}, keyHolder);
			Number keyValue = keyHolder.getKey();
			System.out.println(keyValue);
			
			return keyValue;
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
    
//    public Orders selectById(int id) {
//    	String sql = "select * from icecream.orders where orderId = ?";
//		List<Orders> list = jdbcTemplate.query(sql,
//				(rs, n)->{
//		               return new Orders(id,
//				                  rs.getDate(2),
//				                  rs.getInt(3));
//	                 } ,id);
//		return list.isEmpty() ? null : list.get(0);
//    }
    
    public List<OrderInfo> selectOrderDetailById(int id) {
    	String sql = "SELECT "
    			+ "    o.OrderID,"
    			+ "    o.OrderDateTime,"
    			+ "    o.TotalAmount,"
    			+ "    d.DetailID,"
    			+ "    d.ProductID,"
    			+ "    p.ProductName,"
    			+ "    GROUP_CONCAT(DISTINCT t.ToppingDetailID) AS ToppingDetailID,"
    			+ "    GROUP_CONCAT(DISTINCT t.ToppingID) AS ToppingID,"
    			+ "    GROUP_CONCAT(DISTINCT top.ToppingName) AS ToppingName "
    			+ " FROM orders o "
    			+ " LEFT OUTER JOIN orderdetail d ON o.OrderID = d.OrderID "
    			+ " LEFT OUTER JOIN toppingdetail t ON d.DetailID = t.OrderDetailID"
    			+ " LEFT OUTER JOIN Product p ON d.ProductID = p.ProductID"
    			+ " LEFT OUTER JOIN Topping top ON t.ToppingID = top.ToppingID"
    			+ " WHERE o.OrderID = ? "
    			+ " GROUP BY"
    			+ "    o.OrderID,"
    			+ "    o.OrderDateTime,"
    			+ "    o.TotalAmount,"
    			+ "    d.DetailID,"
    			+ "    d.ProductID,"
    			+ "    p.ProductName";
    	
    	return jdbcTemplate.query(sql, 
				(rs,n) -> createOrderInfo(rs),id);
    }
    
    public List<OrderInfo> selectOrderInfo(int orderId) {
    	String sql = "SELECT"
    			+ "    o.OrderID,"
    			+ "    o.OrderDateTime,"
    			+ "    o.TotalAmount,"
    			+ "    d.DetailID,"
    			+ "    d.ProductID,"
    			+ "    GROUP_CONCAT(DISTINCT t.ToppingDetailID) AS ToppingDetailID,"
    			+ "    GROUP_CONCAT(DISTINCT t.ToppingID) AS ToppingID,"
    			+ "    GROUP_CONCAT(DISTINCT p.ProductName) AS ProductName, "
    			+ "    GROUP_CONCAT(DISTINCT top.ToppingName) AS ToppingName "
    			+ " FROM orders o "
    			+ " LEFT OUTER JOIN orderdetail d ON o.OrderID = d.OrderID "
    			+ " LEFT OUTER JOIN toppingdetail t ON d.DetailID = t.OrderDetailID "
    			+ " LEFT OUTER JOIN Product p ON d.ProductID = p.ProductID"
    			+ " LEFT OUTER JOIN Topping top ON t.ToppingID = top.ToppingID"
    			+ " WHERE o.OrderID = ?"
    			+ " GROUP BY "
    			+ "    o.OrderID,"
    			+ "    o.OrderDateTime,"
    			+ "    o.TotalAmount,"
    			+ "    d.DetailID,"
    			+ "    d.ProductID";
    	return jdbcTemplate.query(sql, 
				(rs,n) -> createOrderInfo(rs),orderId);
    }
    
    private OrderInfo createOrderInfo(ResultSet rs) throws SQLException {
		return new OrderInfo(rs.getInt("orderid"),
				rs.getInt("DetailID"),
				rs.getTimestamp("OrderDateTime"),
				rs.getInt("TotalAmount"),
				rs.getString("productId"),
				rs.getString("ToppingDetailID"),
				rs.getString("ToppingID"),
		rs.getString("ProductName"),
		rs.getString("ToppingName"));
	}
    
    public List<OrderInfo> selectOrderInfos() {
    	String sql = "SELECT"
    			+ "    o.OrderID,"
    			+ "    o.OrderDateTime,"
    			+ "    o.TotalAmount,"
    			+ "    d.DetailID,"
    			+ "    d.ProductID,"
    			+ "    GROUP_CONCAT(DISTINCT t.ToppingDetailID) AS ToppingDetailID,"
    			+ "    GROUP_CONCAT(DISTINCT t.ToppingID) AS ToppingID,"
    			+ "    GROUP_CONCAT(DISTINCT p.ProductName) AS ProductName, "
    			+ "    GROUP_CONCAT(DISTINCT top.ToppingName) AS ToppingName "
    			+ " FROM orders o "
    			+ " LEFT OUTER JOIN orderdetail d ON o.OrderID = d.OrderID "
    			+ " LEFT OUTER JOIN toppingdetail t ON d.DetailID = t.OrderDetailID "
    			+ " LEFT OUTER JOIN Product p ON d.ProductID = p.ProductID"
    			+ " LEFT OUTER JOIN Topping top ON t.ToppingID = top.ToppingID"
    			+ " where del = 0 "
    			+ " GROUP BY "
    			+ "    o.OrderID,"
    			+ "    o.OrderDateTime,"
    			+ "    o.TotalAmount,"
    			+ "    d.DetailID,"
    			+ "    d.ProductID"
    			+ " ORDER BY o.OrderID DESC";
    	return jdbcTemplate.query(sql, 
				(rs,n) -> createOrderInfo(rs));
    }
    
    public void deleteOrder(int id) {
    	String sql = "update orders set del = true where OrderId = ?";
    	jdbcTemplate.update(sql,id);
    }
}
