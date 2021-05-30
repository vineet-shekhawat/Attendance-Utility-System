package com.attendanceUtilitySystem.utility;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.attendanceUtilitySystem.utility.dao"})
public class UtilityApplication {

	public static void main(String[] args) {
		SpringApplication.run(UtilityApplication.class, args);
	}

}
