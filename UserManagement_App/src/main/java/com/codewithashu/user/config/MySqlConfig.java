package com.codewithashu.user.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@Configuration // we can declaire bean
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "entityManagerFactoryBean",
//        basePackages ={"com.codewithashu.user.repository"},
//        transactionManagerRef = "transactionManager"
//        )
public class MySqlConfig {
        	
        	
        	
	/*
	 * @Autowired private Environment environment;
	 * 
	 * //datasource
	 * 
	 * @Bean
	 * 
	 * @Primary public DataSource dataSource(){
	 * 
	 * DriverManagerDataSource driverManagerDataSource = new
	 * DriverManagerDataSource();
	 * driverManagerDataSource.setUrl(environment.getProperty(
	 * "spring.datasource.url"));
	 * driverManagerDataSource.setDriverClassName(environment.getProperty(
	 * "spring.datasource.driver-class-name"));
	 * driverManagerDataSource.setUsername(environment.getProperty(
	 * "spring.datasource.username"));
	 * driverManagerDataSource.setPassword(environment.getProperty(
	 * "spring.datasource.password"));
	 * 
	 * 
	 * 
	 * DriverManagerDataSource driverManagerDataSource = new
	 * DriverManagerDataSource();
	 * driverManagerDataSource.setUrl(environment.getProperty(
	 * "second.datasource.url"));
	 * driverManagerDataSource.setDriverClassName(environment.getProperty(
	 * "second.datasource.driver-class-name"));
	 * driverManagerDataSource.setUsername(environment.getProperty(
	 * "second.datasource.username"));
	 * driverManagerDataSource.setPassword(environment.getProperty(
	 * "second.datasource.password"));
	 * 
	 * 
	 * 
	 * return driverManagerDataSource;
	 * 
	 * 
	 * }
	 * 
	 * //entityManagerFactory
	 * 
	 * @Bean(name = "entityManagerFactoryBean") public
	 * LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
	 * 
	 * LocalContainerEntityManagerFactoryBean bean = new
	 * LocalContainerEntityManagerFactoryBean();
	 * 
	 * bean.setDataSource(dataSource());
	 * 
	 * JpaVendorAdapter adapter=new HibernateJpaVendorAdapter();
	 * bean.setJpaVendorAdapter(adapter);
	 * 
	 * Map<String, String> props = new HashMap<>();
	 * props.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
	 * props.put("hibernate.show_sql","true");
	 * props.put("hibernate.hbm2ddl.auto","update");
	 * 
	 * bean.setJpaPropertyMap(props);
	 * bean.setPackagesToScan("com.codewithashu.user.model");
	 * 
	 * return bean;
	 * 
	 * }
	 * 
	 * 
	 * //platformTransactionManager
	 * 
	 * @Primary
	 * 
	 * @Bean(name="transactionManager") public PlatformTransactionManager
	 * transactionManager() {
	 * 
	 * JpaTransactionManager manager=new JpaTransactionManager();
	 * manager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
	 * 
	 * return manager; }
	 */
}
