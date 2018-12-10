package com.hexaware.ftp46.util;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hexaware.ftp46.model.Employee;
import com.hexaware.ftp46.model.LeaveDetails;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/employees")
public class EmployeeRest {

  /**
   * Returns a list of all the employees.
   * @return a list of all the employees
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Employee[] employeesList() {
    System.out.println("Employees List");
    final Employee[] employees = Employee.listAll();
    return employees;
  }

  /**
   * Returns a specific employee's details.
   * @param id the id of the employee
   * @return the employee details
   */
  @GET
  @Path("/emp/{empid}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Employee employeeListById(@PathParam("empid") final int id) {
    final Employee empl = Employee.listById(id);
    if (empl == null) {
      throw new NotFoundException("No such Employee ID: " + id);
    }
    return empl;
  }
  /**
   * Returns a specific employee's details.
   * @param id the id of the employee
   * @return the employee details
   */
  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] employeeListUnderManager(@PathParam("id") final int id) {
    final Employee[] empl = Employee.listEmployeeUnderManager(id);
    final LeaveDetails[] empLeavePendingUnderManager;
    if (empl == null) {
      throw new NotFoundException("No such Employee ID: " + id);
    } else {
      empLeavePendingUnderManager = LeaveDetails.leavePendingUnderManager(id);
      if (empLeavePendingUnderManager == null) {
        throw new NotFoundException("Nothing to approve");
      }
      return empLeavePendingUnderManager;
    }
  }
    /**
   * @param id the id of manager.
   * @return lkd.
   */
  @GET
  @Path("/mgremp/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final int listNoOfEmployeesUnderManager(@PathParam("id") final int id) {
    final int number = Employee.noOfEmployees(id);
    return number;
  }
  /**
   * Returns a specific employee's details.
   * @param id the id of the employee
   * @return the employee details
   */
  @GET
  @Path("revisit/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] employeeListUnderManagerRevisit(@PathParam("id") final int id) {
    final Employee[] empl = Employee.listEmployeeUnderManager(id);
    final LeaveDetails[] empLeavePendingUnderManagerRevisit;
    if (empl == null) {
      throw new NotFoundException("No such Employee ID: " + id);
    } else {
      empLeavePendingUnderManagerRevisit = LeaveDetails.leavePendingUnderManagerRevisit(id);
      if (empLeavePendingUnderManagerRevisit == null) {
        throw new NotFoundException("Nothing to approve");
      }
      return empLeavePendingUnderManagerRevisit;
    }
  }



}

