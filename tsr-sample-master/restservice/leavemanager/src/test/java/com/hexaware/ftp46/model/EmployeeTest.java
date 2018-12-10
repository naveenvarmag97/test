package com.hexaware.ftp46.model;

import com.hexaware.ftp46.persistence.EmployeeDAO;
import static org.junit.Assert.assertNotNull;
//import static org.junit.Assume.assumeNoException;
import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;
//import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;

import java.util.ArrayList;


/**
 * Test class for Employee.
 */
@RunWith(JMockit.class)
public class EmployeeTest {

  /**
   * setup method.
   */
  @Before
  public void initInput() {

  }

  /**
   * setup method.
   * @param dao dao.
   */
  // @Test
  // public final void testEmployee() {
  //   Employee e100 = new Employee(100);
  //   Employee e101 = new Employee(101);
  //   assertNotEquals(e100, null);
  //   assertNotEquals(e100, new Integer(100));
  //   assertEquals(e100, new Employee(100));
  //   assertNotEquals(e101, new Employee(100));
  //   assertEquals(e100.hashCode(), new Employee(100).hashCode());
  //   assertEquals(e100.getEmpId(), new Employee(100).getEmpId());
  //   e101.setEmpId(100);
  //   assertEquals(e101, new Employee(100));
  // }

    /**
   * Tests the Empty constructor of the employee class.
   * @param dao dao.
   */
  @Test
  public final void testLeaveBalDec(@Mocked final EmployeeDAO dao) {
    String s = Employee.leaveBalDec(2000, 2);
    assertEquals("Leave balance decremented", s);

  }

  /**
   * setup method.
   * @param dao dao.
   */
  @Test
  public final void testIncrementLeaveBalance(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        dao.updateLeaveBal(2000, 2);
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    String s = Employee.incrementLeaveBalance(2000, 2);
    assertEquals("incremented leave balance", s);

  }
  /**
   * Tests the Parametrized constructor of the employee class.
   */
  public final void testEmployeeEmpty() {
    Employee e1 = new Employee();
    assertNotNull(e1);
  }
    /**
   * Tests the Parametrized constructor of the employee class.
   */
  @Test
  public final void testEmployeeParameterzed() {
    Employee e1 = new Employee(7000, "dinesh", "05-12-17", 7001, "dinesh@gmail.com", 5, 8777127L, "Development", "url");
    Employee e2 = new Employee(7000, "dinesh", "05-12-17", 7001, "dinesh@gmail.com", 5, 8777127L, "Development", "url");
    Employee e3 = e2;
    assertNotNull(e1);
    assertNotNull(e2);
    assertEquals(e1, e2);
    assertEquals(e3.getEmpDoj(), e2.getEmpDoj());
    assertEquals(e1.hashCode(), new Employee(7000, "dinesh", "05-12-17", 7001, "dinesh@gmail.com", 5, 8777127L,
        "Development", "url").hashCode());
  }
    /**
   * Tests the toString method of the employee class.
   */
  @Test
  public final void testEmployeetoString() {
    Employee e1 = new Employee(7000, "dinesh", "05-12-17", 7001, "dinesh@gmail.com", 5, 8777127L, "Development", "url");
    assertEquals("\n\n<<<<<<<EMPLOYEE DETAILS>>>>>>\n" + "EMP id \t" + 7000 + "\n" + "Employee Name \t"
          + "dinesh" + "\n" + "Mananger ID:\t"
          + 7001 + "\n" + "Number of leaves \t" + 5 + "\n"
          + "Employee phone number \t" + 8777127L + "\n"
          + "Employee email \t" + "dinesh@gmail.com" + "\n" + "Employee DOJ \t" + "05-12-17" + "\n"
          + "Employee Department \t" + "Development" + "\n" + "\n"
          + "Employee Profile URL \t" + "url" + "\n" + "<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>\n\n",
        e1.toString());
  }

  /**
   * Tests that a list with some employees is handled correctly.
   * param dao mocking the dao class
   */
  // @Test
  // public final void testListAllSome(@Mocked final EmployeeDAO dao) {
  //   new Expectations() {
  //     {
  //       ArrayList<Employee> es = new ArrayList<Employee>();
  //       es.add(new Employee(1));
  //       es.add(new Employee(10));
  //       es.add(new Employee(100));
  //       dao.list(); result = es;
  //     }
  //   };
  //   new MockUp<Employee>() {
  //     @Mock
  //     EmployeeDAO dao() {
  //       return dao;
  //     }
  //   };
  //   Employee[] es = Employee.listAll();
  //   assertEquals(3, es.length);
  //   assertEquals(new Employee(1), es[0]);
  //   assertEquals(new Employee(10), es[1]);
  //   assertEquals(new Employee(100), es[2]);
  // }

  /**
   * Tests that a list with some employees is handled correctly.
   * param dao mocking the dao class
   */
  // @Test
  // public final void testListAllSome(@Mocked final EmployeeDAO dao) {
  //   new Expectations() {
  //     {
  //       ArrayList<Employee> es = new ArrayList<Employee>();
  //       es.add(new Employee(1));
  //       es.add(new Employee(10));
  //       es.add(new Employee(100));
  //       dao.list(); result = es;
  //     }
  //   };
  //   new MockUp<Employee>() {
  //     @Mock
  //     EmployeeDAO dao() {
  //       return dao;
  //     }
  //   };
  //   Employee[] es = Employee.listAll();
  //   assertEquals(3, es.length);
  //   assertEquals(new Employee(1), es[0]);
  //   assertEquals(new Employee(10), es[1]);
  //   assertEquals(new Employee(100), es[2]);
  // }

