package com.coll.config;
import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.coll.model.Blog;
import com.coll.model.BlogComment;
import com.coll.model.Forum;
import com.coll.model.ForumComment;
import com.coll.model.Friend;
import com.coll.model.UserDetail;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.coll")
public class DBConfig 
{	
	@Bean
	public DataSource getOracleDataSource()
	{
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");
		datasource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		datasource.setUsername("MYCOLL");
		datasource.setPassword("admin123");
		
		System.out.println("=====DataSource Object Created Successfully======");
		return datasource;
	}
	@Bean
	public SessionFactory getSessionFactory()
	{
		Properties prop=new Properties();
		prop.put("hibernate.hbm2ddl.auto","update");
		prop.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
		prop.put("hibernate.temp.use_jdbc_metadata_defaults","false");	 //Extra Adding In Second Project
		
		LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(getOracleDataSource());
		factory.addProperties(prop);
		factory.addAnnotatedClass(Blog.class);
		factory.addAnnotatedClass(BlogComment.class);
		factory.addAnnotatedClass(UserDetail.class);
		factory.addAnnotatedClass(Forum.class);
		factory.addAnnotatedClasses(ForumComment.class);
		factory.addAnnotatedClass(Friend.class);
		
		SessionFactory sessionFactory=factory.buildSessionFactory();
		
		System.out.println("=======SessionFactory Object Created SuccessFully=======");
		
		return sessionFactory;
	}
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		
		System.out.println("=======Hiberante Transaction Manager Created Successfully========");
		System.out.println("*****Collaboration Project Backend Configuration Runs Fine*****");
		
		return transactionManager;
	}

}
