package com.hexaware.dotnetrestassuredjarsc.util;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import java.io.IOException;
import javax.management.RuntimeErrorException;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
public class CommonUtil {
    static int  empID;
    public static final String host;
    public static final String port;
    //public static final String webapp;
    EmployeeDetails emp = new EmployeeDetails();
    //int empId = emp.getEmpID();
    public static int  ShopecAddEmpId () throws JsonSyntaxException, IOException{
		EmployeeDetails ed = new EmployeeDetails();
         empID = ed.getEmpID();
          System.out.println("EMPLOYEE ID" + empID);
          return empID;

	
	}
    public static String uri_prefix="";
    static  {
        host = System.getProperty("service.host", "localhost");
		port = System.getProperty("service.port", "80");
        //port = System.getProperty("service.port", "9090");
        
        try {
               uri_prefix = "http://" + host + ":" + port + "/crms_"+ShopecAddEmpId()+"/api" + "";
        } catch (JsonSyntaxException  | IOException e){
            System.out.println("error in path");

        }

    }
    public static URI getURI(String path) throws URISyntaxException {
        return new URI(uri_prefix + path);
    }
}
