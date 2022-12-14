package com.test.state;

import com.test.client.RequestTemplate;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.net.http.HttpResponse;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Setter
@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class ScenarioState {

    private RequestTemplate requestTemplate;
    private HttpResponse<String> actualResponse;

    private String requestId;

    public RequestTemplate getRequestTemplate() {
        if (requestTemplate == null) {
            throw new RuntimeException("The request template wasn't provided.");
        }

        return requestTemplate;
    }

    public HttpResponse<String> getActualResponse() {
        if (actualResponse == null) {
            throw new RuntimeException("The actual response wasn't provided.");
        }

        return actualResponse;
    }

    public String getActualResponseBody() {
        return getActualResponse().body();
    }

    public String getRequestId() {
        return requestId;
    }
}
