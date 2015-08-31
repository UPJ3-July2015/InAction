package net.lermex.inaction.config;

import static org.springframework.context.annotation.ComponentScan.Filter;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;

import net.lermex.inaction.Application;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackageClasses = Application.class, excludeFilters = @Filter({Controller.class, Configuration.class}))
class ApplicationConfig {
	
//	@Bean
//	public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
//		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
//		ppc.setLocation(new ClassPathResource("/persistence.properties"));
//		return ppc;
//	}
	
	@Bean
	public EntityManagerFactory getCurrentEMF() {
		return Persistence.createEntityManagerFactory("app");
	}
	
	
}