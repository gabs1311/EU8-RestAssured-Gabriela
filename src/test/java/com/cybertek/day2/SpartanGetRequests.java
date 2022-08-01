package com.cybertek.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
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

        Assertions.assertEquals(response.statusCode(),200);


        // verify content type is application/json
        Assertions.assertEquals(response.contentType(),"application/json");





    }
}
