package com.cybertek.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.annotation.meta.When;

public class SpartanGetRequests {

    String baseUrl = "http://44.201.250.13:8000";

    //  Given Accept type application/json
    //When user send GET request  to api/spartans end point
    //Then status code must be 200
    //Then response Content Type must be application/jsonn
    //And response body should include spartan result

    @Test
    public void test1(){
      Response response=  RestAssured.given().accept(ContentType.JSON)
                .when()
                .get(baseUrl+"/api/spartans");

        // printing status code from response object
        System.out.println("response.statusCode() = " + response.statusCode());

        // printing response content type from response object

        System.out.println("response.contentType() = " + response.contentType());

        // print whole result body
        response.prettyPrint();

        // how do I do API testing then?
        // verify status code is 200

        Assertions.assertEquals(200,response.statusCode());


        // verify content type is application/json
        Assertions.assertEquals("application/json",response.contentType());



        }


        /*
        Given accept header  is application json
        When users send a get request to /api/spartans/3
        Then status code should be 200
        And content type should be application/json
        and json body should contain Fidole


         */

    @DisplayName("GET one spartan  /api/spartans/3")
    @Test
    public void test2(){
       Response response =RestAssured.given().accept(ContentType.JSON).
                when().get(baseUrl+ "/api/spartans/3");

       // verify status code is 200

        Assertions.assertEquals(200,response.statusCode());


        //verify content type is application/json
        Assertions.assertEquals("application/json",response.contentType());

        // checking json body includes Fidole. The method is not a good one, but it
        // what we will use with the current knowledge

        Assertions.assertTrue(response.body().asString().contains("Fidole"));


    }
}
