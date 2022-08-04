package com.cybertek.day3;


import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class ORDSApiTestWithParameters {
    @BeforeAll
    public static void init() {

        //save baseurl inside this variable so that we don't need to type each http method.
        RestAssured.baseURI = "http://44.201.250.13:8000";
    }


 /*
        Given accept type is Json
        And parameters: q = {"region_id":2}
        When users sends a GET request to "/countries"
        Then status code is 200
        And Content type is application/json
        And Payload should contain "United States of America"
     */





}
