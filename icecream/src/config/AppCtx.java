//package config;
//
//import org.apache.tomcat.jdbc.pool.DataSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import article.dao.ArticleContentDao;
//import article.dao.ArticleDao;
//import member.dao.MemberDao;
//import member.service.ChangePasswordService;
//
//@Configuration
//@EnableTransactionManagement
//public class AppCtx {
//	
//	@Bean(destroyMethod = "close")
//	public DataSource dataSource() {
//		DataSource ds = new DataSource();
//		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		ds.setUrl("jdbc:mysql://localhost:3306/board?"
//				+ "useSSL=true&useUnicode=true&characterEncoding=utf8");
//		ds.setUsername("jspexam");
//		ds.setPassword("jsppw");
//		ds.setInitialSize(2);
//		ds.setMaxActive(10);
//		return ds;
//	}
//	
//	@Bean
//	public PlatformTransactionManager transactionManager() {
//		DataSourceTransactionManager tm = new DataSourceTransactionManager();
//		tm.setDataSource(dataSource());
//		return tm;
//	}
//	
//	@Bean
//	public MemberDao memberDao() {
//		return new MemberDao(dataSource());
//	}
//	
//	@Bean
//	public ChangePasswordService changePasswordService() {
//		return new ChangePasswordService();
//	}
//	
//	@Bean
//	public ArticleContentDao articleContentDao() {
//		return new ArticleContentDao(dataSource());
//	}
//	
//	@Bean
//	public ArticleDao articleDao() {
//		return new ArticleDao(dataSource());
//	}
//}
//
//
//
//
//
//
//
//
//
//
//
