package com.hexaware.ftp46.util;

import java.util.Scanner;

import com.hexaware.ftp46.model.Employee;
import com.hexaware.ftp46.model.LeaveDetails;

//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class CliMain provides the command line interface to the leavemanagement
 * application.
 */
public class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");
  // private int em;

  private void mainMenu() {
    System.out.println("Leave Management System");
    System.out.println("-----------------------");
    System.out.println("1. List All Employees Info");
    System.out.println("2. Display Employee Info");
    System.out.println("3. Apply Leave");
    System.out.println("4. Approve/Deny");
    System.out.println("5. Pending Leave Details");
    System.out.println("6. Leave History");
    System.out.println("7. Exit");
    System.out.println("Enter your choice:");
    int menuOption = option.nextInt();
    mainMenuDetails(menuOption);
  }

  private void mainMenuDetails(final int selectedOption) {
    switch (selectedOption) {
      case 1:
        listEmployeesDetails();
        break;
      case 2:
        listEmployeeDetail();
        break;
      case 3:
        applyleave();
        break;
      case 4:
        approveAndDeny();
        break;
      case 5:
        listLeavePending();
        break;
      case 6:
        listLeaveHistory();
        break;
      case 7:
        // halt since normal exit throws a stacktrace due to jdbc threads not responding
        Runtime.getRuntime().halt(0);
      default:
        System.out.println("Choose either 1, 2, 3, 4, 5, 6, 7");
    }
    mainMenu();
  }

  private void listEmployeeDetail() {
    System.out.println("Enter your Employee Id"); int empId = option.nextInt();
    Employee employee = Employee.listById(empId);
    if (employee == null) {
      System.out.println("Sorry, No such employee");
    } else {
      System.out.println(employee.toString());
    }
  }

  private void listEmployeesDetails() {
    Employee[] employee = Employee.listAll();
    for (Employee e : employee) {
      System.out.println(e.toString());
    }
  }
  // get managerid from database and employeeid to check.
  private void approveAndDeny() {
    System.out.println("Enter your Id");
    final int empId = option.nextInt();
    int wrongId = 1;
    boolean correctId = true;
    int pendingLeaveId;
    Employee[] employeeUnderManager = Employee.listEmployeeUnderManager(empId);
    // return employee's where mangerId=empID.
    //whether employee is manager??.
    if (employeeUnderManager.length == 0) {
      System.out.println("NOTHING TO APPROVE");
    } else {
      for (Employee el : employeeUnderManager) {
        System.out.println("Employee ID's under Manager \t" + el.getEmpId());
      }
      LeaveDetails[] leaveDetails = LeaveDetails.leavePendingUnderManager(empId);
      System.out.println(empId + " \t Inside leave Pending  ");
      if (leaveDetails.length == 0)  {
        System.out.println("No pending leave approvals");
      } else {
        for (LeaveDetails employee3 : leaveDetails) {
          System.out.println(employee3.toString());
        }
        LeaveDetails leave = new LeaveDetails();
        do {
          System.out.println("Enter the leave ID to approve/Deny");
          // leaveId
          pendingLeaveId = option.nextInt();
          for (LeaveDetails employee4 : leaveDetails) {
            if (employee4.getLeaveId() == pendingLeaveId) {
              correctId = false;
              break;
            } else {
              correctId = true;
            }
          }
          if (correctId) {
            System.out.println("please check !!!!! Enter the leave Id Displayed above");
          }
        } while (correctId);
        System.out.println("ID entered by manager \t" + pendingLeaveId);
        do {
          System.out.println("Press 1 to approve or 2 Deny");
          final int choose = option.nextInt();
          if (choose == 1 || choose == 2) {
            wrongId = 0;
            System.out.println("Comments");
            String comments = option.next();
            String status = leave.approve(pendingLeaveId, choose, comments);
            if (status.compareTo("Approve") == 0) {
              System.out.println("Leave " + status);
            } else if (status.compareTo("Denied") == 0) {
              System.out.println("Leave " + status);
            } else {
              System.out.println(status);
            }
          } else {
            System.out.println("Wrong Entry!!!!! Please Check");
            wrongId = 1;
          }
        } while (wrongId == 1);
      }
    }
    System.out.println(" TO Revisit your Decision Press 1");
    int revisit = option.nextInt();
    int revisitLeaveId;
    if (revisit == 1) {
      LeaveDetails[] leaveDetailsRevisit = LeaveDetails.leavePendingUnderManagerRevisit(empId);
      if (leaveDetailsRevisit.length == 0)  {
        System.out.println("No pending leave approvals");
      } else {
        for (LeaveDetails employeeRevisit : leaveDetailsRevisit) {
          System.out.println(employeeRevisit.toString());
        }
        // System.out.println("enter leaveID to REVIEW YOUR decision");
        // int leaveIdRevisit = option.nextInt();
        LeaveDetails leave = new LeaveDetails();
        do {
          System.out.println("Enter the leave ID to  REVIEW YOUR decision ");
          // leaveId
          revisitLeaveId = option.nextInt();
          for (LeaveDetails employeeRevisit : leaveDetailsRevisit) {
            if (employeeRevisit.getLeaveId() == revisitLeaveId) {
              correctId = false;
              break;
            } else {
              correctId = true;
            }
          }
          if (correctId) {
            System.out.println("please check !!!!! Enter the leave Id Displayed above");
          }
        } while (correctId);
        do {
          System.out.println("Press  1 to approve or 2 Deny to change ");
          final int chooseRevisit = option.nextInt();
          if (chooseRevisit == 1 || chooseRevisit == 2) {
            wrongId = 0;
            System.out.println("Comments");
            String comments = option.next();
            String status = leave.approveRevisit(revisitLeaveId, chooseRevisit, "Revisit" + comments);
            if (status.compareTo("Approve") == 0) {
              System.out.println("Leave " + status);
            } else if (status.compareTo("Denied") == 0) {
              System.out.println("Leave " + status);
            } else {
              System.out.println(status);
            }
          } else {
            System.out.println("Wrong Entry!!!!! Please Check");
            wrongId = 1;
          }
        } while (wrongId == 1);
      }
    }
  }
  private void listLeavePending() {
    System.out.println("Enter an Employee Id");
    int empId = option.nextInt();
    Employee employee = Employee.listById(empId);
    if (employee == null) {
      System.out.println("Sorry, No such employee");
    } else {
      LeaveDetails[] leaveDetails = LeaveDetails.leavePending(empId);
      if (leaveDetails.length == 0) {
        System.out.println("No pending leave approvals");
      } else {
        for (LeaveDetails l : leaveDetails) {
          System.out.println(l.toString());
        }
      }
    }
  }

  private void listLeaveHistory() {
    System.out.println("Enter your Employee Id ");
    int empId = option.nextInt();
    Employee employee = Employee.listById(empId);
    if (employee == null) {
      System.out.println("Sorry, No such employee");
    } else {
      LeaveDetails[] leaveDetails = LeaveDetails.leaveHistory(empId);
      if (leaveDetails.length == 0) {
        System.out.println("No leave history");
      } else {
        for (LeaveDetails m : leaveDetails) {
          System.out.println(m.toString());
        }
      }
    }
  }
  private void applyleave() {
    System.out.println("Enter your Employee Id");
    int empId = option.nextInt();
    Employee employee = Employee.listById(empId);
    if (employee == null) {
      System.out.println("Sorry, No such employee");
    } else {
      int lb = employee.getEmpLeaveBalance();
      if (lb != 0) {
        Date cDate = new Date();
        int d, d1;
        Date startDate = null;
        Date endDate = null;
        do {
          System.out.println("Enter start date(yyyy-MM-dd)");
          String date = option.next();
          startDate = LeaveDetails.leaveDate(date);
          d = LeaveDetails.noOfDaysInLeave(cDate, startDate);
          if (d <= 1) {
            System.out.println("start date should exceed applied date ");
          }
        } while (d <= 1);
        do {
          System.out.println("enter end date(yyyy-MM-dd)");
          String date = option.next();
          endDate = LeaveDetails.leaveDate(date);
          d1 = LeaveDetails.noOfDaysInLeave(startDate, endDate);
          if (d1 < 1) {
            System.out.println("end date should exceed start date ");
          }
        } while (d1 < 1);

        int noOfDays = LeaveDetails.noOfDaysInLeave(startDate, endDate);
        if (lb > noOfDays || lb == noOfDays) {
          System.out.println("enter reason");
          String reason = option.next();
          System.out.println("Select leave type  \t 1->El \t 2-> SICK \t 3->ML-PL  ");
          int leaveOption = option.nextInt();
          String apply = LeaveDetails.applyLeave(startDate, endDate, reason, empId, leaveOption);
          System.out.println(apply);
          LeaveDetails ld = LeaveDetails.latestLeaveApplied(empId);
          System.out.println(ld.toString());
        } else {
          System.out.println("applied no of days exceeds your leave balance");
        }
      } else {
        System.out.println("Your leave balance is zero");
      }
    }
  }

  /**
   * call toString Method
   */
  /**
   * The main entry point.
   *
   * @param ar the list of arguments
   */
  public static void main(final String[] ar) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }
}
