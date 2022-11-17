package com.example.demo;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveUser(new User(null, "johnsnow", "pass", "John Snow", new ArrayList<>()));
			userService.saveUser(new User(null, "mirasanders", "pass", "Mira Sanders", new ArrayList<>()));
			userService.saveUser(new User(null, "jay", "pass", "Jay Wolf", new ArrayList<>()));

			userService.saveRole(new Role(null, "USER"));
			userService.saveRole(new Role(null, "ADMIN"));
			userService.saveRole(new Role(null, "SUPER_ADMIN"));

			userService.addRoleToUser("johnsnow", "USER");
			userService.addRoleToUser("mirasanders", "USER");
			userService.addRoleToUser("mirasanders", "ADMIN");
			userService.addRoleToUser("jay", "USER");
			userService.addRoleToUser("jay", "ADMIN");
			userService.addRoleToUser("jay", "SUPER_ADMIN");
		};
	}
}
