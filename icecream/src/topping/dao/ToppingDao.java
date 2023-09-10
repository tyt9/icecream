package topping.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import product.model.Product;
import topping.model.Topping;

public class ToppingDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public ToppingDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Topping> select() {
		String sql = "select * from icecream.topping";
		List<Topping> list = jdbcTemplate.query(sql, new RowMapper<Topping>() {

			@Override
			public Topping mapRow(ResultSet rs, int rowNum) throws SQLException {
				Topping topping = new Topping(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				return topping;
			}
			
		});
		return list.isEmpty() ? null : list;
	}
	
	public Topping selectById(String id) {
		String sql = "select * from icecream.topping where toppingID = ?";
		List<Topping> list = jdbcTemplate.query(sql, new RowMapper<Topping>() {

			@Override
			public Topping mapRow(ResultSet rs, int rowNum) throws SQLException {
				Topping topping = new Topping(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				return topping;
			}
			
		},id);
		return list.isEmpty() ? null : list.get(0);
	}
	
	public int selectAdditionalPriceById(String id) {
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
	
//	public int selectQuantityById(String id) {
//		String sql = "select * from icecream.topping where toppingID = ?";
//		List<Product> list = jdbcTemplate.query(sql, new RowMapper<Product>() {
//
//			@Override
//			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Product product = new Product(rs.getString(1), rs.getString(2),
//						rs.getInt(3), rs.getInt(4));
//				return product;
//			}
//			
//		},id);
//		return list.isEmpty() ? null : list.get(0).getStockQuantity();
//	}
//	
//	public void updateProductStock(String id, int quantity) {
//		String sql = "update product set stockquantity = stockquantity + ? where productid = ?";
//		jdbcTemplate.update(sql,quantity,id);
//	}
	
	public void insertTopping(Topping topping) {
		String sql = "insert into icecream.topping(toppingID,toppingName,AdditionalPrice,StockQuantity)"
				+ " values(?,?,?,0)";
		jdbcTemplate.update(sql,topping.getToppingId(),topping.getToppingName(),topping.getAdditionalPrice());
	}
}
