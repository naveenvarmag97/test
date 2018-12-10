package com.hexaware.ftp46.model;
//import java.time.Instant;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
//import java.util.List;
import java.util.Objects;
//import java.util.Scanner;
import com.hexaware.ftp46.persistence.LeaveDetailsDAO;
import com.hexaware.ftp46.persistence.DbConnection;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
//import com.hexaware.ftp46.model.Employee;
/**
 * Empty Constructor.
 */
public class LeaveDetails {
  private  int empId;
  private int leaveId;
  private String startDate;
  private String endDate;
  private String appliedOn;
  private int noOfDays;
  private LeaveType leaveType;
  private String reason;
  private LeaveStatus leaveStatus;
  private String managerComments;

  /**
   * @return Empty Constructor.
   * @param obj equal method.
   */
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    LeaveDetails lev = (LeaveDetails) obj;
    if (Objects.equals(empId, lev.empId) && Objects.equals(leaveId, lev.leaveId)
        && Objects.equals(startDate, lev.startDate) && Objects.equals(endDate, lev.endDate)
        && Objects.equals(appliedOn, lev.appliedOn) && Objects.equals(noOfDays, lev.noOfDays)
        && Objects.equals(leaveStatus, lev.leaveStatus) && Objects.equals(reason, lev.reason)
        && Objects.equals(managerComments, lev.managerComments) && Objects.equals(leaveType, lev.leaveType)) {
      return true;
    }
    return false;
  }

  /**
   * @return Empty Constructor.
   */
  public final int hashCode() {
    return Objects.hash(empId, leaveId, startDate, endDate, appliedOn, noOfDays, leaveStatus, reason, managerComments,
        leaveType);
  }

  /**
   * @param argEmpId           to initialize employee id.
   * @param argLeaveId         to initialize employee id.
   * @param argStartDate       initialize employee id.
   * @param argEndDate         to initialize employee id.
   * @param argAppliedOn       to initialize employee id.
   * @param argNoOfDays        to initialize employee id.
   * @param argLeaveType       to initialize employee id.
   * @param argLeaveStatus     to initialize employee id.
   * @param argReason          to initialize employee id
   * @param argManagerComments to initialize employee id
   */
  public LeaveDetails(final int argLeaveId, final int argEmpId, final String argStartDate, final String argEndDate,
      final String argAppliedOn, final int argNoOfDays, final LeaveType argLeaveType, final String argReason,
      final String argManagerComments, final LeaveStatus argLeaveStatus) {
    this.leaveId = argLeaveId;
    this.empId = argEmpId;
    this.startDate = argStartDate;
    this.endDate = argEndDate;
    this.appliedOn = argAppliedOn;
    this.noOfDays = argNoOfDays;
    this.leaveType = argLeaveType;
    this.reason = argReason;
    this.managerComments = argManagerComments;
    this.leaveStatus = argLeaveStatus;

  }

  /**
   * Empty Constructor.
   */
  public LeaveDetails() {

  }

  /**
   * Gets the EmployeeId.
   *
   * @return this Employee's ID.
   */
  public final int getLeaveEmpId() {
    return empId;
  }

   /**
   * Gets the EmployeeId.
   *
   * @return Leave ID.
   */
  public final int getLeaveId() {
    return leaveId;
  }


  /**
   * Gets the EmployeeId.
   *
   * @return start Date.
   */
  public final String getStartDate() {
    return startDate;
  }
   /**
   * Gets the EmployeeId.
   *
   * @return this.
   */
  public final String getAppliedOn() {
    return appliedOn;
  }

  /**
   * Gets the EmployeeId.
   *
   * @return this Employee's ID.
   */

  public final String getEndDate() {
    return endDate;
  }

  /**
   * Gets the EmployeeId.
   *
   * @return this Employee's ID.
   */

  public final int getNoOfDays() {
    return noOfDays;
  }

  /**
   * Gets the EmployeeId.
   *
   * @return this Employee's ID.
   */

  public final LeaveType getLeaveType() {
    return leaveType;
  }

  /**
   * Gets the EmployeeId.
   *
   * @return this Employee's ID.
   */

  public final String getReason() {
    return reason;
  }

  /**
   * Gets the EmployeeId.
   *
   * @return this Employee's ID.
   */

  public final String getManagerComments() {
    return managerComments;
  }

  /**
   * Gets the EmployeeId.
   *
   * @return this Employee's ID.
   */

  public final LeaveStatus getLeaveStatus() {
    return leaveStatus;
  }
  /**
   *
   * @param argLeaveId to set employee id.
   */
  public final void setLeaveId(final int argLeaveId) {
    this.leaveId = argLeaveId;
  }

  /**
   *
   * @param argEmpId to set employee id.
   */
  public final void setLeaveEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }

  /**
   *
   * @param argStartDate to set employee id.
   */

  public final void setStartDate(final String argStartDate) {
    this.startDate = argStartDate;
  }

  /**
   *
   * @param argEndDate to set employee id.
   */

  public final void setEnddate(final String argEndDate) {
    this.endDate = argEndDate;
  }

  /**
   *
   * @param argAppliedOn to set employee id.
   */

  public final void setAppliedOn(final String argAppliedOn) {
    this.appliedOn = argAppliedOn;
  }

  /**
   *
   * @param argNoOfDays to set employee id.
   */

  public final void setNoOfDays(final int argNoOfDays) {
    this.noOfDays = argNoOfDays;
  }

  /**
   *
   * @param argLeaveType to set employee id.
   */

  public final void setLeaveType(final LeaveType argLeaveType) {
    this.leaveType = argLeaveType;
  }

  /**
   *
   * @param argReason to set employee id.
   */

  public final void setReason(final String argReason) {
    this.reason = argReason;
  }

  /**
   * @param argManagerComments to set employee id.
   */

  public final void setManagerComments(final String argManagerComments) {
    this.managerComments = argManagerComments;
  }

  /**
   * @param argLeaveStatus to set employee id.
   */

  public final void setLeaveStatus(final LeaveStatus argLeaveStatus) {
    this.leaveStatus = argLeaveStatus;
  }

  /**
   * @return tostring Method.
   */
  public final String toString() {
    return "\n<<<<<<<<LEAVE DETAILS>>>>>>>>>\n" + "Leave Id \t" + "<<<  " + this.leaveId + "  >>>" + "\n"
         + "Employee Id \t"
         + this.empId + "\n"
         + "Start Date\t"
         + this.startDate + "\n" + "End Date\t"
         + this.endDate + "\n" + "Applied On \t" + this.appliedOn + "\n" + "No of Days \t"
         + this.noOfDays + "\n" + "Leave type \t"
         + this.leaveType + "\n" + "reason \t\t" + this.reason + "\n" + "Manager Comments "
         + this.managerComments + "\n" + "Leave status \t"
         + this.leaveStatus + "\n" + "<<<<<<<<<<<<<<<>>>>>>>>>>>>>\n";
  }
  /**
   * @param empID tostring Method.
   * @return history.
   */
  public static  LeaveDetails[] leaveHistory(final int empID) {
    List<LeaveDetails> ld = dao().history(empID);
    return ld.toArray(new LeaveDetails[ld.size()]);
  }


