package com.eureka.auth;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.eureka.auth.model.AppUser;
import com.eureka.auth.repository.AuthRepository;

@SpringBootApplication
@EnableEurekaClient
public class SpringEurekaAuthApp {
	@Autowired
	private AuthRepository authRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaAuthApp.class, args);
	}
	
	@PostConstruct
	public void initUser() {
		authRepository.deleteAll();
		// hard coding the users. All passwords must be encoded.
		final List<AppUser> users = Arrays.asList(
			new AppUser(1, "vikas", encoder.encode("12345"), "USER"),
			new AppUser(2, "admin", encoder.encode("12345"), "ADMIN")
		);
		authRepository.saveAll(users);
	}
}
