package pl.weakpoint.familytree;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
 
@Configuration
@EnableAutoConfiguration
@EnableMongoRepositories
@ComponentScan(basePackages = "pl.weakpoint.familytree")
@EnableWebMvc
public class Application  {
	
}