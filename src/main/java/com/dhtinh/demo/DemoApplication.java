package com.dhtinh.demo;

import java.util.Optional;

import com.dhtinh.demo.config.ModelMapperConfig;
import com.dhtinh.demo.entity.Role;
import com.dhtinh.demo.entity.User;
import com.dhtinh.demo.entity.UserProfile;
import com.dhtinh.demo.model.request.UserRequest;
import com.dhtinh.demo.repository.UserProfileRepository;
import com.dhtinh.demo.repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
