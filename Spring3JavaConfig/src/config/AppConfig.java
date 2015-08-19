package config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import helloI.HelloWorld;
import hello.impl.HelloWorldImpl;

@Configuration
public class AppConfig {
	
	@Bean(name="helloBean")
    public HelloWorld helloWorld() {
        return new HelloWorldImpl();
    }
	
	
	
	
}