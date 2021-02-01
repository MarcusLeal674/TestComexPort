package br.com.comexport.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("br.com.comexport.dao")
@EnableTransactionManagement
public class ComexPortConfig {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ComexPortConfig.class);
	private static final String DRIVER = "org.mariadb.jdbc.Driver";
	private static final String DB_USER_NAME = "root";
	private static final String DB_PASSWORD = "123456";
	private static final String DB_HOST = "localhost";
	private static final String DB_PORT = "3306";
	private static final String DB_DATA_BASE = "comex_port_db";
	
	
	@Bean
	public DataSource dataSourceComexPort() {
		LOGGER.info("Starting dataSourceComexPort connection");
		
		String dbUrl = "jdbc:mariadb://" + DB_HOST + ":" + DB_PORT + "/" + DB_DATA_BASE;
				
		return DataSourceBuilder.create().username(DB_USER_NAME).password(DB_PASSWORD)
				.driverClassName(DRIVER).url(dbUrl).build();
	}
	
}
