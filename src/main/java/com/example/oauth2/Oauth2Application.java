package com.example.oauth2;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class Oauth2Application {

	public static void main(String[] args) {
		System.setProperty("liquibase.databaseChangeLogTableName", "DATABASECHANGELOG");
		System.setProperty("liquibase.databaseChangeLogLockTableName", "DATABASECHANGELOGLOCK");
		SpringApplication.run(Oauth2Application.class, args);
	}

	@Bean
	public SpringLiquibase liquibase(DataSource dataSource){

		SpringLiquibase liquibase = new SpringLiquibase();

		liquibase.setDataSource(dataSource);
		liquibase.setContexts("dev");
		liquibase.setChangeLog("classpath:db-changelog.xml");

		return liquibase;
	}
}
