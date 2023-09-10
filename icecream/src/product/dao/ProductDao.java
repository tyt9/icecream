package product.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import product.model.Product;

public class ProductDao {

	private JdbcTemplate jdbcTemplate;
	
	public ProductDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Product> select() {
		String sql = "select * from icecream.product";
		List<Product> list = jdbcTemplate.query(sql, new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				return product;
			}
			
		});
		return list.isEmpty() ? null : list;
	}
	
	private Product selectById(String id) {
		String sql = "select * from icecream.product where ProductID = ?";
		List<Product> list = jdbcTemplate.query(sql, new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				return product;
			}
			
		},id);
		return list.isEmpty() ? null : list.get(0);
	}
	
	public int selectPriceById(String id) {
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
	
	public int selectQuantityById(String id) {
		String sql = "select * from icecream.product where ProductID = ?";
		List<Product> list = jdbcTemplate.query(sql, new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product(rs.getString(1), rs.getString(2),
						rs.getInt(3), rs.getInt(4));
				return product;
			}
			
		},id);
		return list.isEmpty() ? null : list.get(0).getStockQuantity();
	}
	
	public void updateProductStock(String id, int quantity) {
		String sql = "update product set stockquantity = stockquantity + ? where productid = ?";
		jdbcTemplate.update(sql,quantity,id);
	}
	
	public void insertIcecream(Product product) {
		String sql = "insert into icecream.product(ProductID,ProductName,Price,StockQuantity)"
				+ " values(?,?,?,0)";
		jdbcTemplate.update(sql,product.getProductId(),product.getProductName(),product.getPrice());
	}
}
