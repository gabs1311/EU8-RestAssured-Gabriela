package com.cybertek.utility;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class SpartanTestBase {
    @BeforeAll
    public static void init() {

        //save baseurl inside this variable so that we don't need to type each http method.
        RestAssured.baseURI = "http://44.201.250.13:8000";
    }

}
