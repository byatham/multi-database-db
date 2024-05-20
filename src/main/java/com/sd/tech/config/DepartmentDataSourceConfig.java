package com.sd.tech.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration 
@EnableTransactionManagement  
@EnableJpaRepositories(
        entityManagerFactoryRef = "departmentEntityManagerFactory",  
        transactionManagerRef = "departmentTransactionManager",  
        basePackages = { "com.sd.tech.repository.dept" })  
public class DepartmentDataSourceConfig{  
    
    @Bean(name = "departmentProperties")  
    @ConfigurationProperties("spring.datasource.department")  
    public DataSourceProperties dataSourceProperties() 
    { 
    	return new DataSourceProperties();
    	}  
    
    
     
    @Bean(name = "departmentDatasource")  
    @ConfigurationProperties(prefix = "spring.datasource.department")  
    public DataSource datasource(@Qualifier("departmentProperties") DataSourceProperties properties) {  
        return properties.initializeDataSourceBuilder()  
            .build();  
    } 
    
 
    
    @Bean(name = "departmentEntityManagerFactory")  
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder builder, @Qualifier("departmentDatasource")  DataSource dataSource)
    {
        Map<String, Object> jpaProps = new HashMap<>();  
            
        jpaProps.put("hibernate.hbm2ddl.auto", "update");  
        jpaProps.put("spring.jpa.database-platform", "org.hibernate.dialect.H2Dialect");  
        return builder.dataSource(dataSource)  
            .properties(jpaProps)  
            .packages("com.sd.tech.entity.dept","com.sd.tech.entity.greet" )  
            .persistenceUnit("department").build();  
    }  
   
 
    
    @Bean(name = "departmentTransactionManager")  
    public PlatformTransactionManager transactionManager(  
            @Qualifier("departmentEntityManagerFactory") EntityManagerFactory entityManagerFactory)
    {
        return new JpaTransactionManager(entityManagerFactory);  
    }  

    
}