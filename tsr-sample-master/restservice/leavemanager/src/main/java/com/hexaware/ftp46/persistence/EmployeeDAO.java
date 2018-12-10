package com.hexaware.ftp46.persistence;

import com.hexaware.ftp46.model.Employee;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

/**
 * The DAO class for employee.
 */
public interface EmployeeDAO  {
  /**
   * return all the details of all the employees.
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM EMPLOYEE")
  @Mapper(EmployeeMapper.class)
  List<Employee> list();

  /**
   * return all the details of the selected employee.
   * @param empID the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM EMPLOYEE WHERE EMP_ID = :empID")
  @Mapper(EmployeeMapper.class)
  Employee find(@Bind("empID") int empID);
    /**
   * return all the details of the selected employee.
   * @param empID the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM EMPLOYEE WHERE EMP_ID = :empID")
  @Mapper(EmployeeMapper.class)
  Employee findProfileUrl(@Bind("empID") int empID);
  /**
   * return all the details of all the employees.
   * @param empId a
   * @param empLeaveBal elb
   * @return l.
   */
  @SqlUpdate("UPDATE EMPLOYEE SET EMP_LEAVE_BAL = :leaveBal WHERE EMP_ID = :empId")
  int updateLeaveBal(@Bind("empId") int empId, @Bind("leaveBal") int empLeaveBal);
   /**
   * return all the details of the selected employee.
   * @param empID the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM EMPLOYEE WHERE EMP_ID = :empId")
  @Mapper(EmployeeMapper.class)
  Employee findManager(@Bind("empId")int empID);
   /**
   * return all the details of the selected employee.
   * @param empId the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM EMPLOYEE WHERE MANAGER_ID = :empId")
  @Mapper(EmployeeMapper.class)
  List<Employee> findIfManager1(@Bind("empId")int empId);
     /**
   * return all the details of the selected employee.
   * @param emp the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT COUNT(*) FROM EMPLOYEE WHERE MANAGER_ID = :emp")
  int  findNoOfEmployees(@Bind("emp")int emp);
  /**
  * close with no args is used to close the connection.
  */
  void close();
}
