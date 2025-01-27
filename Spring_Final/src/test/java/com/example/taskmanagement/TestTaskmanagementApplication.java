package com.example.taskmanagement;

import com.silanov.springfinal.TaskmanagementApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestTaskmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.from(TaskmanagementApplication::main).with(TestTaskmanagementApplication.class).run(args);
	}

}
