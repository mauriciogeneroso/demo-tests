package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/*
	*** 3 ways to create webFilters:
		ps: all require to implement javax.servlet.Filter

		1 - Use @Component and implement Filter. eg: XClacksOverhead

		2 - Create a class that implements Filter, and create a bean to return a FilterRegistrationBean<?>
			eg: WebConfig and LogFilter

		3 - Enable @ServletComponentScan, create a class that implements Filters and annotate it with @WebFilter
	 */
}
