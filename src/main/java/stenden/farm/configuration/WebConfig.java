package stenden.farm.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

// This is a configuration class
@Configuration
// We want Spring to enable Spring MVC
@EnableWebMvc
// We're scanning for Spring beans in the stenden.spring package
@ComponentScan(basePackages = "stenden.farm")
// We're telling the application to read properties from application.properties,
// which we have placed in the resources directory
@PropertySource("classpath:application.properties")
public class WebConfig {

}
