package poll.core;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EntityScan("poll.*")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class PollConfig {
	
	@Value("$spring.datasource.driver-class-name") String driverClassName;
	@Value("$spring.datasource.url") String url;
	@Value("$spring.datasource.username") String username;
	@Value("$spring.datasource.password") String password;
	@Bean(name="dataSource")
	public DataSource getDataSource(){
		DataSource ds = DataSourceBuilder
			.create()
			.username(username)
			.password(password)
			.url(url)
			.build();
		return ds;
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource){
		LocalSessionFactoryBuilder sfb = 
				new LocalSessionFactoryBuilder(dataSource);
		sfb.scanPackages("poll.models.*");
		return sfb.buildSessionFactory();
	}
	
	@Bean(name="hibernateTransactionManager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sf ){
		HibernateTransactionManager htm = new HibernateTransactionManager(sf);
		return htm;
	}
}
