package com.hexaware.ftp46.integration.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import static org.junit.Assert.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.given;

public class LeaveDetailsRestTest {
    @Test
    public void testHistory() throws AssertionError, URISyntaxException{
        LeaveDetails[] res = given().accept(ContentType.JSON).when()
        .get(CommonUtil.getURI("/api/leaveDetails/history/1000")).getBody().as(LeaveDetails[].class);
        for(LeaveDetails l : res){
            assertEquals(1000, l.leaveEmpId);
        }
    }
    @Test
    public void testPending() throws AssertionError, URISyntaxException{
        LeaveDetails[] res = given().accept(ContentType.JSON).when()
        .get(CommonUtil.getURI("/api/leaveDetails/1000")).getBody().as(LeaveDetails[].class);
        for(LeaveDetails l : res){
            assertEquals(1000, l.leaveEmpId);
        }
    }
    @Test
    public void testPendingcount() throws AssertionError, URISyntaxException{
        Metrics num = given().accept(ContentType.JSON).when()
        .get(CommonUtil.getURI("/api/leaveDetails/pendingcount/1000")).getBody().as(Metrics.class);
        assertNotEquals(num,-1);
    }
    @Test
    public void testappliedcount() throws AssertionError, URISyntaxException{
        Metrics num = given().accept(ContentType.JSON).when()
        .get(CommonUtil.getURI("/api/leaveDetails/applied/1000")).getBody().as(Metrics.class);
        assertNotEquals(num,-1);
    }
    @Test
    public void testDayscount() throws AssertionError, URISyntaxException{
        Metrics num = given().accept(ContentType.JSON).when()
        .get(CommonUtil.getURI("/api/leaveDetails/days/1000")).getBody().as(Metrics.class);
        assertNotEquals(num,-1);
    }
    // @Test
    // public void testapprove() throws AssertionError, URISyntaxException{
    //     String num = put(CommonUtil.getURI("/"))
    //     .get(CommonUtil.getURI("/api/leaveDetails/days/1000")).getBody().as(Metrics.class);
    //     assertNotEquals(num,-1);
    // }
    @Test
    public void testLeaveId() throws AssertionError, URISyntaxException{
        LeaveDetails num = given().accept(ContentType.JSON).when()
        .get(CommonUtil.getURI("/api/leaveDetails/leaveId/1")).getBody().as(LeaveDetails.class);
        assertEquals(num.leaveId,1);
    }
}