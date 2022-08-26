package com.cybertek.day4;

import com.cybertek.utility.HrTestBase;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;


public class ORDSApiTestWithPath extends HrTestBase {

    @DisplayName("GET request to countries with Path method")
@Test
    public  void test1(){
        Response response= given().accept(ContentType.JSON)
                .queryParam("q","{\"region_id\":2}")
                .when()
                .get("/countries");

        assertEquals(200,response.statusCode());

// print limit result
        System.out.println("response.path(\"limit\") = " + response.path("limit"));

        // print has more

        System.out.println("response.path(\"hasMore\") = " + response.path("hasMore"));

        // print first country id

        String firstCountryId = response.path("items[0].country_id");
        System.out.println("firstCountryId = " + firstCountryId);

// print second country name

       String secondCountryName= response.path("items[1].country_name");
        System.out.println("secondCountryName = " + secondCountryName);

// print http://44.201.250.13:1000/ords/hr/countries/CA
        String thirdHref=response.path("items[2].links[0].href");
        System.out.println("thirdHref = " + thirdHref);

    }
}
