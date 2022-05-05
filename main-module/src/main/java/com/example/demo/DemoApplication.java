package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	// ./gradlew mM:clean mM:bootJar && java -jar ./main-module/build/libs/main-module-0.0.1-SNAPSHOT.jar

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
