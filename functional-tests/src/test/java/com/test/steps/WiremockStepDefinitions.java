package com.test.steps;

import com.test.util.WiremockUtil;
import io.cucumber.java.en.And;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class WiremockStepDefinitions {

    private final WiremockUtil wiremockUtil;

    @And("{} is primed to return {int} response status code")
    public void downstreamIsPrimedToReturn500(String downstream, int statusCode) {
        wiremockUtil.primeResponseWithBody(downstream, wiremockUtil.buildErrorResponse(statusCode).build());
    }
}
