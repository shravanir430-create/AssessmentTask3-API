package com.stepDefinition;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class StampDutySteps {

    private Response response;
    private final String BASE_URL = "https://openlibrary.org/authors/OL1A.json";

    @Given("I set the API endpoint for the author")
    public void setEndpoint() {
        RestAssured.baseURI = "https://openlibrary.org";
    }

    @When("I send a GET request to the author endpoint")
    public void sendRequest() {
        response = get("/authors/OL1A.json");
    }

    @Then("the response status code should be 200")
    public void verifyStatus() {
        response.then().statusCode(200);
    }

    @Then("the personal name should be {string}")
    public void verifyPersonalName(String expectedName) {
        // Assertion for Task 3a
        response.then().body("personal_name", equalTo(expectedName));
    }

    @Then("the alternate names should contain {string}")
    public void verifyAlternateName(String expectedAlternateName) {
        // Assertion for Task 3b
        response.then().body("alternate_names", hasItem(expectedAlternateName));
    }
}