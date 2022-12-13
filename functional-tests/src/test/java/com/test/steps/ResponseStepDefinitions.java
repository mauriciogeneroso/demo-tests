package com.test.steps;

//import com.generoso.ft.identity.client.model.JsonMapper;
//import com.generoso.ft.identity.state.ScenarioState;
//import com.generoso.identity.exception.error.ErrorDetail;
//import com.generoso.identity.exception.error.ValidationErrorDetails;

import com.test.client.model.JsonMapper;
import com.test.state.ScenarioState;
import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ResponseStepDefinitions {

    private final ScenarioState scenarioState;
    private final JsonMapper jsonMapper;

    @Then("the response status code should be {int}")
    public void theResponseCode(int expectedResponseCode) {
        System.out.format("Thread ID %d - check response status. Obj: %s\n",Thread.currentThread().getId(),
                scenarioState.getActualResponse());
        assertThat(scenarioState.getActualResponse().statusCode()).isEqualTo(expectedResponseCode);
    }

//    @And("error validation response should contain status {int} and error {} and field {} and field message {}")
//    public void errorValidationResponseShouldMatch(int status, String error, String field, String fieldMessage) {
//        var response = scenarioState.getActualResponse();
//        var validationObj = jsonMapper.fromJson(response.body(), ValidationErrorDetails.class);
//
//        var fieldSplit = field.split(",");
//        var fieldMessageSplit = fieldMessage.split(",");
//
//        assertThat(validationObj.getStatus()).isEqualTo(status);
//        assertThat(validationObj.getError()).isEqualTo(error);
//        stream(fieldSplit).forEach(fieldValue -> assertThat(validationObj.getField()).contains(fieldValue));
//        stream(fieldMessageSplit).forEach(
//                fieldMessageValue -> assertThat(validationObj.getFieldMessage()).contains(fieldMessageValue));
//        assertThat(validationObj.getTimestamp()).isNotNull();
//    }

//    @And("error response should contain status {int} with error {} and detail {}")
//    public void errorResponseShouldMatch(int status, String error, String detail) {
//        var response = scenarioState.getActualResponse();
//        var errorDetail = jsonMapper.fromJson(response.body(), ErrorDetail.class);
//
//        assertThat(errorDetail.getStatus()).isEqualTo(status);
//        assertThat(errorDetail.getError()).isEqualTo(error);
//        assertThat(errorDetail.getDetail()).isEqualTo(detail);
//        assertThat(errorDetail.getTimestamp()).isNotNull();
//    }
}
