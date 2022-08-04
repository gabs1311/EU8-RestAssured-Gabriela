package com.cybertek.day3;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartanTestsWithParameters {


    @BeforeAll
    public static void init() {

        //save baseurl inside this variable so that we don't need to type each http method.
        RestAssured.baseURI = "http://44.201.250.13:8000";
    }

    /*   Given accept type is Json
          And Id parameter value is 5
          When user sends GET request to /api/spartans/{id}
          Then response status code should be 200
          And response content-type: application/json
          And "Blythe" should be in response payload
       */

    @DisplayName("GET request to api/spartans/{id} with ID 5")
    @Test
    public void test1() {
        // these are the initial conditions
        Response response = given().
                                  accept(ContentType.JSON)
                                 .and().pathParam("id", 5).
                             when().
                                  get("api/spartans/{id}");
// the role of

        // we verify the status code
        assertEquals(200, response.statusCode());

        //we verify the response content-type is application/json
        assertEquals("application/json", response.contentType());
        // we verify the word "Blythe" is in the response payload
        assertTrue(response.body().asString().contains("Blythe"));
    }


    /*
        TASK
        Given accept type is Json
        And Id parameter value is 500
        When user sends GET request to /api/spartans/{id}
        Then response status code should be 404
        And response content-type: application/json
        And "Not Found" message should be in response payload
     */


    @DisplayName("GET request /api/spartans/{id} Negative Test")
    @Test
    public void test2() {
        // these are the initial conditions
        Response response = given().
                accept(ContentType.JSON)// this line is not a must, since the default type of API is Json, I just put it her to look better, and for better understanding
                .and().pathParam("id", 500).
                when().
                get("api/spartans/{id}");
// the role of

        // we verify the status code
        assertEquals(404, response.statusCode());

        //we verify the response content-type is application/json
        assertEquals("application/json", response.contentType());
        // we verify the word "Blythe" is in the response payload
        assertTrue(response.body().asString().contains("Not Found"));
    }






}
