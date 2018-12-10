package com.hexaware.ftp46.model;

//import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;
import com.hexaware.ftp46.persistence.DbConnection;
import com.hexaware.ftp46.persistence.EmployeeDAO;
//import com.hexaware.ftp46.util.EmployeeRest;
import java.util.Objects;
import java.util.List;
/**
 * Employee class to store employee personal details.
 *
 * @author hexware
 */
public class Employee {
  /**
   * empId to store employee id.
   */
  private int empId;
  private String empName;
  private String empDoj;
  private int managerId;
  private String empEmail;
  private int empLeaveBalance;
  private Long empPhone;
  private String empDepartment;
  private String empProfileUrl;

  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Employee emp = (Employee) obj;
    if (Objects.equals(empId, emp.empId) && Objects.equals(empName, emp.empName) && Objects.equals(empDoj, emp.empDoj)
        && Objects.equals(managerId, emp.managerId) && Objects.equals(empEmail, emp.empEmail)
        && Objects.equals(empLeaveBalance, emp.empLeaveBalance) && Objects.equals(empPhone, emp.empPhone)
        && Objects.equals(empDepartment, emp.empDepartment)
        && Objects.equals(empProfileUrl, emp.empProfileUrl)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(empId, empName, empDoj, managerId, empEmail, empLeaveBalance,
      empPhone, empDepartment, empProfileUrl);
  }

  /**
   * @param argEmpId           to initialize employee id.
   * @param argEmpName         to initialize employee id.
   * @param argEmpDoj          to initialize employee id.
   * @param argManagerId       to initialize employee id.
   * @param argEmpEmail        to initialize employee id.
   * @param argEmpLeaveBalance to initialize employee id.
   * @param argEmpPhone        to initialize employee id.
   * @param argEmpDepartment   to initialize employee id.
   * @param argEmpProfileUrl   to initialize employee id.
   */
  public Employee(final int argEmpId, final String argEmpName, final String argEmpDoj, final int argManagerId,
      final String argEmpEmail, final int argEmpLeaveBalance, final Long argEmpPhone,
      final String argEmpDepartment, final String argEmpProfileUrl) {
    this.empId = argEmpId;
    this.empName = argEmpName;
    this.empDoj = argEmpDoj;
    this.managerId = argManagerId;
    this.empEmail = argEmpEmail;
    this.empLeaveBalance = argEmpLeaveBalance;
    this.empPhone = argEmpPhone;
    this.empDepartment = argEmpDepartment;
    this.empProfileUrl = argEmpProfileUrl;
  }

  /**
   * Empty Constructor.
   */
  public Employee() {

  }

  /**
   * Gets the EmployeeId.
   *
   * @return this Employee's ID.
   */
  public final int getEmpId() {
    return empId;
  }

  /**
   * Gets the EmployeeId.
   *
   * @return this Employee's ID.
   */
  public final String getEmpName() {
    return empName;
  }

  /**
   * Gets the EmployeeId.
   *
   * @return this Employee's ID.
   */

  public final String getEmpDoj() {
    return empDoj;
  }

  /**
   * Gets the EmployeeId.
   *
   * @return this Employee's ID.
   */

  public final int getManagerId() {
    return managerId;
  }

  /**
   * Gets the EmployeeId.
   *
   * @return this Employee's ID.
   */

  public final String getEmpEmail() {
    return empEmail;
  }
   /**
   * Gets the EmployeeId.
   *
   * @return this Employee's ID.
   */

  public final String getEmpProfileUrl() {
    return empProfileUrl;
  }

  /**
   * Gets the EmployeeId.
   *
   * @return this Employee's ID.
   */

  public final int getEmpLeaveBalance() {
    return empLeaveBalance;
  }

  /**
   * Gets the EmployeeId.
   *
   * @return this Employee's ID.
   */

  public final Long getEmpPhone() {
    return empPhone;
  }

  /**
   * Gets the EmployeeId.
   *
   * @return this Employee's ID.
   */

  public final String getEmpDepartment() {
    return empDepartment;
  }

  /**
   *
   * @param argEmpId to set employee id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }

  /**
   *
   * @param argEmpName to set employee id.
   */
  public final void setEmpName(final String argEmpName) {
    this.empName = argEmpName;
  }

