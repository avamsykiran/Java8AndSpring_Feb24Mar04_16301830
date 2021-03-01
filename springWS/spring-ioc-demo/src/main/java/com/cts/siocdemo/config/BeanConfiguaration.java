package com.cts.siocdemo.config;

import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.cts.siocdemo.service")
@PropertySource("classpath:application.properties")
public class BeanConfiguaration {
	
	   @Bean        
       public Random random(){   
           return new Random();
       }   

}
