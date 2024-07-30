package com.idm.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.idm.dao.PrenotazioneDao;
import com.idm.dao.VagonePasseggeriDao;
import com.idm.dao.VotoDao;
import com.idm.dao.impl.PrenotazioneDaoImpl;
import com.idm.dao.impl.VagonePasseggeriImpl;
import com.idm.dao.impl.VotoDaoImpl;

@Configuration
@PropertySource("application.properties")
@ComponentScan(basePackages = "com.idm")
@EnableTransactionManagement

public class Beans {
	
	    @Value("${spring.datasource.url}")
	    private String url;
	    @Value("${spring.datasource.username}")
	    private String username;
	    @Value("${spring.datasource.password}")
	    private String password;
	    @Value("${spring.datasource.driver-class-name}")
	    private String driverClassName;
    
@Bean(name="dataSource")
	public DataSource getDataSource () {
		DriverManagerDataSource ds = new DriverManagerDataSource(); 
		ds.setDriverClassName(driverClassName);
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setUrl(url);
		return ds; 
	} 

@Bean(name="entityManager")
public LocalContainerEntityManagerFactoryBean  getEntityManager(){
	
	LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	 // JDBC
	 factory.setDataSource(getDataSource());  
	 
	 // imposta il dialogo tra JPA e hibernate
	 factory.setJpaVendorAdapter(getJpaVendorAdapter()); 
	
	 factory.setPackagesToScan("com.idm.entity"); 
	 return factory; 
} 	


private HibernateJpaVendorAdapter getJpaVendorAdapter() {
	HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
	adapter.setDatabase(Database.MYSQL);   
	
	adapter.setGenerateDdl(true);         
	adapter.setShowSql(true);               
	return adapter;
}	

/**** transazioni ****/
@Bean
public PlatformTransactionManager getTransactionManager(){
      JpaTransactionManager transactionManager = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(getEntityManager().getObject());
      return transactionManager;
}

///**** sezione DAO ****/

@Bean(name="vagonePasseggeri") 
public VagonePasseggeriDao getCategoriaDao (){
	VagonePasseggeriDao dao = new VagonePasseggeriImpl();
	   return dao; 
}
@Bean(name="prenotazione") 
public PrenotazioneDao getPrenotazione (){
	PrenotazioneDao dao = new PrenotazioneDaoImpl();
	   return dao; 
}
@Bean(name="voto") 
public VotoDao getVoto (){
	VotoDao dao = new VotoDaoImpl();
	   return dao; 
}

}
