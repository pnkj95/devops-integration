package com.devops.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class DevopsIntegrationApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DevopsIntegrationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Spring boot application has started successfully..........");
		
	}
	
	@Scheduled(fixedRate = 5000)
	public void testSchedule() {
		System.out.println("Scheduler running..");
	}

}
