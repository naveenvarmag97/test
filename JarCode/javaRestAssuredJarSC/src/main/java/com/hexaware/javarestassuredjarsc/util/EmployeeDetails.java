package com.hexaware.javarestassuredjarsc.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

//import com.hexaware.scoringevaluation.rawscore.*;

public class EmployeeDetails {
    public String employee_Name;
    public int employee_ID;
    public String employee_Email;
    public String application_Name;

    public EmployeeDetails(final String employee_Name, final int employee_ID, final String employee_Email,  final String application_Name) {
        this.employee_Name = employee_Name;
        this.employee_ID = employee_ID;
        this.employee_Email = employee_Email;
        this.application_Name =  application_Name;
    }
    //empty Constructor
    public EmployeeDetails(){
        
    }
    public String apiValueRaw() throws IOException {
        BufferedReader brcheck = new BufferedReader(new FileReader("../EmployeeDetails.json"));
  
        String apiValue = "";
        try {
            String l = null;
            while ((l = brcheck.readLine()) != null) {
                // System.out.println(l);
                apiValue = apiValue + l;
            }
  
        } finally {
            brcheck.close();
        }
        return apiValue;
    }
    public int getEmpID() throws JsonSyntaxException, IOException{
        //apiValueRaw();
        Gson gson = new Gson();
        EmployeeDetails json2 = gson.fromJson(apiValueRaw(), EmployeeDetails.class);
        return json2.employee_ID;
    }
    public String getApplicationName() throws JsonSyntaxException, IOException{
        //apiValueRaw();
        Gson gson = new Gson();
        EmployeeDetails json2 = gson.fromJson(apiValueRaw(), EmployeeDetails.class);
        return json2.application_Name;
    }
}