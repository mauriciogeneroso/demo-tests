package com.example.demo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Demo API", version = "1.0", description = "Demo API tests"))
public class DemoApplication {

	// ./gradlew mM:clean mM:bootJar && java -jar ./main-module/build/libs/main-module-0.0.1-SNAPSHOT.jar

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
