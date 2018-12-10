
package com.hexaware.dotnetrestassuredjarsc.util;

//CHECKSTYLE:OFF
import com.hexaware.dotnetrestassuredjarsc.util.*;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.given;
//import com.sun.org.apache.xpath.internal.operations.String;
import java.io.*;
import java.net.*;
//import org.json.simple.JSONObject;
import com.google.gson.Gson;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.HashSet;

public class Rest {
  private String name;
  private int capacity;
   int test=0;
  URL urlFirst;
  URL urlSecond;
  URL urlThird;

  //

  //
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Rest job = (Rest) obj;
    if (Objects.equals(name, job.name) && Objects.equals(capacity, job.capacity)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(name, capacity);
  }

  public Rest(final String name, final int capacity) {
    this.name = name;
    this.capacity = capacity;
  }

  public Rest() {

  }

  public final String getClassName() {
    return name;
  }

  public final int getcapacity() {
    return capacity;
  }

  public int ApiTestN01() throws URISyntaxException, IOException {
   
    String apiValueFirst = "";
    RequestSpecification httpRequest = RestAssured.given().accept("application/json").contentType("application/json");
    com.jayway.restassured.response.Response response = httpRequest.get(CommonUtil.getURI("/Room/GetRooms"))
        .prettyPeek();
    int statusCodeTestRoom = response.getStatusCode();
    if ( statusCodeTestRoom == 200) {
      System.out.println("\n"+apiValueFirst+"\n"+"\n"+"\n"+"\n"+"\n" +  CommonUtil.getURI("/Room/GetRooms") + "\n" + " Test 1 = Pass");
      test = test + 1;
      return 1;

    } else {
      System.out.println("\n"+apiValueFirst+"\n"+"\n"+"\n"+"\n"+"\n" +  CommonUtil.getURI("/Room/GetRooms") + "\n" + " Test 1 = Fail");
      return 0;
    }
  }

  // second api
  public int ApiTestNo2() throws URISyntaxException {
    RequestSpecification httpRequest = RestAssured.given().accept("application/json").contentType("application/json");
    com.jayway.restassured.response.Response response = httpRequest.get(CommonUtil.getURI("/Room/GetActiveRooms"))
        .prettyPeek();
    int statusCodeTestActiveRooms = response.getStatusCode();
    if (statusCodeTestActiveRooms == 200) {
      System.out.println("\n"+ "\n"+"\n"+"\n"+"\n"+"\n" +   CommonUtil.getURI("/Room/GetActiveRooms")+"\n" + " Test 2 = Pass");
      test = test +1;
      return 1;

    } else {
      System.out.println("\n"+"\n"+"\n"+"\n"+"\n"+"\n" + CommonUtil.getURI("/Room/GetActiveRooms") + "\n" + " Test 2 = Fail");
      return 0;
    }
  }

  public final int ApiTestNo3() throws IOException, URISyntaxException {
    RequestSpecification httpRequest = RestAssured.given().accept("application/json").contentType("application/json");
  com.jayway.restassured.response.Response response = httpRequest.get(CommonUtil.getURI("/booking/getbookings"))
      .prettyPeek();
  int statusCodeTestActiveRooms = response.getStatusCode();

      if (statusCodeTestActiveRooms == 200) {
        System.out.println("\n"+"\n"+"\n"+"\n"+"\n"+"\n" + CommonUtil.getURI("/booking/getbookings") + "\n" + " Test 3 = Pass");
        test = test + 1;
        return 1;
  
      } else {
        System.out.println("\n"+"\n"+"\n"+"\n"+"\n"+"\n" + CommonUtil.getURI("/booking/getbookings") + "\n" + " Test 3 = Fail");
        return 0;
      }
  }

  public void finalTestResult() throws URISyntaxException, IOException {
    int test1 = ApiTestN01();
    int test2 = ApiTestNo2();
    int test3 = ApiTestNo3();
    System.out.println("Number Of passed Test Cases = " + test);
    System.out.println("Number Of Failed Test Cases= " + (3 - test));

  }

}