/**
   * The dao for employee.
   * The dao for LeaveDetails.
   */
  private static LeaveDetailsDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(LeaveDetailsDAO.class);
  }
  /**
   * list all employee details.
   * @param empID employee id.
   * @return all LeaveDetails.
   */
  public static LeaveDetails[] leavePending(final int empID) {
    List<LeaveDetails> lp = dao().pending(empID);
    return lp.toArray(new LeaveDetails[lp.size()]);
  }
 /**
   * list all employee details.
   * @param startDate sd.
   * @param endDate ed.
   * @param reason r.
   * @param empID e.
   * @param leaveOption e.
   * @return apply leave details.
   */
  public static String applyLeave(final Date startDate, final Date endDate,
      final String reason, final int empID, final int leaveOption) {
    Employee emp = Employee.listById(empID);
    String leaveType = "EL";
    if (leaveOption == 1) {
      leaveType = "EL";
    } else if (leaveOption == 2) {
      leaveType = "SICK";
    } else {
      leaveType = "PLML";
    }
    String leaveStatus = "PENDING";
    String mgrCmt = " ";
    Date cdate = new Date();
    int noOfDays1 = LeaveDetails.noOfDaysInLeave(cdate, startDate);
    int noOfDays2 = LeaveDetails.noOfDaysInLeave(startDate, endDate);
    if (noOfDays1 <= 0) {
      return "start date should exceed applied date ";
    }
    if (noOfDays2 <= 0) {
      return "end date should exceed start date ";
    }

      // if ((((startDate.compareTo(s) > 0) || (startDate.compareTo(s) == 0)) && ((startDate.compareTo(e) < 0)
      //     || (startDate.compareTo(e) == 0))) || (((endDate.compareTo(s) > 0) || (endDate.compareTo(s) == 0))
      //     && ((endDate.compareTo(e) < 0) || (endDate.compareTo(e) == 0)))) {
      //   return "This Leave is Overlaping with the previous applied Leave with leave Id" + m.leaveId;
      // }
    String ss = reduceApply(startDate, endDate, empID);
    if (ss != "ok") {
      return ss;
    }
    if (noOfDays2 > emp.getEmpLeaveBalance()) {
      return "number of days exceeds your leave balance";
    }
    System.out.println("leaveType ffffff" + leaveType);
    dao().apply(startDate, endDate, noOfDays2, leaveType, reason, leaveStatus, empID, mgrCmt);
    Employee.leaveBalDec(empID, noOfDays2);
    //
    final String phoneNumer = Long.toString(emp.getEmpPhone());
    String empNameSms = emp.getEmpName();
    //System.out.println("done");
    final String accSid = "AC67fa152aa60c2eabf967e34716904693";
    final String authSid = "9bd2ddc5f50a0f1571f9273bde9857b0";
    Twilio.init(accSid, authSid);
    Message message = Message
        .creator(new PhoneNumber("+" + phoneNumer), new PhoneNumber("+18507067695"),
        "Dear-> " + empNameSms + " YOU HAVE SUCCESSFULLY APPLIED FOR LEAVE ,LMS")
        .create();
    System.out.println("hello smsms" + phoneNumer + "nummmerr" + message.getSid());
    //

    return "Leave applied successfully";
  }
  /**
   * list all employee details.
   * @param startDate sd.
   * @param endDate ed.
   * @param empID e.
   * @return struinds
   */
  public static String reduceApply(final Date startDate, final Date endDate, final int empID) {
    LeaveDetails[] leaveDetails = LeaveDetails.leaveHistory(empID);
    for (LeaveDetails m : leaveDetails) {
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      Date s = null;
      Date e = null;
      try {
        s = dateFormat.parse(m.startDate);
        e = dateFormat.parse(m.endDate);
        if ((startDate.compareTo(s) > 0 || startDate.compareTo(s) == 0)
                            && (startDate.compareTo(e) < 0
            || startDate.compareTo(e) == 0)) {
          return "this leave is overlapping with leaveId " + m.leaveId;
        } else if ((endDate.compareTo(s) > 0
            || endDate.compareTo(s) == 0)
            && (endDate.compareTo(e) < 0 || endDate.compareTo(e) == 0)) {
          return "this leave is overlapping with leaveId " + m.leaveId;
        }
      } catch (ParseException ex) {
        System.out.println(ex);
      }
    }
    return "ok";
  }
  /**
   * list all employee details.
   * @param startDate sd.
   * @param endDate ed.
   * @param reason r.
   * @param empID e.
   * @param leaveId e.
   * @return apply leave details.
   */
  public static String editapplyLeave(final Date startDate, final Date endDate,
      final String reason, final int empID, final int leaveId) {
    Employee em = Employee.listById(empID);
    String leavType = "EL";
    String leaveStas = "PENDING";
    String mgrComt = " ";
    Date cdaate = new Date();
    int noODays1 = LeaveDetails.noOfDaysInLeave(cdaate, startDate);
    int noODays2 = LeaveDetails.noOfDaysInLeave(startDate, endDate);
    if (noODays1 <= 0) {
      return "start date should exceed applied date ";
    }
    if (noODays2 <= 0) {
      return "end date should exceed start date ";
    }
    String ss = reduceApply(startDate, endDate, empID);
    if (ss != "ok") {
      return ss;
    }
    if (noODays2 > em.getEmpLeaveBalance()) {
      return "number of days exceeds your leave balance";
    }
    dao().editApply(startDate, endDate, noODays2, leavType, reason, leaveStas, empID, mgrComt, leaveId);
    Employee.leaveBalDec(empID, noODays2);
    return "Leave updated successfully";
  }
  /**
   * list all employee details.
   * @param startDate sd
   * @param endDate ed
   * @return all employees' details
   */
  public static int noOfDaysInLeave(final Date startDate, final Date endDate) {
    // int noOfDays = (int) ((endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24));
    // noOfDays = noOfDays + 1;
    // return noOfDays;
    Date[] holidays = {leaveDate("2018-01-01"), leaveDate("2018-01-26"), leaveDate("2018-03-02"),
        leaveDate("2018-03-30"), leaveDate("2018-05-01"), leaveDate("2018-06-15"),
        leaveDate("2018-08-15"), leaveDate("2018-09-13"), leaveDate("2018-10-02"),
        leaveDate("2018-10-18"), leaveDate("2018-10-19"), leaveDate("2018-11-01"),
        leaveDate("2018-11-06"), leaveDate("2018-12-25")};
    Calendar startCal = Calendar.getInstance();
    startCal.setTime(startDate);
    Calendar endCal = Calendar.getInstance();
    endCal.setTime(endDate);
    int workDays = 0;
    //Return 0 if start and end are the same
    if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
      return 1;
    }
    if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
      startCal.setTime(endDate);
      endCal.setTime(startDate);
    }
  do {
       //excluding start date
      startCal.add(Calendar.DAY_OF_MONTH, 1);
      if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
          && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
        ++workDays;
      }
    } while (startCal.getTimeInMillis() < endCal.getTimeInMillis()); //excluding end date
    for (int i = 0; i < holidays.length; i++) {
      if (startDate == holidays[i] || endDate == holidays[i]) {
        --workDays;
      }
      if (holidays[i].compareTo(startDate) > 0 && holidays[i].compareTo(endDate) < 0) {
        --workDays;
      }
    }
    return workDays + 1;
  }
  /**
   * list all employee details.
   * param startDate sd
   * param endDate ed
   * return all employees' details
   */
  /*public static Date currentDate(){
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      System.out.println("Enter start date(yyyy-MM-dd)");
      Date cDate = new Date();
      String date = option.next();
      Date startDate = null;
      try {
        startDate = dateFormat.parse(date);
              } catch (ParseException e) {
          e.printStackTrace();
          return cDate;
  // }
}*/

  /**
   * list all employee details.
   * @param empId ed
   * @return all employees' details
   */
  public static LeaveDetails latestLeaveApplied(final int empId) {
    return dao().findLatest(empId);
  }
  /**
   * list all employee details.
   * @return all Leave details.
   * @param empId employee id.
   */
  public static LeaveDetails[] leavePendingUnderManager(final int empId) {
    List<LeaveDetails> lp = dao().daoLeavePendingUnderManager(empId);
    return lp.toArray(new LeaveDetails[lp.size()]);
  }
  /**
   * list all employee details.
   * @return all Leave details.
   * @param empId employee id.
   */
  public static LeaveDetails[] leavePendingUnderManagerRevisit(final int empId) {
    List<LeaveDetails> lp = dao().daoLeavePendingUnderManagerRevisit(empId);
    return lp.toArray(new LeaveDetails[lp.size()]);
  }
  /**
   * list all employee details.
   * @param pendingLeaveId employee id.
   * @param choice employee id.
   * @param comments employee id
   * @return all Leave details.
   * employee id.
   */
  public final String approve(final int pendingLeaveId, final int choice, final String comments) {
    // System.out.println("employee id" + leaveId);
    // System.out.println("Press 1 to aprrove");
    // System.out.println("Press 2 to Deny");
    /**
     * The dao for LeaveDetails.
    */
    //LeaveDetails ld = new LeaveDetails();
    if (choice == 1) {
      managerComments(comments, pendingLeaveId);
      // LeaveDetails ld= new LeaveDetails();
      approved(pendingLeaveId);
      //System.out.println(x);
      // sc.close();
      return "Approved";
    } else if (choice == 2) {
      managerComments(comments, pendingLeaveId);
      //manager Comments.
      denied(pendingLeaveId);
      // sc.close();
      //System.out.println("leave denied");
      return "Denied";
    } else {
      return "Incorrect leaveId";
    }
  }
   /**
   * list all employee details.
   * @param revisitLeaveId employee id.
   * @param choice employee id.
   * @param comments employee id
   * @return all Leave details.
   * employee id.
   */
  public final String approveRevisit(final int revisitLeaveId, final int choice, final String comments) {
    // System.out.println("employee id" + leaveId);
    // System.out.println("Press 1 to aprrove");
    // System.out.println("Press 2 to Deny");
    /**
     * The dao for LeaveDetails.
    */
    //LeaveDetails ld = new LeaveDetails();
    if (choice == 1) {
      managerComments("after revisit A" + comments, revisitLeaveId);
      // LeaveDetails ld= new LeaveDetails();
      approved(revisitLeaveId);
      //System.out.println(x);
      // sc.close();
      return "Revisit Approved";
    } else if (choice == 2) {
      managerComments("after revisit 2" + comments, revisitLeaveId);
      //manager Comments.
      denied(revisitLeaveId);
      // sc.close();
      //System.out.println("leave denied");
      return "Revisit Denied";
    } else {
      return "Incorrect leaveId";
    }
  }
  /**
   * list all employee details.
   * @param comments employee id
   * @param pendingLeaveId employee id
   * @return managerComments.
   */
  public  final String managerComments(final String comments, final int pendingLeaveId) {
    //System.out.println("Comments");
    /**
     * The dao for LeaveDetails.
    */
    // Scanner s1 = new Scanner(System.in);
    // managerComments = s1.nextLine();
    System.out.println("in approve 1 " + pendingLeaveId);
    dao().daoManagerComments(comments, pendingLeaveId);
    return "Manager comments Updated";
  }
  /**
   * @param pendingLeaveId list all employee details.
   * @return managerComments.
   */
  public  final String approved(final int pendingLeaveId) {
    System.out.println("Approved");
    final String approved = "APPROVED";
    dao().updateApproved(approved, pendingLeaveId);
    LeaveDetails leaveDetails = LeaveDetails.foundEmpId(pendingLeaveId);
    Employee employee = dao().findNumber(leaveDetails.empId);
    final String phoneNumer = Long.toString(employee.getEmpPhone());
    String empNameSms = employee.getEmpName();
    //System.out.println("done");
    final String accSid = "AC67fa152aa60c2eabf967e34716904693";
    final String authSid = "9bd2ddc5f50a0f1571f9273bde9857b0";
    Twilio.init(accSid, authSid);
    Message message = Message
        .creator(new PhoneNumber("+" + phoneNumer), new PhoneNumber("+18507067695"),
        "Dear-> " + empNameSms + " YOUR LEAVE HAS BEEN APPROVED")
        .create();
    System.out.println("hello smsms" + phoneNumer + "nummmerr" + message.getSid());

    return "Leave Approved";
  }
  /**
   * @param pendingLeaveId list all employee details.
   * @return list all employee details.
   * list all employee details.
   */
  public static final LeaveDetails foundEmpId(final int pendingLeaveId) {
    return dao().employeeId(pendingLeaveId);
  }
  /**
   * @param pendingLeaveId list all employee details.
   * list all employee details.
   * @return managerComments.
   */
  public  static String denied(final int pendingLeaveId) {
    final String denied = "DENIED";
    System.out.println("Denied");
    dao().updateDenied(pendingLeaveId, denied);
    LeaveDetails leaveDetails = LeaveDetails.foundEmpId(pendingLeaveId);
    Employee employee = dao().findNumber(leaveDetails.empId);
    String empNameSms = employee.getEmpName();
    final String phoneNumer = Long.toString(employee.getEmpPhone());
    //System.out.println("done");
  // Find your Account Sid and Token at twilio.com/user/account
    final String accSid = "AC67fa152aa60c2eabf967e34716904693";
    final String authSid = "9bd2ddc5f50a0f1571f9273bde9857b0";
    Twilio.init(accSid, authSid);
    Message message = Message
        .creator(new PhoneNumber("+" + phoneNumer), new PhoneNumber("+18507067695"),
        "Dear->" + empNameSms + "YOUR LEAVE HAS BEEN DENIED")
        .create();
    System.out.println("sms test" + phoneNumer + "nummmerr" + message.getSid());
   // LeaveDetails leaveDetails = LeaveDetails.foundEmpId(pendingLeaveId);
    int empId = leaveDetails.getLeaveEmpId();
    Employee employeeList = Employee.listById(empId);
    int noOfLeaveBalance = employeeList.getEmpLeaveBalance();
    int noOfDays = leaveDetails.getNoOfDays();
    int leaveBalanceUpdated = noOfLeaveBalance + noOfDays;
    Employee.incrementLeaveBalance(empId, leaveBalanceUpdated);
    return "Leave";
  }
    /**
   * @param date list all employee details.
   * list all employee details.
   * @return managerComments.
   */
  public static final Date leaveDate(final String date) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date enteredleaveDate = null;
    try {
      enteredleaveDate = dateFormat.parse(date);
    } catch (ParseException e) {
      System.out.println(e);
    }
    return enteredleaveDate;
  }
    /**
   * @param empId employeeId.
   * @return days.
   */
  public static final int leaveDays(final int empId) {
    int days = dao().daoLeavePendingUnderManagerCount(empId);
    return days;
  }
     /**
   * @param empId employeeId.
   * @return days.
   */
  public static final int leaveCount(final int empId) {
    int count = dao().leaveCount(empId);
    return count;
  }
    /**
   * @param empId employeeId.
   * @return days.
   */
  public static final int managerPendingCount(final int empId) {
    int count = dao().daoLeavePendingUnderManagerLeaveCount(empId);
    return count;
  } 
}
