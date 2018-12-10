export class LeaveDetails {
    empId: number;
    leaveId:number;
    startDate: String;
    endDate: String;
    appliedOn: String;
    noOfDays: number;
    leaveType: String;
    reason: String;
    leaveStatus: String;
    managerComments:String;
    constructor(empId: number, leaveId:number, startDate: String, endDate: String, appliedOn: String,noOfDays: number, 
        leaveType: String, reason: String,leaveStatus: String, managerComments:String) {
      this.empId = empId;
      this.leaveId = leaveId;
      this.startDate = startDate;
      this.endDate = endDate;
      this.appliedOn = appliedOn;
      this.noOfDays = noOfDays;
      this.leaveType = leaveType;
      this.reason = reason;
      this.leaveStatus=leaveStatus;
      this.managerComments=managerComments;
    }
   
}
