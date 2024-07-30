package com.idm.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
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
@ComponentScan(basePackages = "com.idm")
@EnableTransactionManagement

public class Beans {
    
@Bean(name="dataSource")
	public DataSource getDataSource () {
		
		DriverManagerDataSource ds = new DriverManagerDataSource(); 
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("mysqlcorsoidm");
		ds.setUrl("jdbc:mysql://localhost:3306/gestione_treno");
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
