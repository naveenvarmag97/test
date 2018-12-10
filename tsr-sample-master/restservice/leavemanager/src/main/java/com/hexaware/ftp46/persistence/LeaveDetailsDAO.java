package com.hexaware.ftp46.persistence;
import com.hexaware.ftp46.model.Employee;

import com.hexaware.ftp46.model.LeaveDetails;
//import com.hexaware.ftp46.util.LeaveDetailsRest;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.Date;
//import java.util.Date;
import java.util.List;
/**
 * The DAO class for LeaveDetails.
 */
public interface LeaveDetailsDAO {
  /**
   * return all the details of all the employees.
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> listleavedetails();
  /**
   * return all the leave details of the selected employee.
   * @param pendingLeaveId the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE LEAVE_ID= :pendingLeaveId")
  @Mapper(LeaveDetailsMapper.class)
  LeaveDetails employeeId(@Bind("pendingLeaveId") int pendingLeaveId);
  /**
   * return all the leave details of the selected employee.
   * @param empID the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE EMP_ID = :empID")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> history(@Bind("empID") int empID);
  /**
   * return all the pending leave details of selected employee.
   * @param empID the id of the employee.
   * @return the employee object.
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE EMP_ID = :empID AND LEAVE_STATUS ='PENDING'")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> pending(@Bind("empID") int empID);
  /**
   * return all the details of the selected employee.
   * @param empId the id of the employee
   * @param startDate sd
   * @param endDate ed
   * @param reason  r
   * @param noOfDays n
   * @param leaveStatus ls
   * @param leaveType lt
   * @param mgrCmt manager comments.
   */
  @SqlUpdate("INSERT INTO LEAVE_DETAILS(START_DATE,END_DATE,NO_OF_DAYS,"
      + "LEAVE_TYPE,REASON,LEAVE_STATUS,APPLIED_ON,EMP_ID,MANAGER_COMENTS) VALUES(:startDate,"
      + ":endDate,:noOfDays,:leaveType,:reason,:leaveStatus,curdate(),:empID,:mgrCmt)")
  @Mapper(LeaveDetailsMapper.class)
  void apply(@Bind("startDate") Date startDate, @Bind("endDate") Date endDate,
      @Bind("noOfDays") int noOfDays, @Bind("leaveType") String leaveType,
      @Bind("reason") String reason, @Bind("leaveStatus") String leaveStatus,
      @Bind("empID") int empId, @Bind("mgrCmt") String mgrCmt);
  /**
   * return all the details of the selected employee.
   * @param empId the id of the employee
   * @param startDate sd
   * @param endDate ed
   * @param reason  r
   * @param noOfDays n
   * @param leaveStatus ls
   * @param leaveType lt
   * @param leaveId lId
   * @param mgrCmt manager comments.
   */
  @SqlUpdate("UPDATE LEAVE_DETAILS  SET START_DATE =:startDate, END_DATE=:endDate, REASON=:reason, NO_OF_DAYS=:noOfDays"
      + " WHERE LEAVE_ID=:leaveId")
  @Mapper(LeaveDetailsMapper.class)
  void editApply(@Bind("startDate") Date startDate, @Bind("endDate") Date endDate,
      @Bind("noOfDays") int noOfDays, @Bind("leaveType") String leaveType,
      @Bind("reason") String reason, @Bind("leaveStatus") String leaveStatus,
      @Bind("empID") int empId, @Bind("mgrCmt") String mgrCmt, @Bind("leaveId") int leaveId);
  /**
   * return all the details of the selected employee.
   * @param empId the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS where emp_id = :empID order by LEAVE_ID desc limit 1")
  @Mapper(LeaveDetailsMapper.class)
  LeaveDetails findLatest(@Bind("empID") int empId);
  /**
   * return all the pending leave details of selected employee.
   * @param approved the approved staus
   * @param pendingLeaveId the id of the employee.
   * @return the integer value.
   */
  @SqlUpdate("UPDATE LEAVE_DETAILS SET LEAVE_STATUS= :approved WHERE LEAVE_ID= :pendingLeaveId ")
  @Mapper(LeaveDetailsMapper.class)
  int updateApproved(@Bind("approved") String approved, @Bind("pendingLeaveId") int pendingLeaveId);
 /**
   * return all the pending leave details of selected employee.
   * @param pendingLeaveId the id of the employee.
   * @param denied the id of the employee.
   * @return the employee object.
   */
  @SqlUpdate("UPDATE LEAVE_DETAILS SET LEAVE_STATUS= :denied WHERE LEAVE_ID= :pendingLeaveId ")
  @Mapper(LeaveDetailsMapper.class)
  int updateDenied(@Bind("pendingLeaveId") int pendingLeaveId, @Bind("denied") String denied);
  /**
   * return all the pending leave details of selected employee.
   * @param comments the approved staus
   * @param pendingLeaveId the id of the employee.
   */
  @SqlUpdate("UPDATE LEAVE_DETAILS SET MANAGER_COMENTS= :comments WHERE LEAVE_ID= :pendingLeaveId ")
  @Mapper(LeaveDetailsMapper.class)
  void daoManagerComments(@Bind("comments") String comments, @Bind("pendingLeaveId") int pendingLeaveId);
  /**
   * return all the pending leave details of selected employee.
   * @param empId the manager id.
   * @return the employee object.
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE (EMP_ID) IN"
      + "(SELECT EMP_ID FROM EMPLOYEE WHERE MANAGER_ID=:empId) AND LEAVE_STATUS='PENDING' ORDER BY EMP_ID, START_DATE")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> daoLeavePendingUnderManager(@Bind("empId")int empId);
   /**
   * return all the pending leave details of selected employee.
   * @param empId the manager id.
   * @return the employee object.
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE (EMP_ID) IN"
      + "(SELECT EMP_ID FROM EMPLOYEE WHERE (MANAGER_ID=:empId AND START_DATE >= CURDATE())"
      + "AND (LEAVE_STATUS='APPROVED' OR LEAVE_STATUS='DENIED'))"
      + " ORDER BY EMP_ID, START_DATE")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> daoLeavePendingUnderManagerRevisit(@Bind("empId")int empId);
      /**
   * return all the pending leave details of selected employee.
   * @param empId the manager id.
   * @return the employee object.
   */
  @SqlQuery("SELECT COUNT(*) FROM LEAVE_DETAILS WHERE (EMP_ID) IN"
      + "(SELECT EMP_ID FROM EMPLOYEE WHERE MANAGER_ID=:empId) AND LEAVE_STATUS='PENDING' ORDER BY EMP_ID, START_DATE")
  int daoLeavePendingUnderManagerLeaveCount(@Bind("empId")int empId);
    /**
   * return all the pending leave details of selected employee.
   * @param empId the manager id.
   * @return the employee object.
   */
  @SqlQuery("SELECT SUM(NO_OF_DAYS) FROM LEAVE_DETAILS WHERE EMP_ID = :empId AND"
      + " LEAVE_STATUS = 'APPROVED'")
  int daoLeavePendingUnderManagerCount(@Bind("empId")int empId);
        /**
   * return all the pending leave details of selected employee.
   * @param empID the manager id.
   * @return the employee object. */
  @SqlQuery("SELECT * FROM EMPLOYEE WHERE EMP_ID = :empID")
  @Mapper(EmployeeMapper.class)
  Employee findNumber(@Bind("empID") int empID);
    /**
   * return all the pending leave details of selected employee.
   * @param empId the manager id.
   * @return the employee object.
   */
  @SqlQuery("SELECT COUNT(*) FROM LEAVE_DETAILS WHERE EMP_ID = :empId")
  int leaveCount(@Bind("empId")int empId);
  /**
   * close with no args is used to close the connection.
   */
  void close();
}
