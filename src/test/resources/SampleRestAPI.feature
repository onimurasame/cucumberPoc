Feature: a sample API that returns a name when passed as a GET argument

  Scenario: client makes a rest call to the SampleRestAPI without parameters, and receives John Doe as response
    When the client calls the Rest Service /test without parameters
    Then the client receives a 200 Status code
    And the name John Doe is displayed

  Scenario: client makes a rest call to the SampleRestApi with parameter Joey the dog, and receives Joey the dog as response
    Given the client calls the Rest Service /test with parameter "Joey the dog"
    Then the client receives a 200 Status code
    And the name "Joey the dog" is displayed