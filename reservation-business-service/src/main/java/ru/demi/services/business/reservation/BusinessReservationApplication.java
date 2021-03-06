package ru.demi.services.business.reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.any;

@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class BusinessReservationApplication {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
            .groupName("RoomReservation")
            .select()
            .apis(RequestHandlerSelectors.basePackage("ru.demi.services.business.reservation"))
            .paths(any())
            .build()
            .apiInfo(new ApiInfo(
                "Room Reservation Services",
                "A set of services to provide business processes for the Room and Reservations domains",
                "1.0.0",
                null,
                new Contact("Dmitry Izmerov", "https://www.linkedin.com/in/dmitryizmerov/", null),
                null,
                null,
                Collections.emptyList()
            ));
    }


    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(BusinessReservationApplication.class, args);
    }
}
