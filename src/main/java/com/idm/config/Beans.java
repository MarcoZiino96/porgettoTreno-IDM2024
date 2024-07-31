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
import com.idm.dao.LocomotivaDao;
import com.idm.dao.TrenoDao;
import com.idm.dao.UtenteDao;
import com.idm.dao.impl.LocomotivaDaoImpl;
import com.idm.dao.impl.TrenoDaoImpl;
import com.idm.dao.impl.UtenteDaoImpl;
import com.idm.dao.impl.VotoDaoImpl;
import com.idm.entity.Locomotiva;
import com.idm.entity.VagoneCargo;
import com.idm.entity.VagonePasseggeri;
import com.idm.entity.VagoneRistorante;

//import entity.CabinaPasseggieri;
//import entity.CabinaRistorante;
//import entity.CargoConcreto;
//import entity.LocomotivaConcreta;

import com.idm.dao.VagoneCargoDao;
import com.idm.dao.VagoneRistoranteDao;
import com.idm.dao.impl.VagoneCargoDaoImpl;
import com.idm.dao.impl.VagonePasseggeriDaoImpl;
import com.idm.dao.impl.VagoneRistoranteDaoImpl;


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
	

	@Bean
	public Locomotiva locomotiva(
			@Value("${locomotiva.potenza}") String potenza,
			@Value("${locomotiva.prezzo}") double prezzo,
			@Value("${locomotiva.lunghezza}") double lunghezza,
			@Value("${locomotiva.peso}") double peso) {
		return new Locomotiva(potenza, lunghezza, peso, prezzo);
	}
	
    @Bean
    public VagonePasseggeri vagonePasseggieri(
            @Value("${vagonePasseggeri.peso}") double peso,
            @Value("${vagonePasseggeri.prezzo}") double lunghezza,
            @Value("${vagonePasseggeri.lunghezza}") double prezzo,
            @Value("${vagonePasseggeri.numeroPosti}") int numeroPosti) {
        return new VagonePasseggeri(lunghezza,peso, prezzo, numeroPosti);
    }

    @Bean
    public VagoneRistorante VagoneRistorante(
    
            @Value("${vagoneRistorante.peso}") double peso,
            @Value("${vagoneRistorante.prezzo}") double prezzo,
            @Value("${vagoneRistorante.lunghezza}") double lunghezza,
            @Value("${vagoneRistorante.numeroTavoli}") int numeroTavoli) {
        return new VagoneRistorante(peso, lunghezza,prezzo, numeroTavoli);
    }

    @Bean
    public VagoneCargo vagoneCargo(
            @Value("${vagoneCargo.peso}") double peso,
            @Value("${vagoneCargo.prezzo}") double prezzo,
            @Value("${vagoneCargo.lunghezza}") double lunghezza,
            @Value("${vagoneCargo.capacitaMassima}") double capacitaMassima) {
        return new VagoneCargo (peso, lunghezza, prezzo, capacitaMassima);
    }
    
}
