package com.test.steps;

import io.cucumber.java.en.Given;

public class StepDefs {

    private String testVariable;

    @Given("a step from {string} in {string} feature file")
    public void step(String scenario, String file) throws InterruptedException {
        System.out.format("Thread ID – %2d – %s from %s feature file.\n",
                Thread.currentThread().getId(), scenario, file);
        testVariable = "variable - " + scenario;
        Thread.sleep(3000);
        System.out.println(testVariable);
    }
}