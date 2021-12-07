package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	// ./gradlew clean build && java -jar ./main-app/build/libs/main-app-0.0.1-SNAPSHOT.jar

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
