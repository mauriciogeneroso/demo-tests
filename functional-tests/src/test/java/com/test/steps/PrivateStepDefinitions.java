package com.test.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.client.RequestTemplate;
import com.test.client.model.Endpoint;
import com.test.client.model.JsonMapper;
import com.test.client.model.PrivateHealthResponse;
import com.test.state.ScenarioState;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PrivateStepDefinitions {

    private final Map<Endpoint, RequestTemplate> privateRequestTemplates;
    private final ScenarioState scenarioState;
    private final JsonMapper jsonMapper;
    private final ObjectMapper objectMapper;

    @Given("a private endpoint {} is prepared")
    public void thePrivateEndpointIsPrepared(Endpoint endpoint) {
        System.out.format("Thread ID %d - define private endpoint %s.\n",Thread.currentThread().getId(), endpoint);
        RequestTemplate requestTemplate = getRequestTemplate(endpoint);
        System.out.format("Thread ID %d - set template %s.\n",Thread.currentThread().getId(), requestTemplate);
        scenarioState.setRequestTemplate(requestTemplate);
    }

    @Then("the health response body of the message should have the status {string}")
    public void theHealthResponseBodyOfTheMessageShouldHaveTheStatus(String expectedResponseBody) {
        System.out.format("Thread ID %d - check response health body.\n",Thread.currentThread().getId());
        var response = scenarioState.getActualResponse();
        var responseObj = jsonMapper.fromJson(response.body(), PrivateHealthResponse.class);
        assertThat(responseObj.status()).isEqualTo(expectedResponseBody);
    }

    @Then("health components should contain the status {word}:")
    public void healthComponentsShouldContainTheStatus(String status, List<String> componentNames) throws JsonProcessingException {
        System.out.format("Thread ID %d - check health components.\n",Thread.currentThread().getId());
        JsonNode jsonResponse = objectMapper.readTree(scenarioState.getActualResponseBody());
        JsonNode components = jsonResponse.get("components");

        componentNames.forEach(componentName -> assertThat(components.get(componentName).get("status").asText()).isEqualTo(status));
    }

    @Then("the body of the message contains {string}")
    public void theBodyOfTheMessageContains(String expectedResponseBodyContent) {
        assertTrue(scenarioState.getActualResponse().body().contains(expectedResponseBodyContent));
    }

    @Then("it should return (.*) information containing the following keys and values:$")
    public void theInfoContains(String key, Map<String, String> expectedInfo) throws JsonProcessingException {
        System.out.format("Thread ID %d - check response build info.\n",Thread.currentThread().getId());
        JsonNode jsonResponse = objectMapper.readTree(scenarioState.getActualResponseBody());
        JsonNode node = key.equals("java") ? jsonResponse.get("app") : jsonResponse;

        for (Map.Entry<String, String> entry : expectedInfo.entrySet()) {
            String actualInfo = node.get(key).get(entry.getKey()).asText();
            assertThat(actualInfo).matches(entry.getValue());
        }
    }

    @Then("the response body contains:")
    public void theResponseBodyContains(List<String> keys) throws JsonProcessingException {
        System.out.format("Thread ID %d - check if response body contains.\n",Thread.currentThread().getId());
        JsonNode jsonResponse = objectMapper.readTree(scenarioState.getActualResponseBody());
        keys.forEach(keyName -> assertTrue(jsonResponse.has(keyName)));
    }

    private RequestTemplate getRequestTemplate(Endpoint endpoint) {
        if (privateRequestTemplates.containsKey(endpoint)) {
            return privateRequestTemplates.get(endpoint);
        }

        throw new RuntimeException("Invalid private request template provided.");
    }
}
