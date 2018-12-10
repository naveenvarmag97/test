package com.hexaware.ftp46.model;

import com.hexaware.ftp46.persistence.LeaveDetailsDAO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;

import java.util.ArrayList;

// import com.hexaware.ftp46.model.LeaveStatus;
// import com.hexaware.ftp46.model.LeaveType;
/**
*
*/
@RunWith(JMockit.class)

public class LeaveDetailsTest {

  /**
   * setup method.
   */
  @Before
  public void initInput() {

  }

  /**
   * setup method.
   * @throws ParseException pe.
   */
  @Test
  public final void testNoOfDays() throws ParseException {
    SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
    String start = "2018-10-22";
    String end = "2018-10-24";
    final Date startDate = s.parse(start);
    final Date endDate = s.parse(end);
    int noOfDays = LeaveDetails.noOfDaysInLeave(startDate, endDate);
    assertEquals(3, LeaveDetails.noOfDaysInLeave(startDate, endDate));
    assertNotEquals(0, noOfDays);
  }

  /**
   * setup method.
   * @throws ParseException pe.
   */
  @Test // (expected = ParseException.class)
  public final void testLeaveDate() throws ParseException {
    final String date = "2018-10-22";
    SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
    final Date parsedDate = s.parse(date);
    // Date checkDate = LeaveDetails.leaveDate(date);
    assertEquals(parsedDate, LeaveDetails.leaveDate(date));
  }

