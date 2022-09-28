package com.cybertek.day4;

import com.cybertek.utility.HrTestBase;

import com.cybertek.utility.HrTestBase;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class ORDSApiWithJsonPath extends HrTestBase {

@DisplayName("GET request to Countries")
@Test
    public void test1(){

 Response response=get("/countries");

// get the second country name with JsonPath

    // to use Json path we assign response to JsonPath
    JsonPath jsonPath = response.jsonPath();

    String secondCountryName = jsonPath.getString("items[1].country_name");
    System.out.println("secondCountryName = " + secondCountryName);


    // get all country ids
    // items.country_id
    List<String> allCountrieIds = jsonPath.getList("items.country_id");
    System.out.println("allCountrieIds = " + allCountrieIds);


}





}
