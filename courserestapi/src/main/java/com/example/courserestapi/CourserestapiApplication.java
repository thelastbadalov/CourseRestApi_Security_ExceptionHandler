package com.example.courserestapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Course Service API",
                description = "Course Crud Services",
                version = "v1"

        )
)
public class CourserestapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourserestapiApplication.class, args);
    }

}