  /**
   * setup method.
   * @param dao dao.
   */
  @Test
  public final void testLatestLeaveApplied(@Mocked final LeaveDetailsDAO dao) {
    String start = "2018-12-11";
    String end = "2018-12-12";
    String applied = "2018-06-14";
    final LeaveStatus leaveStatus1 = LeaveStatus.PENDING;
    final LeaveType leaveType1 = LeaveType.EL;
    final LeaveDetails ld = new LeaveDetails(6, 2000, start, end, applied, 1, leaveType1, "", "no", leaveStatus1);
    new Expectations() {
      {
        dao.findLatest(2000);
        result = ld;
        dao.findLatest(5000);
        result = null;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails ld1 = LeaveDetails.latestLeaveApplied(2000);
    assertEquals(ld, ld1);
    LeaveDetails ld2 = LeaveDetails.latestLeaveApplied(5000);
    assertNull(ld2);
  }

  /**
   * Tests the Parametrized constructor of the employee class.
   */
  @Test
  public final void testLeaveDetailsEmpty() {
    final LeaveType lt = LeaveType.EL;
    final LeaveStatus ls = LeaveStatus.PENDING;
    LeaveDetails l1 = new LeaveDetails();
    assertNotNull(l1);
  }

  /**
   * Tests the constructor(parameterized) methods of the LeaveDeatils class.
   */
  @Test
  public final void testLeaveDetails() {
    final LeaveType lt = LeaveType.EL;
    final LeaveStatus ls = LeaveStatus.PENDING;
    LeaveDetails l1 = new LeaveDetails(13, 7000, "22-04-2018", "24-04-2018", "21-03-2018", 12, lt, "sick", "enjoy", ls);
    LeaveDetails l2 = new LeaveDetails(13, 7000, "22-04-2018", "24-04-2018", "21-03-2018", 12, lt, "sick", "enjoy", ls);
    assertNotNull(l1);
    assertNotNull(l2);
    assertEquals(l1.hashCode(),
        new LeaveDetails(13, 7000, "22-04-2018", "24-04-2018", "21-03-2018", 12, lt, "sick", "enjoy", ls).hashCode());
    assertEquals(l1, l2);
  }

  /**
   * Tests the constructor(parameterized) methods of the LeaveDeatils class.
   */
  @Test
  public final void testtoString() {
    final LeaveType lt = LeaveType.EL;
    final LeaveStatus ls = LeaveStatus.PENDING;
    LeaveDetails l1 = new LeaveDetails(13, 7000, "22-04-2018", "24-04-2018", "21-03-2018", 12, lt, "sick", "enjoy", ls);
    assertEquals("\n<<<<<<<<LEAVE DETAILS>>>>>>>>>\n" + "Leave Id \t" + "<<<  " + 13 + "  >>>" + "\n" + "Employee Id \t"
        + 7000 + "\n" + "Start Date\t" + "22-04-2018" + "\n" + "End Date\t" + "24-04-2018" + "\n" + "Applied On \t"
        + "21-03-2018" + "\n" + "No of Days \t" + 12 + "\n" + "Leave type \t" + lt + "\n" + "reason \t\t" + "sick"
        + "\n" + "Manager Comments " + "enjoy" + "\n" + "Leave status \t" + ls + "\n"
        + "<<<<<<<<<<<<<<<>>>>>>>>>>>>>\n", l1.toString());
  }

  /**
   * Tests the leaveHistory methods of the LeaveDeatils class.
   * @param dao dao.
   */
  @Test
  public final void testlistLeaveHistory(@Mocked final LeaveDetailsDAO dao) {
    new Expectations() {
      {
        ArrayList<LeaveDetails> es = new ArrayList<LeaveDetails>();
        final LeaveType lt = LeaveType.EL;
        final LeaveStatus ls = LeaveStatus.PENDING;
        es.add(new LeaveDetails(13, 7000, "22-04-2018", "24-04-2018", "21-03-2018", 12, lt, "sick", "enjoy", ls));
        es.add(new LeaveDetails(14, 7000, "21-01-2018", "24-04-2018", "21-03-2018", 12, lt, "sick", "enjoy", ls));
        es.add(new LeaveDetails(15, 7000, "22-02-2018", "24-04-2018", "21-03-2018", 12, lt, "sick", "enjoy", ls));
        dao.history(7000);
        result = es;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] leaveDetails = LeaveDetails.leaveHistory(7000);
    assertEquals(3, leaveDetails.length);
    final LeaveType lt = LeaveType.EL;
    final LeaveStatus ls = LeaveStatus.PENDING;
    assertEquals(new LeaveDetails(13, 7000, "22-04-2018", "24-04-2018", "21-03-2018", 12, lt, "sick", "enjoy", ls),
        leaveDetails[0]);
    assertEquals(new LeaveDetails(14, 7000, "21-01-2018", "24-04-2018", "21-03-2018", 12, lt, "sick", "enjoy", ls),
        leaveDetails[1]);
    assertEquals(new LeaveDetails(15, 7000, "22-02-2018", "24-04-2018", "21-03-2018", 12, lt, "sick", "enjoy", ls),
        leaveDetails[2]);
  }

  //  /**
  //  * @throws Exception hiuhi8j.
  //  */
  // @Test
  // public final void testreduceApply() throws Exception {
  //   String startDate = "2018-07-27";
  //   String endDate = "2018-07-28";
  //   int empId = 2000;
  //   Date date1 = LeaveDetails.leaveDate(startDate);
  //   Date date2 = LeaveDetails.leaveDate(endDate);
  //   assertEquals("ok",
  //       LeaveDetails.reduceApply(date1, date2, empId));
  // }
/**
   * setup method.
   * @param dao dao.n
   */
  @Test
  public final void testApplyLeave(@Mocked final LeaveDetailsDAO dao) {
    SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
    String start = "2018-10-22";
    String end = "2018-10-23";
    Date endDate = null;
    Date startDate = null;
    try {
      startDate = s.parse(start);
    } catch (ParseException e) {
      System.out.println(e);
    }
    try {
      endDate = s.parse(end);
    } catch (ParseException e) {
      System.out.println(e);
    }
    final Date sd = startDate;
    final Date e = endDate;
    // final LeaveDetails ld = new
    // LeaveDetails(1,2000,start,end,applied,2,leaveType1,"SICK"," ",leaveStatus1);
    new Expectations() {
      {
        dao.apply(sd, e, 2, "EL", "SICK", "PENDING", 2000, " ");
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    String leave = LeaveDetails.applyLeave(sd, e, "SICK", 2000, 1);
    assertEquals("Leave applied successfully", leave);
  }
    /**
   * setup method.
   * @param dao dao.n
   */
  @Test
  public final void testEditApplyLeave(@Mocked final LeaveDetailsDAO dao) {
    SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
    String start = "2018-10-22";
    String end = "2018-10-23";
    Date endDate = null;
    Date startDate = null;
    try {
      startDate = s.parse(start);
    } catch (ParseException e) {
      System.out.println(e);
    }
    try {
      endDate = s.parse(end);
    } catch (ParseException e) {
      System.out.println(e);
    }
    final Date sd = startDate;
    final Date e = endDate;
    // final LeaveDetails ld = new
    // LeaveDetails(1,2000,start,end,applied,2,leaveType1,"SICK"," ",leaveStatus1);
    new Expectations() {
      {
        dao.editApply(sd, e, 2, "EL", "SICK", "PENDING", 2000, " ", 11);
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    String leave = LeaveDetails.editapplyLeave(sd, e, "SICK", 2000, 11);
    assertEquals("Leave updated successfully", leave);
  }


  /**
   * @param dao dao.
   */
  @Test
  public final void testlistLeavePending(@Mocked final LeaveDetailsDAO dao) {

    new Expectations() {
      {
        ArrayList<LeaveDetails> es = new ArrayList<LeaveDetails>();
        final LeaveType lt = LeaveType.EL;
        final LeaveStatus ls = LeaveStatus.PENDING;
        es.add(new LeaveDetails(13, 7000, "22-04-2018", "24-04-2018", "21-03-2018", 12, lt, "sick", "enjoy", ls));
        es.add(new LeaveDetails(14, 7000, "21-01-2018", "24-04-2018", "21-03-2018", 12, lt, "sick", "enjoy", ls));
        es.add(new LeaveDetails(15, 7000, "22-02-2018", "24-04-2018", "21-03-2018", 12, lt, "sick", "enjoy", ls));
        dao.pending(7000);
        result = es;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] leaveDetails = LeaveDetails.leavePending(7000);
    assertEquals(3, leaveDetails.length);
    final LeaveType lt = LeaveType.EL;
    final LeaveStatus ls = LeaveStatus.PENDING;
    assertEquals(new LeaveDetails(13, 7000, "22-04-2018", "24-04-2018", "21-03-2018", 12, lt, "sick", "enjoy", ls),
        leaveDetails[0]);
    assertEquals(new LeaveDetails(14, 7000, "21-01-2018", "24-04-2018", "21-03-2018", 12, lt, "sick", "enjoy", ls),
        leaveDetails[1]);
    assertEquals(new LeaveDetails(15, 7000, "22-02-2018", "24-04-2018", "21-03-2018", 12, lt, "sick", "enjoy", ls),
        leaveDetails[2]);
  }

  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  //@Test // 1
  //public final void testApprove() {
    // int leaveId = 4;int choice = 1; String comments = "hhhh";
    //LeaveDetails testAprrove = new LeaveDetails();
    //assertEquals("Approved", testAprrove.approve(4, 1, "hhhh"));
  //}
  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  //@Test // 1
  //public final void testApproveRevisit() {
    // int leaveId = 4;int choice = 1; String comments = "hhhh";
    //LeaveDetails testAprrove = new LeaveDetails();
    //assertEquals("Revisit Approved", testAprrove.approveRevisit(4, 1, "hhhh"));
  //}
    /**
   * Tests the equals/hashcode methods of the employee class.
   */
  //@Test // 1
  //public final void testApproveDenyRevisit() {
    // int leaveId = 4;int choice = 1; String comments = "hhhh";
    //LeaveDetails testAprrove = new LeaveDetails();
    //assertEquals("Revisit Denied", testAprrove.approveRevisit(4, 2, "hhhh"));
  //}

  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  //@Test // 1
  //public final void testApproveDeny() {
    // int leaveId = 4;int choice = 1; String comments = "hhhh";
    //LeaveDetails testAprrove = new LeaveDetails();
    //assertEquals("Denied", testAprrove.approve(4, 2, "hhhh"));
  //}
  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test // 1
  public final void testApproveLeaveIdRevisit() {
    // int leaveId = 4;int choice = 1; String comments = "hhhh";
    LeaveDetails testAprrove = new LeaveDetails();
    assertEquals("Incorrect leaveId", testAprrove.approveRevisit(4, 3, "hhhh"));
  }
  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test // 1
  public final void testApproveLeaveId() {
    // int leaveId = 4;int choice = 1; String comments = "hhhh";
    LeaveDetails testAprrove = new LeaveDetails();
    assertEquals("Incorrect leaveId", testAprrove.approve(4, 3, "hhhh"));
  }

  /*
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class.
   */
  // @Test
  // /**
  // * Tests the equals/hashcode methods of the employee class.
  // */
  // public final void testDeneid(@Mocked final LeaveDetailsDAO dao) {
  // LeaveStatus leaveStat = LeaveStatus.DENIED;
  // LeaveType leaveType = LeaveType.EL;
  // final String denied = "DENIED";
  // //final LeaveDetails leaveDetails = new
  // //LeaveDetails(4,2000,"2018-07-16","2018-07-18","2018-06-20",10,leaveType,"SICK","kkkk",leaveStat);
  // //LeaveDetails leaveDetails = new LeaveDetails();
  // //Stringss=leaveDetails.denied(4);
  // /*
  // *new Expectations() { { dao.updateDenied(4,denied); // result = 0; }
  // * }; // new Expectations() { // }; /* new MockUp<LeaveDetails>() {
  // *
  // *@Mock LeaveDetailsDAO dao() {return dao;}};
  // */
  // // String s;
  // // LeaveDetails s1= new LeaveDetails();
  // String s = LeaveDetails.denied(4);
  // System.out.println(s);
  // assertEquals("Leave", s);
  // }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class.
   */
  @Test // working 1
  public final void testFoundEmpID(@Mocked final LeaveDetailsDAO dao) {
    LeaveStatus leaveStat = LeaveStatus.PENDING;
    LeaveType leaveType = LeaveType.EL;
    final LeaveDetails testDeny1 = new LeaveDetails(4, 2000, "2018-07-16", "2018-07-18", "2018-06-20", 10, leaveType,
        "jjj", "kkkk", leaveStat);
    new Expectations() {
      {
        dao.employeeId(4);
        result = testDeny1;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails e = LeaveDetails.foundEmpId(4);
    assertEquals(testDeny1, e);
    // assertEquals(expected, actual);
  }

  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class.
   */
  // @Test // WORKING 2
  // public final void testApproved(@Mocked final LeaveDetailsDAO dao) {
  //   LeaveDetails e1 = new LeaveDetails();
  //   new Expectations() {
  //     {
  //       dao.updateApproved("APPROVED", 4);
  //       // result = 0;
  //     }
  //   };
  //   new MockUp<LeaveDetails>() {
  //     @Mock
  //     LeaveDetailsDAO dao() {
  //       return dao;
  //     }
  //   };

  //   String s = e1.approved(4);
  //   assertEquals("Leave Approved", s);
  // }

  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class.
   */
  @Test // working 3
  public final void testManagerComments(@Mocked final LeaveDetailsDAO dao) {
    LeaveDetails e2 = new LeaveDetails();
    new Expectations() {
      {
        dao.daoManagerComments("updated", 4);
        // result = 0;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };

    String s = e2.managerComments("updated", 4);
    assertEquals("Manager comments Updated", s);
  }

  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class.
   */
  // @Test // 4
  // public final void testApprove(@Mocked final LeaveDetails dao) {
  // LeaveDetails e2= new LeaveDetails();
  // }
  /**
   * tests that empty employee list is handled correctly. mocking the dao class
   */
  @Test
  public final void testEmpId() {
    LeaveDetails id = new LeaveDetails();
    id.setLeaveEmpId(2001);
    assertEquals(2001, id.getLeaveEmpId());
  }

  /**
   * tests that empty employee list is handled correctly. mocking the dao class
   */
  @Test
  public final void testleaveId() {
    LeaveDetails leaveid = new LeaveDetails();
    leaveid.setLeaveId(18);
    assertEquals(18, leaveid.getLeaveId());
  }

  /**
   * tests that empty employee list is handled correctly. mocking the dao class.
   */
  @Test
  public final void testStartDate() {
    LeaveDetails startdate = new LeaveDetails();
    startdate.setStartDate("2018-09-14");
    assertEquals("2018-09-14", startdate.getStartDate());
  }

  /**
   * tests that empty employee list is handled correctly. mocking the dao class.
   */
  @Test
  public final void testEndDate() {
    LeaveDetails enddate = new LeaveDetails();
    enddate.setEnddate("2018-09-16");
    assertEquals("2018-09-16", enddate.getEndDate());
  }

  /**
   * tests that empty employee list is handled correctly. mocking the dao class.
   */
  @Test
  public final void testAppliedOn() {
    LeaveDetails appliedon = new LeaveDetails();
    appliedon.setAppliedOn("2018-06-20");
    assertEquals("2018-06-20", appliedon.getAppliedOn());
  }

  /**
   * tests that empty employee list is handled correctly. mocking the dao class
   */
  @Test
  public final void testNoOfDaysInClass() {
    LeaveDetails days = new LeaveDetails();
    days.setNoOfDays(8);
    assertEquals(8, days.getNoOfDays());
  }

  /**
   * tests that empty employee list is handled correctly. mocking the dao class
   */
  @Test
  public final void testleavetype() {
    LeaveDetails type = new LeaveDetails();
    type.setLeaveType(LeaveType.EL);
    assertEquals(LeaveType.EL, type.getLeaveType());
  }

  /**
   * tests that empty employee list is handled correctly. mocking the dao class
   */
  @Test
  public final void testleavestatus() {
    LeaveDetails status = new LeaveDetails();
    status.setLeaveStatus(LeaveStatus.PENDING);
    assertEquals(LeaveStatus.PENDING, status.getLeaveStatus());
  }

  /**
   * tests that empty employee list is handled correctly. mocking the dao class
   */
  @Test
  public final void testReason() {
    LeaveDetails reason = new LeaveDetails();
    reason.setReason("sick");
    assertEquals("sick", reason.getReason());
  }

  /**
   * tests that empty employee list is handled correctly. mocking the dao class
   */
  @Test
  public final void testManagerComments() {
    LeaveDetails comments = new LeaveDetails();
    comments.setManagerComments("leave granted");
    assertEquals("leave granted", comments.getManagerComments());
  }

  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class.
   */
  @Test // 4
  public final void testLeavePendingUnderManager(@Mocked final LeaveDetailsDAO dao) {
    final LeaveType leaveType = LeaveType.EL;
    final LeaveStatus leaveStatus = LeaveStatus.PENDING;
    new Expectations() {
      {
        ArrayList<LeaveDetails> es = new ArrayList<LeaveDetails>();
        es.add(new LeaveDetails(13, 7000, "22-04-2018", "24-04-2018", "21-03-2018", 12, leaveType, "sick", "enjoy",
            leaveStatus));
        es.add(new LeaveDetails(14, 7000, "21-01-2018", "24-04-2018", "21-03-2018", 12, leaveType, "sick", "enjoy",
            leaveStatus));
        dao.daoLeavePendingUnderManager(7000);
        result = es;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] leaveDetail = LeaveDetails.leavePendingUnderManager(7000);
    assertEquals(2, leaveDetail.length);
    assertEquals(new LeaveDetails(13, 7000, "22-04-2018", "24-04-2018", "21-03-2018", 12, leaveType, "sick", "enjoy",
        leaveStatus), leaveDetail[0]);
    assertEquals(new LeaveDetails(14, 7000, "21-01-2018", "24-04-2018", "21-03-2018", 12, leaveType, "sick", "enjoy",
        leaveStatus), leaveDetail[1]);
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class.
   */
  @Test // 4
  public final void testLeavePendingUnderManagerRevisit(@Mocked final LeaveDetailsDAO dao) {
    final LeaveType leaveType = LeaveType.EL;
    final LeaveStatus leaveStatus = LeaveStatus.PENDING;
    new Expectations() {
      {
        ArrayList<LeaveDetails> es = new ArrayList<LeaveDetails>();
        es.add(new LeaveDetails(13, 7000, "20-07-2018", "24-07-2018", "18-07-2018", 12, leaveType, "sick", "enjoy",
            leaveStatus));
        es.add(new LeaveDetails(14, 7000, "21-07-2018", "24-07-2018", "18-07-2018", 12, leaveType, "sick", "enjoy",
            leaveStatus));
        dao.daoLeavePendingUnderManagerRevisit(7000);
        result = es;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] leaveDetail = LeaveDetails.leavePendingUnderManagerRevisit(7000);
    assertEquals(2, leaveDetail.length);
    assertEquals(new LeaveDetails(13, 7000, "20-07-2018", "24-07-2018", "18-07-2018", 12, leaveType, "sick", "enjoy",
        leaveStatus), leaveDetail[0]);
    assertEquals(new LeaveDetails(14, 7000, "21-07-2018", "24-07-2018", "18-07-2018", 12, leaveType, "sick", "enjoy",
        leaveStatus), leaveDetail[1]);
  }
      /**
   * test.
   */
  @Test
  public final void testCount() {
    int n = LeaveDetails.leaveCount(6000);
    assertEquals(n, 0);
  }
    /**
   * test.
   */
  @Test
  public final void testCount1() {
    int n = LeaveDetails.leaveDays(6000);
    assertEquals(n, 0);
  }
      /**
   * test.
   */
  @Test
  public final void testCount2() {
    int n = LeaveDetails.managerPendingCount(6000);
    assertEquals(n, 0);
  }
}
