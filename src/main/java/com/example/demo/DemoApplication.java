package com.example.demo;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));
			userService.saveUser(new User(null,"Jean Mary","isai","1234",new ArrayList<>()));
			userService.saveUser(new User(null,"Jean1","isai1","1234",new ArrayList<>()));
			userService.saveUser(new User(null,"Jean2","isai2","1234",new ArrayList<>()));
			userService.saveUser(new User(null,"Jean3","isai3","1234",new ArrayList<>()));
			userService.saveUser(new User(null,"Jean4","isai4","1234",new ArrayList<>()));

			userService.addRoleToUser("isai","ROLE_SUPER_ADMIN");
			userService.addRoleToUser("isai","ROLE_ADMIN");
			userService.addRoleToUser("isai","ROLE_MANAGER");
			userService.addRoleToUser("isai1","ROLE_ADMIN");
			userService.addRoleToUser("isai1","ROLE_MANAGER");
			userService.addRoleToUser("isai2","ROLE_MANAGER");
			userService.addRoleToUser("isai3","ROLE_USER");
			userService.addRoleToUser("isai3","ROLE_MANAGER");
			userService.addRoleToUser("isai4","ROLE_USER");

		};
	}

}
