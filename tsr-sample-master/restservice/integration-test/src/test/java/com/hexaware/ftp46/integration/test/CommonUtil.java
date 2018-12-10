package com.hexaware.ftp46.integration.test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

import javax.management.RuntimeErrorException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
public class CommonUtil {
    public static final String host;
    public static final String port;
    public static final String webapp;
    public static final String uri_prefix;
    static {
        host = System.getProperty("service.host", "localhost");
        port = System.getProperty("service.port", "8070");
        webapp = System.getProperty("service.webapp", "ftp46");
        uri_prefix = "http://" + host + ":" + port + "/" + webapp;
    }
    public static URI getURI(String path) throws URISyntaxException {
        return new URI(uri_prefix + path);
    }
}

class Employee {
  public int empId;
  public String empName;
  public String empDoj;
  public int managerId;
  public String empEmail;
  public int empLeaveBalance;
  public Long empPhone;
  public String empDepartment;
  public String empProfileUrl;

    public Employee() {
    }

    public Employee(final int argEmpId, final String argEmpName, final String argEmpDoj, final int argManagerId,
    final String argEmpEmail, final int argEmpLeaveBalance, final Long argEmpPhone, final String argEmpDepartment, final String empProfileUrl) {
  this.empId = argEmpId;
  this.empName = argEmpName;
  this.empDoj = argEmpDoj;
  this.managerId = argManagerId;
  this.empEmail = argEmpEmail;
  this.empLeaveBalance = argEmpLeaveBalance;
  this.empPhone = argEmpPhone;
  this.empDepartment = argEmpDepartment;
  this.empProfileUrl = empProfileUrl;
}

    public final boolean equals(final Object obj) {
      if (obj == null) {
        return false;
      }
      if (getClass() != obj.getClass()) {
        return false;
      }
      Employee emp = (Employee) obj;
      if (Objects.equals(empId, emp.empId)) {
        return true;
      }
      return false;
    }

    public String toString() {
      try {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(this);
      } catch(Exception e) {
        throw new RuntimeException(e);
      }
    }
}
class LeaveDetails {
  public  int leaveEmpId;
  public int leaveId;
  public String startDate;
  public String endDate;
  public String appliedOn;
  public int noOfDays;
  public String leaveType;
  public String reason;
  public String leaveStatus;
  public String managerComments;


    public LeaveDetails() {
    }

    public LeaveDetails(final int argLeaveId, final int argEmpId, final String argStartDate, final String argEndDate,
    final String argAppliedOn, final int argNoOfDays, final String argLeaveType, final String argReason,
    final String argManagerComments, final String argLeaveStatus) {
  this.leaveId = argLeaveId;
  this.leaveEmpId = argEmpId;
  this.startDate = argStartDate;
  this.endDate = argEndDate;
  this.appliedOn = argAppliedOn;
  this.noOfDays = argNoOfDays;
  this.leaveType = argLeaveType;
  this.reason = argReason;
  this.managerComments = argManagerComments;
  this.leaveStatus = argLeaveStatus;

}

    public final boolean equals(final Object obj) {
      if (obj == null) {
        return false;
      }
      if (getClass() != obj.getClass()) {
        return false;
      }
      LeaveDetails emp = (LeaveDetails) obj;
      if (Objects.equals(leaveId ,emp.leaveId)) {
        return true;
      }
      return false;
    }

    public String toString() {
      try {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(this);
      } catch(Exception e) {
        throw new RuntimeException(e);
      }
    }
}
class Metrics{
  public int count;
  public Metrics(final int count){
this.count=count;
  }
}
