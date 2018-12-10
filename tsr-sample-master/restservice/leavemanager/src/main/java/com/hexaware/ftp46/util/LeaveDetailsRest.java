package com.hexaware.ftp46.util;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Consumes;
//import java.text.SimpleDateFormat;
import java.util.Date;

import com.hexaware.ftp46.model.LeaveDetails;
import com.hexaware.ftp46.model.Employee;


/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/leaveDetails")
public class LeaveDetailsRest {

  /**
   * Returns a list of all the employees.
   * @param empid empid.
   * @param ld empid.
   * @param leaveOption leaveOption.
   * @return a list of all the employees.
   */
  @POST
  @Path("{empid}/apply/{leaveOption}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public final String  empApplyLeave(@PathParam("empid") final int empid,
      final LeaveDetails ld, @PathParam("leaveOption") final int leaveOption) {
    Employee emp = Employee.listById(empid);
    if (emp == null) {
      throw new NotFoundException("No such Employee ID: " + empid);
    }
    if (emp.getEmpLeaveBalance() > 0) {
      Date startDate = LeaveDetails.leaveDate(ld.getStartDate());
      Date endDate = LeaveDetails.leaveDate(ld.getEndDate());
      String msg = LeaveDetails.applyLeave(startDate, endDate, ld.getReason(), empid, leaveOption);
      return msg;
    } else {
      return "your leave balance is zero";
    }
  }
  /**
   * Returns a list of all the employees.
   * @param empid empid.
   * @param leaveid empid.
   * @param ld empid.
   * @return a list of all the employees.
   */
  @POST
  @Path("{empid}/Edit/{leaveid}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public final String  empEditApplyLeave(@PathParam("empid") final int empid, @PathParam("leaveid") final int leaveid,
      final LeaveDetails ld) {
    Employee emp = Employee.listById(empid);
    if (emp == null) {
      throw new NotFoundException("No such Employee ID: " + empid);
    }
    if (emp.getEmpLeaveBalance() > 0) {
      Date startDate = LeaveDetails.leaveDate(ld.getStartDate());
      Date endDate = LeaveDetails.leaveDate(ld.getEndDate());
      String msg = LeaveDetails.editapplyLeave(startDate, endDate, ld.getReason(), empid, leaveid);
      return msg;
    } else {
      return "your leave balance is zero";
    }
  }

    /**
   * Returns a specific employee's details.
   * @param id the id of the employee
   * @return the employee details
   */
  @GET
  @Path("/history/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] listLeaveHistory(@PathParam("id") final int id) {
    final Employee empl = Employee.listById(id);
    if (empl == null) {
      throw new NotFoundException("No such Employee ID: " + id);
    }
    final LeaveDetails[] leave1 = LeaveDetails.leaveHistory(id);
    if (leave1.length == 0) {
      throw new NotFoundException("No Leave History for Employee ID: " + id);
    }
    return leave1;
  }
  /**
   * Returns a list of all the employees.
   * @param leaveId elave id.
   * @param ld choice to slelect.
   * @param choice manager comments.
   * @return a list of all the employees
   */
  @PUT
  @Path("pending/{leaveId}/{choice}")
//   @Path("{choice}")
//   @Path("{comments}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public final String approve(@PathParam("leaveId")final int leaveId,
        @PathParam("choice") final int choice, final LeaveDetails ld) {
    LeaveDetails ld1 = new LeaveDetails();
    return ld1.approve(leaveId, choice, ld.getManagerComments());
  }
    /**
   * Returns a list of all the employees.
   * @param leaveId elave id.
   * @param ld choice to slelect.
   * @param choice manager comments.
   * @return a list of all the employees
   */
  @PUT
  @Path("revisit/pending/{leaveId}/{choice}")
//   @Path("{choice}")
//   @Path("{comments}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public final String approveRevisit(@PathParam("leaveId")final int leaveId,
        @PathParam("choice") final int choice, final LeaveDetails ld) {
    LeaveDetails ld1 = new LeaveDetails();
    return ld1.approveRevisit(leaveId, choice, ld.getManagerComments());
  }
    //curl -H "Accept:application/json" -X PUT -H "Content-Type:application/json" -d
    //  '{"managerComments":"Angular5"}' "http://localhost:8080/ftp46/api/LeaveDetails/pending/13/1"
  /**
   * Returns pending details.
   * @param id for employee id.
   * @return pending details.
   */
  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] leavedetailspendingList(@PathParam("id")final int id) {
    final Employee empl = Employee.listById(id);
    if (empl == null) {
      throw new NotFoundException("No such Employee ID: " + id);
    } else {
      System.out.println("Employees List having Pending as leave Status");
      final LeaveDetails[] pending = LeaveDetails.leavePending(id);
      if (pending.length == 0) {
        throw new NotFoundException("No pending leaves for Employee ID: " + id);
      } else {
        return pending;
      }
    }
  }
        /**
   * Returns a specific employee's details.
   * @param id the id of the employee
   * @return the employee details
   */
  @GET
  @Path("/days/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final int listNoOfDays(@PathParam("id") final int id) {
    final int number = LeaveDetails.leaveDays(id);
    return number;
  }
     /**
   * Returns a specific employee's details.
   * @param id the id of the employee
   * @return the employee details
   */
  @GET
  @Path("/applied/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final int listNoOfLeavesApplied(@PathParam("id") final int id) {
    final int number = LeaveDetails.leaveCount(id);
    return number;
  }
     /**
   * Returns a specific employee's details.
   * @param id the id of the employee
   * @return the employee details
   */
  @GET
  @Path("/pendingcount/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final int listPendingCount(@PathParam("id") final int id) {
    final int number = LeaveDetails.managerPendingCount(id);
    return number;
  }
  /**
  * Returns pending details.
  * @param leaveId for employee id.
  * @return pending details.
  */
  @GET
  @Path("leaveId/{leaveId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails leaveDetailsByLeaveId(@PathParam("leaveId") final int leaveId) {
    final LeaveDetails leaveDetailsbyLeaveId1 = LeaveDetails.foundEmpId(leaveId);
    return leaveDetailsbyLeaveId1;
  }
    /**
  * Returns pending details.
  * @param empId for employee id.
  * @return pending details.
  */
  @GET
  @Path("latestLeave/{empId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails latestAppliedLeave(@PathParam("empId") final int empId) {
    final LeaveDetails leaveDetailsbyLeaveId1 = LeaveDetails.latestLeaveApplied(empId);
    return leaveDetailsbyLeaveId1;
  }
}
