
package com.hexaware.javarestassuredjarsc.util;

//CHECKSTYLE:OFF
import com.hexaware.javarestassuredjarsc.util.*;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.ResponseBody;
import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.given;
//import com.sun.org.apache.xpath.internal.operations.String;
import java.io.*;
import java.net.*;
//import org.json.simple.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

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

 
  public String ShopecAddEmpId () throws JsonSyntaxException, IOException{
		EmployeeDetails ed = new EmployeeDetails();
		int empID = ed.getEmpID();

		String shopec = "shopec_" + empID;
		return shopec;
	}

  public int ApiTestN01() throws URISyntaxException, IOException {
    String apiUrlFirst = "http://localhost:8080/"+ShopecAddEmpId()+"/GET/products/";
    String apiValueFirst = "";
   int statusCodeFirst=0;
   try {
      apiUrlFirst = "http://localhost:8080/" + ShopecAddEmpId() + "/POST/order/";

    RequestSpecification httpRequest = RestAssured.given().accept("application/json").contentType("application/json").body("{\"items\":[{\"quantity\":1,\"price\":0,\"productId\":1}],\"grossTotal\":49.989999999999995,\"deliveryTotal\":19.99,\"itemsTotal\":30,\"userId\":1,\"deliveryOptionId\":\"f488db46-9380-45e2-b15e-4ace7bdb73\",\"deliveryOptionCode\":\"D\"}"); 
com.jayway.restassured.response.Response response =  httpRequest.post(apiUrlFirst).prettyPeek();
 statusCodeFirst= response.getStatusCode();
    } catch (JsonSyntaxException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if (statusCodeFirst == 200) {
      System.out.println("test 1"+"\n"+apiValueFirst+"\n"+"\n"+"\n"+"\n"+"\n" + apiUrlFirst + "\n" + " Test 1 = Pass"+"\n--------------------------------------------------------------------");
      test = test + 1;
      return 1;

    } else {
      System.out.println("test 1"+"\n"+apiValueFirst+"\n"+"\n"+"\n"+"\n"+"\n" + apiUrlFirst + "\n" + " Test 1 = Fail"+"\n--------------------------------------------------------------------");
      return 0;
    }
  }

  // second api
  public int ApiTestNo2() {
    String apiUrlSecond="";
    String apiValueSecond = "";
 int statusCodeSecond=0;

    try {
      apiUrlSecond = "http://localhost:8080/" + ShopecAddEmpId() + "/POST/order/";

    RequestSpecification httpRequest = RestAssured.given().accept("application/json").contentType("application/json").body("{\"items\":[{\"quantity\":1,\"price\":0,\"productId\":1}],\"grossTotal\":49.989999999999995,\"deliveryTotal\":19.99,\"itemsTotal\":30,\"userId\":1,\"deliveryOptionId\":\"f488db46-9380-45e2-b15e-4ace7bdb73\",\"deliveryOptionCode\":\"D\"}"); 
com.jayway.restassured.response.Response response =  httpRequest.post(apiUrlSecond).prettyPeek();
 statusCodeSecond= response.getStatusCode();
 //String test = response.getBody().asString();
 //System.out.println("------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>\n RESSPONSE \t" + test);
    } catch (JsonSyntaxException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if (statusCodeSecond == 200) {
      System.out.println("test 2"+"\n"+apiValueSecond+"\n"+"\n"+"\n"+"\n"+"\n" + apiUrlSecond + "\n" + " Test 2 = Pass"+"\n--------------------------------------------------------------------");
      test = test +1;
      return 1;

    } else {
      System.out.println("test 2"+"\n"+apiValueSecond+"\n"+"\n"+"\n"+"\n"+"\n" + apiUrlSecond + "\n" + " Test 2 = Fail" +"\n--------------------------------------------------------------------");
      return 0;
    }
  

  }
//test no 3
  public final int ApiTestNo3() {
    String apiUrlThird = "";
    String apiValueThird = "";
        int statusCode = 0;
    // URL
try{
  System.out.println("-------------------------------------->>>>>>>>>>>>>>>>>>>>>>>>");
    apiUrlThird =  "http://localhost:8080/"+ ShopecAddEmpId()+"/account/login";
    RequestSpecification httpRequest = RestAssured.given().accept("application/json").contentType("application/json").body("{\"userId\":\"User1@g.com\",\"password\":\"password\"}"); 
com.jayway.restassured.response.Response response =  httpRequest.post(apiUrlThird).prettyPeek();
 statusCode = response.getStatusCode();

       
      //  String res = RestAssured.given().accept("application/json").contentType("application/json")
      // .body("{\"userId\":\"User1@g.com\",\"password\":\"pass1word\"}")
      // .when().post(apiUrlThird).prettyPeek().getBody().asString();
      // apiValueThird = res;
       
} catch(JsonSyntaxException e){
  e.printStackTrace();
} catch(IOException e){
  e.printStackTrace();

}

      if (statusCode == 200) {
        System.out.println("test 3"+"\n"+apiValueThird+"\n"+"\n"+"\n"+"\n"+"\n" + apiUrlThird + "\n" + " Test 3 = Pass"+"\n--------------------------------------------------------------------");
        test = test + 1;
        return 1;
  
      } else {
        System.out.println("test 3"+"\n"+apiValueThird+"\n"+"\n"+"\n"+"\n"+"\n" + apiUrlThird + "\n" + " Test 3 = Fail"+"\n--------------------------------------------------------------------");
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
