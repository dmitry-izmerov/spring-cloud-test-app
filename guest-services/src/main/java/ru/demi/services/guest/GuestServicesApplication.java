package ru.demi.services.guest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.any;

@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
public class GuestServicesApplication {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
            .groupName("Guest")
            .select()
            .apis(RequestHandlerSelectors.basePackage("ru.demi.services.guest"))
            .paths(any())
            .build()
            .apiInfo(new ApiInfo(
                "Guest Services",
                "A set of services to provide data access to guests",
                "1.0.0",
                null,
                new Contact("Dmitry Izmerov", "https://www.linkedin.com/in/dmitryizmerov/", null),
                null,
                null,
                Collections.emptyList()
            ));
    }

	public static void main(String[] args) {
		SpringApplication.run(GuestServicesApplication.class, args);
	}
}
