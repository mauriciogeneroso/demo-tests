Feature: Checking Identity app actuator endpoints return expected outputs

  Scenario: When application is healthy, return 200 response status code and "UP" response body on health endpoint
    Given a private endpoint PRIVATE_HEALTH_CHECK is prepared
    And request id 1773434c-8455-4ee9-9214-f607947398cb should be present
    And prime success with requestId 1773434c-8455-4ee9-9214-f607947398cb
    When the request is sent
    Then the response status code should be 200
    And the health response body of the message should have the status "UP"

  Scenario: When application is healthy, but downstream is unhealthy, returns "DOWN"
    Given a private endpoint PRIVATE_HEALTH_CHECK is prepared
    And request id 1773434c-8455-4ee9-9214-f607947398cc should be present
    And prime error with requestId 1773434c-8455-4ee9-9214-f607947398cc
    When the request is sent
    Then the response status code should be 503
    And the health response body of the message should have the status "DOWN"

  Scenario: Return correct app information when calling private/info
    Given a private endpoint PRIVATE_INFO is prepared
    And request id 1773434c-8455-4ee9-9214-f607947394aa should be present
    When the request is sent
    Then the response status code should be 200
    And it should return build information containing the following keys and values:
      | artifact | main-module  |
      | name     | main-module  |
      | group    | com.example  |
    And the response body contains:
      | git   |
      | build |
      | java  |