  /**
   * Tests that a fetch of a specific employee works correctly.
  //  *  dao mocking the dao class
  //  */
  // @Test
  // public final void testListById(@Mocked final EmployeeDAO dao) {
  //   final Employee e100 = new Employee(100);
  //   new Expectations() {
  //     {
  //       dao.find(100); result = e100;
  //       dao.find(-1); result = null;
  //     }
  //   };
  //   new MockUp<Employee>() {
  //     @Mock
  //     EmployeeDAO dao() {
  //       return dao;
  //     }
  //   };
  //   Employee e = Employee.listById(100);
  //   assertEquals(e100, e);

  //   e = Employee.listById(-1);
  //   assertNull(e);
  // }

  /**
   * Tests that a fetch of a specific employee works correctly.
   */
  @Test
  public final void testEmpId() {
    Employee id = new Employee();
    id.setEmpId(2000);
    assertEquals(2000, id.getEmpId());
  }

  /**
   * Tests that a fetch of a specific employee works correctly.
   *  mocking the dao class
   */
  @Test
  public final void testEmpName() {
    Employee name = new Employee();
    name.setEmpName("Soumyashree Dwibedy");
    assertEquals("Soumyashree Dwibedy", name.getEmpName());
  }
  /**
   * Tests that a fetch of a specific employee works correctly.
   * mocking the dao class
   */
  @Test
  public final void testEmpDoj() {
    Employee doj = new Employee();
    doj.setEmpDoj("2000-09-28");
    assertEquals("2000-09-28", doj.getEmpDoj());
  }
  /**
   * Tests that a fetch of a specific employee works correctly.
   * mocking the dao class
   */
  @Test
  public final void testManagerId() {
    Employee manId = new Employee();
    manId.setManagerId(1000);
    assertEquals(1000, manId.getManagerId());
  }
  /**
   * Tests that a fetch of a specific employee works correctly.
   * mocking the dao class
   */
  @Test
  public final void testEmpEmail() {
    Employee email = new Employee();
    email.setEmpEmail("123sania@gmail.com");
    assertEquals("123sania@gmail.com", email.getEmpEmail());
  }
  /**
   * Tests that a fetch of a specific employee works correctly.
   * mocking the dao class
   */
  @Test
  public final void testEmpLeaveBalance() {
    Employee leavebalance = new Employee();
    leavebalance.setEmpLeaveBalance(42);
    assertEquals(42, leavebalance.getEmpLeaveBalance());
  }
  /**
   * Tests that a fetch of a specific employee works correctly.
   * mocking the dao class
   */
  @Test
  public final void testEmpPhone() {
    Employee phone1 = new Employee();
    Employee phone2 = new Employee();
    phone1.setEmpPhone(9845677663L);
    phone2.setEmpPhone(9845677663L);
    assertEquals(phone2.getEmpPhone(), phone1.getEmpPhone());
  }
  /**
   * Tests that a fetch of a specific employee works correctly.
   * mocking the dao class
   */
  @Test
  public final void testEmpDepartment() {
    Employee department = new Employee();
    department.setEmpDepartment("java");
    assertEquals("java", department.getEmpDepartment());
  }
  /**
   * Tests the leavepending methods of the LeaveDeatils class.
   *@param dao dao
   */
  @Test
  public final void testlistAll(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        ArrayList<Employee> es = new ArrayList<Employee>();
        es.add(new Employee(7000, "dinesh", "05-12-17", 7001, "dinesh@gmail.com", 5, 87771297L,
            "Development", "url"));
        es.add(new Employee(7000, "dinesh", "05-11-17", 7001, "dinesh@gmail.com", 5, 87771297L,
            "Development", "url"));
        es.add(new Employee(7000, "dinesh", "05-2-17", 7001, "dinesh@gmail.com", 5, 87771297L,
            "Development", "url"));
        dao.list(); result = es;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] employeee = Employee.listAll();
    assertEquals(3, employeee.length);
    assertEquals(new Employee(7000, "dinesh", "05-12-17", 7001, "dinesh@gmail.com", 5, 87771297L,
        "Development", "url"), employeee[0]);
    assertEquals(new Employee(7000, "dinesh", "05-11-17", 7001, "dinesh@gmail.com", 5, 87771297L,
        "Development", "url"), employeee[1]);
    assertEquals(new Employee(7000, "dinesh", "05-2-17", 7001, "dinesh@gmail.com", 5, 87771297L,
        "Development", "url"), employeee[2]);
  }
//    * param dao mocking the dao class
//    */
//   @Test
//   public final void testListById(@Mocked final EmployeeDAO dao) {
//     final Employee e100 = new Employee(100);
//     new Expectations() {
//       {
//         dao.find(100); result = e100;
//         dao.find(-1); result = null;
//       }
//     };
//     new MockUp<Employee>() {
//       @Mock
//       EmployeeDAO dao() {
//         return dao;
//       }
//     };
//     Employee e = Employee.listById(100);
//     assertEquals(e100, e);

//     e = Employee.listById(-1);
//     assertNull(e);
//   }
// }
  /**
   * Tests the toString method of the employee class.
   * @param dao mocking dao class.
   */
  @Test
  public final void testListEmployeeUnderManager(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        Employee employ = new Employee(7000, "dinesh", "05-12-17", 2000, "dinesh@gmail.com",
            5, 87771297L, "Development", "url");
        dao.findIfManager1(2000);
        result = employ;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] employ1 = Employee.listEmployeeUnderManager(2000);
    assertEquals(1, employ1.length);
    assertEquals(new Employee(7000, "dinesh", "05-12-17", 2000, "dinesh@gmail.com",
        5, 87771297L, "Development", "url"), employ1[0]);

  }
    /**
   * test.
   */
  @Test
  public final void testCount() {
    int n = Employee.noOfEmployees(6000);
    assertEquals(n, 0);
  }
}




