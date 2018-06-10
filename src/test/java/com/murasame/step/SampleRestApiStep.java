package com.murasame.step;

import com.murasame.SpringBootStep;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class SampleRestApiStep extends SpringBootStep {

    private ResponseEntity<String> response;

    @When("^the client calls the Rest Service /test without parameters$")
    public void theClientCallsTheRestServiceTestWithoutParameters() throws PendingException {
        response = template.getForEntity("/test", String.class);
    }

    @Then("^the client receives a (\\d+) Status code$")
    public void theClientReceivesAStatusCode(int statusCode) throws PendingException {
        assert response != null;
        assert response.getStatusCodeValue() == statusCode;
    }

    @Then("^the name John Doe is displayed$")
    public void theNameJohnDoeIsDisplayed() throws PendingException {
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals("John Doe", response.getBody());

    }

    @Given("^the client calls the Rest Service /test with parameter \"([^\"]*)\"$")
    public void theClientCallsTheRestServiceTestWithParameter(String name) {

        response = template.getForEntity("/test?name=" + name, String.class);
    }

    @Then("^the name \"([^\"]*)\" is displayed$")
    public void theNameIsDisplayed(String name) {
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(name, response.getBody());
    }

}
