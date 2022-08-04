package com.cybertek.day3;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;


public class SpartanTestsWithPath {

    @BeforeAll
    public static void init() {

        //save baseurl inside this variable so that we don't need to type each http method.
        RestAssured.baseURI = "http://44.201.250.13:8000";
    }


    /*
     Given accept type is json
     And path param id is 10
     When user sends a get request to "api/spartans/{id}"
     Then status code is 200
     And content-type is "application/json"
     And response payload values match the following:
          id is 10,
          name is "Lorenza",
          gender is "Female",
          phone is 3312820936
   */


    @DisplayName("GET one spartan with path method")
    @Test
    public void test1(){


    }

}