  /**
   *
   * @param argManagerId to set employee id.
   */

  public final void setManagerId(final int argManagerId) {
    this.managerId = argManagerId;
  }
    /**
   *
   * @param argEmpProfileUrl to set employee id.
   */

  // public final void setEmpProfileUrl(final String argEmpProfileUrl) {
  //   this.empProfileUrl = argEmpProfileUrl;
  // }

  /**
   *
   * @param argEmpEmail to set employee id.
   */

  public final void setEmpEmail(final String argEmpEmail) {
    this.empEmail = argEmpEmail;
  }

  /**
   *
   * @param argEmpDoj to set employee id.
   */

  public final void setEmpDoj(final String argEmpDoj) {
    this.empDoj = argEmpDoj;
  }

  /**
   *
   * @param argEmpPhone to set employee id.
   */

  public final void setEmpPhone(final Long argEmpPhone) {
    this.empPhone = argEmpPhone;
  }

  /**
   *
   * @param argEmpLeaveBalance to set employee id.
   */

  public final void setEmpLeaveBalance(final int argEmpLeaveBalance) {
    this.empLeaveBalance = argEmpLeaveBalance;
  }

  /**
   *
   * @param argEmpDepartment to set employee id.
   */

  public final void setEmpDepartment(final String argEmpDepartment) {
    this.empDepartment = argEmpDepartment;
  }

  /**
   * @return tostring Method.
   */
  public final String toString() {
    return "\n\n<<<<<<<EMPLOYEE DETAILS>>>>>>\n" + "EMP id \t" + this.empId + "\n" + "Employee Name \t"
      + this.empName + "\n" + "Mananger ID:\t"
      + this.managerId + "\n" + "Number of leaves \t" + this.empLeaveBalance + "\n"
      + "Employee phone number \t" + this.empPhone + "\n"
      + "Employee email \t" + this.empEmail + "\n" + "Employee DOJ \t" + this.empDoj + "\n"
      + "Employee Department \t" + this.empDepartment + "\n" + "\n"
      + "Employee Profile URL \t" + this.empProfileUrl + "\n" + "<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>\n\n";
  }

  /**
   * The dao for employee.
   */
  private static EmployeeDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }
  /**
   * list all employee details.
   *
   * @return all employees' details
   */
  public static Employee[] listAll() {
    List<Employee> es = dao().list();
    return es.toArray(new Employee[es.size()]);
  }
  /**
   * list employee details by id.
   * @param empID id to get employee details.
   * @return Employee
   */
  public static Employee listById(final int empID) {
    return dao().find(empID);
  }
    /**
   * list employee details by id.
   * @param empID id to get employee details.
   * @return Employee
   */
  public static Employee empProfileUrl(final int empID) {
    return dao().findProfileUrl(empID);
  }
   /**
   * list employee details by id.
   *
   * @param empId id to get employee details.
   * @param noOfDays no of days leave applid.
   * @return bal.
   */
  public static String leaveBalDec(final int empId, final int noOfDays) {
    Employee employee = Employee.listById(empId);
    int lb = employee.getEmpLeaveBalance();
    int lbd = (lb - noOfDays);
    dao().updateLeaveBal(empId, lbd);
    return "Leave balance decremented";
  }
  // /**
  //  * @param empID id to get employee details.
  //  * @return Employee
  //  */
  // public static Employee listManager(final int empID) {
  //   return dao().findManager(empID);
  // }
  /**
   * list employee details by id.
   * @param empId id to get employee details.
   * @return Employee
   */
  public static Employee[] listEmployeeUnderManager(final int empId) {
    List<Employee> es = dao().findIfManager1(empId);
    return es.toArray(new Employee[es.size()]);
  }
    /**
   * list employee details by id.
   * @param empId id to get employee details.
   * @param number2 number 2.
   * @return update.
   */
  public static String incrementLeaveBalance(final int empId, final int number2) {
    dao().updateLeaveBal(empId, number2);
    return "incremented leave balance";
  }
    /**
   * @param emp manager id.
   * @return no of employees under manager.
   */
  public static int noOfEmployees(final int emp) {
    int no = dao().findNoOfEmployees(emp);
    return no;
  }
}

