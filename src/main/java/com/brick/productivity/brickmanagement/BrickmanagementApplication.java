package com.brick.productivity.brickmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BrickmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrickmanagementApplication.class, args);
	}

}
