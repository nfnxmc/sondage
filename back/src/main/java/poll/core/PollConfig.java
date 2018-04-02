package poll.core;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EntityScan("poll.*")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class PollConfig {
	
	@Value("${spring.datasource.driver-class-name}") private String driverClassName;
	@Value("${spring.datasource.url}") private String url;
	@Value("${spring.datasource.username}") private String username;
	@Value("${spring.datasource.password}") private String password;
	
	@Bean(name="testSourceValues")
	@Order(value=0)
	public Object testSourceValues(){
		Logger logger = LoggerFactory.getLogger(PollApplication.class);
		logger.debug(" ==================> " + driverClassName);
		return null;
	}
	@Bean(name="dataSource")
	public DataSource getDataSource(){
		
		DataSourceBuilder dsb= DataSourceBuilder.create();
			dsb = dsb.driverClassName(driverClassName);
			dsb = dsb.username(username);
			dsb = dsb.password(password);
			dsb = dsb.url(url);
			
		return dsb.create().build();
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource){
		LocalSessionFactoryBuilder sfb = 
				new LocalSessionFactoryBuilder(dataSource);
		sfb.scanPackages("poll.models.*");
		sfb.configure("hibernate.cfg.xml");
		return sfb.buildSessionFactory();
	}
	
	@Bean(name="hibernateTransactionManager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sf ){
		HibernateTransactionManager htm = new HibernateTransactionManager(sf);
		return htm;
	}
}
