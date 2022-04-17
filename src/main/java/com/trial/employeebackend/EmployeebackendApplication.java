package com.trial.employeebackend;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class EmployeebackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeebackendApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		
		// Return a prepared Docket instance.
		// Swagger will look into this instance and then it will create a document.
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.trial.employeebackend.controller"))
				.build()
				.apiInfo(apiDetails());
		
	}
	
	//@SuppressWarnings("deprecation")
	public ApiInfo apiDetails() {
		return new ApiInfo("Employee API Documentation",
							"Performs all basic CRUD operations. Intended to automate the maintainence of Employee Database",
							"1.0",
							"fhswvfiw",
							null,
							"API Liscence",
							null,
							Collections.emptyList());
				}
				
}
