package com.joker.hibernate;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @author fcortez
 *
 */
@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:hibernate.properties" })
@ComponentScan({ "com.joker.hibernate" })
public class PersistenceConfig {
	
	@Autowired
	private Environment env;
	
	public PersistenceConfig(){
		super();
	}
	
    @Bean
    public DataSource restDataSource() {
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
        
        dataSource.setUrl(env.getProperty("connection.url"));
        dataSource.setUsername(env.getProperty("connection.username"));
        dataSource.setPassword(env.getProperty("connection.password"));
        dataSource.setDriverClassName("org.hibernate.dialect.Oracle10gDialect");
        
        return dataSource;
    }
    
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(restDataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.joker.hibernate.model" });
        sessionFactory.setHibernateProperties(getHibernateProperties());

        return sessionFactory;
    }
   
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(final SessionFactory sessionFactory) {
    	
        final HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        
        return transactionManager;
        
    }
    
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
    	return new PersistenceExceptionTranslationPostProcessor();
    }
    
	@Bean
	public Properties getHibernateProperties(){
		
		Properties props = new Properties();
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		
		return props;
	}
}	
