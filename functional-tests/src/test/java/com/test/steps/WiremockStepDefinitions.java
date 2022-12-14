package com.test.steps;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.matching.EqualToPattern;
import com.test.state.ScenarioState;
import com.test.util.WiremockUtil;
import io.cucumber.java.en.And;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class WiremockStepDefinitions {

    private final WiremockUtil wiremockUtil;
    private final ScenarioState scenarioState;

    @Value("${wiremock.host}")
    String wiremockHost;
    @Value("${wiremock.port}")
    int port;

    @And("{} is primed to return {int} response status code")
    public void downstreamIsPrimedToReturn500(String downstream, int statusCode) {
        wiremockUtil.primeResponseWithBody(downstream,
                wiremockUtil.buildWithStatus(statusCode).build());
    }

    @And("prime success with requestId {word}")
    public void primeSuccess(String requestId) {
        System.out.printf("Thread ID %d - Bind wiremock\n", Thread.currentThread().getId());
        WireMock.configureFor(wiremockHost, port);
        System.out.printf("Thread ID %d - Creating stubbing for error scenario\n", Thread.currentThread().getId());
        stubFor(get(urlEqualTo("/downstream/private/health"))
                .withHeader("X-SkyInt-RequestId", new EqualToPattern(requestId))
                .willReturn(wiremockUtil.buildWithStatus(200)));
        System.out.printf("Thread ID %d - Stubbing for error scenario created\n", Thread.currentThread().getId());
    }

    @And("prime error with requestId {word}")
    public void primeError(String requestId) {
        System.out.printf("Thread ID %d - Bind wiremock\n", Thread.currentThread().getId());
        WireMock.configureFor(wiremockHost, port);
        System.out.printf("Thread ID %d - Creating stubbing for error scenario\n", Thread.currentThread().getId());
        stubFor(get(urlEqualTo("/downstream/private/health"))
                .withHeader("X-SkyInt-RequestId", new EqualToPattern(requestId))
                .willReturn(wiremockUtil.buildWithStatus(500)));
        System.out.printf("Thread ID %d - Stubbing for error scenario created\n", Thread.currentThread().getId());
    }
}
