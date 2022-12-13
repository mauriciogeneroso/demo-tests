package com.test.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.context.annotation.Scope;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

//@Scope(SCOPE_CUCUMBER_GLUE)
public class StepDefs {

    private String testVariable;
    private String scenarioName;
    private String fileName;

    @Given("a step from {string} in {string} feature file")
    public void step(String scenario, String file) throws InterruptedException {
        System.out.format("Thread ID – %2d – %s from %s feature file.\n",
                Thread.currentThread().getId(), scenario, file);
        testVariable = "variable - " + scenario;
        Thread.sleep(3000);
        System.out.format("Thread ID – %2d – %s from %s feature file: %s.\n",
                Thread.currentThread().getId(), scenario, file, testVariable);
    }

    @Given("a step {string} on the file {string} is defined")
    public void step2(String scenario, String file) {
        this.scenarioName = scenario;
        this.fileName = file;

        System.out.format("Thread ID – %2d – Define variables for %s from %s feature file.\n",
                Thread.currentThread().getId(), scenario, file);
    }

    @Then("print the variables for the scenario {string}")
    public void print(String scenario) {
        System.out.format("Thread ID – %2d – Print variables for %s: scenarioName: %s and fileName: %s.\n",
                Thread.currentThread().getId(), scenario, scenarioName, fileName);
    }
}