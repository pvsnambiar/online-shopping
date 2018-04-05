package net.pvsm.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"net.pvsm.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	/**
	 * Based on the db which you use
	 */
	private final static String DATABASE_URL="jdbc:h2:tcp://localhost/~/onlineshoppingdb";
	private final static String DATABASE_DRIVER="org.h2.Driver";
	private final static String DATABASE_DIALET="org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME="sa";
	private final static String DATABASE_PASSWORD="";
	
	/**
	 * DataSource bean
	 * @return
	 */
	@Bean
	public DataSource getDataSource(){
		BasicDataSource dataSource= new BasicDataSource();
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		
		return dataSource;
	}
	
	/**
	 * Session Factory bean
	 */
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource){
		
		LocalSessionFactoryBuilder builder= new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("net.pvsm.shoppingbackend.dto");
		
		return builder.buildSessionFactory();
		
	}

	/**
	 * All the hibernate properties will be returned 
	 * @return
	 */
	private Properties getHibernateProperties() {
		
		Properties properties= new Properties();
		
		properties.put("hibernate.dialect", DATABASE_DIALET);
		properties.put("hibernate.show_sql", "true");
		
		return properties;
	}
	
	/**
	 * Transaction Manager Bean
	 * @return
	 */
	@Bean
	public HibernateTransactionManager getTransactionManagemer(SessionFactory sf){
		
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sf);
		
		return transactionManager;
		
		
	}
	
	

}
