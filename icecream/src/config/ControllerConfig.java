package config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import controller.LogController;
import controller.MyController;
import login.dao.AdminDao;
import login.service.LoginService;
import orderDetail.dao.OrderDetailDao;
import orders.dao.OrdersDao;
import orders.service.OrderService;
import product.dao.ProductDao;
import topping.dao.ToppingDao;
import toppingDetailDao.ToppingDetailDao;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "mybatis.dao")
public class ControllerConfig {
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/icecream?"
				+ "useSSL=true&useUnicode=true&characterEncoding=utf8");
		ds.setUsername("iceadmin");
		ds.setPassword("iceadmin");
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		return ds;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
		tm.setDataSource(dataSource());
		return tm;
	}
	
	
	@Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:config-mybatis.xml"));
        //factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/**/*.xml"));
        factoryBean.setTypeAliasesPackage("mybatis.dao");
        return factoryBean.getObject();
    }
	

	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory());
	}
	
	@Bean
	public AdminDao adminDao() {
		return new AdminDao(dataSource());
	}

	@Bean
	public MyController myController() {
		return new MyController();
	}
	
	@Bean
	public LoginService loginService() {
		return new LoginService();
	}
	
	@Bean
	public LogController logController() {
		return new LogController();
	}
	
	@Bean
	public ProductDao productDao() {
		return new ProductDao(dataSource());
	}
	
	@Bean
	public ToppingDao toppingDao() {
		return new ToppingDao(dataSource());
	}
	
	@Bean
	public OrdersDao ordersDao() {
		return new OrdersDao(dataSource());
	}
	
	@Bean
	public OrderDetailDao orderDetailDao() {
		return new OrderDetailDao(dataSource());
	}
	
	@Bean
	public ToppingDetailDao toppingDetailDao() {
		return new ToppingDetailDao(dataSource());
	}
	
	@Bean
	public OrderService orderService() {
		return new OrderService();
	}
}
