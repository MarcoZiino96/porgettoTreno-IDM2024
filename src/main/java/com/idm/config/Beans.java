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

import com.idm.dao.LocomotivaDao;
import com.idm.dao.TrenoDao;
import com.idm.dao.UtenteDao;
import com.idm.dao.VagonePasseggeriDao;
import com.idm.dao.impl.LocomotivaDaoImpl;
import com.idm.dao.impl.TrenoDaoImpl;
import com.idm.dao.impl.UtenteDaoImpl;
import com.idm.dao.impl.VagonePasseggeriImpl;

@Configuration
@ComponentScan(basePackages = "com.idm")
@EnableTransactionManagement

public class Beans {

	@Bean(name="dataSource")
	public DataSource getDataSource () {

		DriverManagerDataSource ds = new DriverManagerDataSource(); 
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("root");
		ds.setUrl("jdbc:mysql://localhost:3306/prova_treno");
		return ds; 
	} 

	@Bean(name="entityManager")
	public LocalContainerEntityManagerFactoryBean  getEntityManager(){

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		// JDBC
		factory.setDataSource(getDataSource());  

		// imposta il dialogo tra JPA e hibernate
		factory.setJpaVendorAdapter(getJpaVendorAdapter()); // imposta il dialogo tra JPA e hibernate

		// impostare il luogo dove si trovano i bean (entità del DB)
		//factory.setPackagesToScan(this.getClass().getPackage().getName()); 
		factory.setPackagesToScan("com.idm.entity"); 
		return factory; 
	} 	


	private HibernateJpaVendorAdapter getJpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);   // obbligatorio: serve per tradurre le query nel particolare Dialetto

		adapter.setGenerateDdl(true);          //facoltativo, attiva il DDL cio� hibernate creaer� le strutture nel DB se non sono gi� essitenti
		adapter.setShowSql(false);              // mostra l'SQL, comodo per i corsi e per il debug ma in produzione solitamente � a false 
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

	@Bean(name="UtenteDao")
	public UtenteDao getUtenteDao() {
		UtenteDao dao = new UtenteDaoImpl();
		return dao;
	}


		@Bean(name= "TrenoDao")
		public TrenoDao getTrenoDao() {
			TrenoDao dao = new TrenoDaoImpl();
			return dao;
		}

		@Bean(name="LocomotivaDao")
		public LocomotivaDao getLocomotivaDao() {
			LocomotivaDao dao = new LocomotivaDaoImpl();
			return dao;
		}

	}
