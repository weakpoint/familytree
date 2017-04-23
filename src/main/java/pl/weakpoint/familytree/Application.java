package pl.weakpoint.familytree;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
 
@Configuration
@EnableAutoConfiguration
@EnableMongoRepositories
@ComponentScan(basePackages = "pl.weakpoint.familytree")
@EnableWebMvc
@PropertySource("classpath:spring.properties")
public class Application  extends WebMvcConfigurerAdapter {
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/index.html").addResourceLocations("/");
	    registry.addResourceHandler("/images/**").addResourceLocations("/images/");
	    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	    registry.addResourceHandler("/css/**").addResourceLocations("/css/");
	    registry.addResourceHandler("/js/**").addResourceLocations("/js/");
		registry.addResourceHandler("/lib/**").addResourceLocations("/lib/");
		registry.addResourceHandler("/views/**").addResourceLocations("/views/");
	}
}