

export class Employee {
    empId: number;
    empName: String;
    empEmail: String;
    empPhone: number;
    managerId: number;
    empDepartment: String;
    empLeaveBalance: number;
    empDoj: String;
    empProfileUrl:string;
    constructor(empId: number, empName:String, empEmail: String, empPhone: number, managerId: number, empDepartment : String, 
    empLeaveBalance: number, empDoj: String, empProfileUrl:string ) {
      this.empId = empId;
      this.empName = empName;
      this.empEmail = empEmail;
      this.empPhone = empPhone;
      this.managerId = managerId;
      this.empDepartment = empDepartment;
      this.empLeaveBalance = empLeaveBalance;
      this.empDoj = empDoj;
      this.empProfileUrl = empProfileUrl;
    }
  
}
