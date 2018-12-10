package com.hexaware.ftp46.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.Date;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

import com.hexaware.ftp46.model.LeaveDetails;
import com.hexaware.ftp46.model.LeaveStatus;
import com.hexaware.ftp46.model.LeaveType;

/**
 * Mapper class to map from result set to employee object.
 */
public class LeaveDetailsMapper implements ResultSetMapper<LeaveDetails> {
  /**
   * @param idx the index
   * @param rs  the resultset
   * @param ctx the context
   * @return the mapped employee object
   * @throws SQLException in case there is an error in fetching data from the
   *                      resultset
   */
  public final LeaveDetails map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
    /**
     * @return Employee
     */
    return new LeaveDetails(rs.getInt("LEAVE_ID"), rs.getInt("EMP_ID"), rs.getString("START_DATE"),
    rs.getString("END_DATE"), rs.getString("APPLIED_ON"), rs.getInt("NO_OF_DAYS"),
    LeaveType.valueOf(rs.getString("LEAVE_TYPE")), rs.getString("REASON"), rs.getString("MANAGER_COMENTS"),
    LeaveStatus.valueOf(rs.getString("LEAVE_STATUS")));
  }
}
