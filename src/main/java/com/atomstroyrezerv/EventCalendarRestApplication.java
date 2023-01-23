package com.atomstroyrezerv;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Event calendar API", version = "1.0", description = "Event calendar web service"))
public class EventCalendarRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventCalendarRestApplication.class, args);
    }
}
