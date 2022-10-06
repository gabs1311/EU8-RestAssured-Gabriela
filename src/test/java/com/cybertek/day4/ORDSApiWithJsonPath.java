package com.cybertek.day4;

import com.cybertek.utility.HrTestBase;

import com.cybertek.utility.HrTestBase;

import io.restassured.http.ContentType;
import io.restassured.internal.RestAssuredResponseOptionsGroovyImpl;
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

    // get all country names where their region id is equal to 2

    List<String> countryNamesWithRegionId2 = jsonPath.getList("items.findAll {it.region_id==2}.country_name");
    System.out.println("countryNamesWithRegionId2 = " + countryNamesWithRegionId2);
}

@DisplayName("GET request to / employees with query param ")
@Test
    public void test2(){
    // we added query param to get 107 employees
    given().queryParams("limit", 107)
            .when().get("/employees");

    // first if statement:
    // get me all email of employees who is working as IT_PROG=(if IT_PROG is the job, I want to get the email)
    //we added limit query param to get 107 employees
    Response response = given().queryParam("limit", 107)
            .when().get("/employees");

    JsonPath jsonPath = response.jsonPath();
    //response.prettyPrint();
    //get me all email of employees who is working as IT_PROG
    List<String> employeeITProgs = jsonPath.getList("items.findAll {it.job_id==\"IT_PROG\"}.email");
    System.out.println(employeeITProgs);

    // get me first name of employees who is making more than 10000

        List<String> empNames = jsonPath.getList("items.findAll{it.salary>10000}.first_name");
    System.out.println("empNames = " + empNames);


    // gte the max salary first_name
    String kingFirstName = jsonPath.getString("items.max{it.salary}.first_name");
    Object kingNameWithPathMethod = response.path("items.max{it.salary}.first_name");// it works juts as well
    // as the previous line
    System.out.println("kingFirstName = " + kingFirstName);
    System.out.println("kingNameWithPathMethod = " + kingNameWithPathMethod);
        }





}
