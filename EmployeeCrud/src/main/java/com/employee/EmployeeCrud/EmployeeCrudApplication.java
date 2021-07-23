package com.employee.EmployeeCrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@EnableTransactionManagement
@SpringBootApplication
public class EmployeeCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeCrudApplication.class, args);
	}
	 @Bean
	    public Docket api(){
	        Docket docket=new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo())
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.employee.EmployeeCrud"))
	                .paths(PathSelectors.any())
	                .build();
	        return docket;

	    }

	    public ApiInfo getApiInfo(){
	        ApiInfo apiInfo=new ApiInfoBuilder()
	                .title("Employee mgt application")
	                .description("rest api for Employee mgt")
	                .build();
	        return apiInfo;
	    }

}
