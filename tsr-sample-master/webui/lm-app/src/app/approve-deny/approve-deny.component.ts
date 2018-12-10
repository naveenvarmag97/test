import { Component, OnInit, Input } from '@angular/core';
import { EmployeeService } from '../employee/employee.service';
import { Employee } from '../employee/employee';
import { Router, RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {LeaveDetails} from '../leaveDetails'
import {LeavedetailsService} from '../leavedetails.service'
import {ActivatedRoute} from '@angular/router';
import * as $ from 'jquery';
@Component({
  selector: 'app-approve-deny',
  templateUrl: './approve-deny.component.html',
  styleUrls: ['./approve-deny.component.css'],
  providers:[LeavedetailsService]
})
export class ApproveDenyComponent implements OnInit {

  empIdEmail: number;
  noofDays: number;
  type: String;
  reason: String;
  endDate: String;
  startDate: String;
  constructor(private employeeService: EmployeeService, private router: Router, private leaveDetailsService :LeavedetailsService,private route :ActivatedRoute) {
    this.leaveDetailsLeaveId=this.route.snapshot.params['leaveId'];
    console.log("xnfksd",this.leaveId)
    this.empId=this.route.snapshot.params['empId'];
    
  }
 
 title = 'Leave Management Application';
 employees: Employee[];
 leaveUndermanager: LeaveDetails[];
 leaveDetailsByLeaveId: LeaveDetails;
 leaveObj:LeaveDetails;
leaveId:number; 
 name : String;
 name1 : String[];
 empId: number;
 choice:number;
 nameUndermanager : String;
 leaveIdUndermanager : number;
message:String;
managerComments:String;
leaveDetailsLeaveId:number;
leaveIdApprove:number;
leaveEmpId:number;//add emp name in approve section
leaveId1:number;
leaveEmpName:Employee;
leaveEmpId1:number;
empName:String;
empEmail:String;

 getEmployees(): void {
  this.employeeService.getEmployees().then(employees => {
    console.log('getEmployees promise resolved loopingggggggggggggggggg : ' + employees.length);
    this.employees = employees;
    //this.leaveId = this.leave[0].leaveId;
    console.log(employees);
    
  }
);
}
// nameEmp() : String{
//   return this.name = this.employees[2].empName;

// }
  ngOnInit(): void {
    this.getEmployees();
    this.getLeaveDetailsByLeaveId(this.leaveDetailsLeaveId);
  }
  getleave():void{
    console.log(this.empId);
    this.leaveDetailsService.getLeaveDetails(this.empId).then(leaveUndermanager => {
      console.log('getleaveDetails promise resolved : ' + leaveUndermanager.length);
      this.leaveUndermanager = leaveUndermanager;
      
      console.log(this.leaveUndermanager);
     
    }
 
  );
  }

//  nameLeave() : number {
//    this.leaveIdUndermanager=this.leaveUndermanager[0].leaveId;
//    console.log(this.leaveIdUndermanager[0].leaveId);
//  return this.leaveUndermanager[0].leaveId;

//  }
 sendValues():void{
   this.getleave();
   this.getLeaveDetailsByLeaveId(this.leaveDetailsLeaveId);
 }
approveDeny():void{
  this.leaveId = this.leaveIdApprove;
  console.log(this.leaveIdApprove);
  console.log("mailllllllllllllllllllllll", this.findEmpEmail(this.empIdEmail));
  this.choice = 1;
  this.leaveDetailsService.approveDeny(this.leaveIdApprove,this.choice,this.managerComments)
  .subscribe(data1 => {this.message = data1;
  alert(data1);
  console.log("asasas",this.leaveDetailsByLeaveId.empId);
  //console.log("mailllllllllllllllllllllll", this.findEmpEmail(this.leaveDetailsByLeaveId.empId));
    var data = {
  
  service_id: 'gmail',
  
  template_id: 'template_rs4rNMb0',
  
  user_id: 'user_7AZFvXjhn5Y5XybIV0xuZ',
  
  template_params: {
  
  'username': this.findEmpName(this.empIdEmail),
  'mEmailId' :this.findEmpEmail(this.empIdEmail),
  'leaveId' :this.leaveIdApprove,
  'message_html': "Your leave with leave ID :->" +this.leaveIdApprove +  " has been approved",
  
  }
  
  };
  
   
  
  $.ajax('https://api.emailjs.com/api/v1.0/email/send', {
  
  type: 'POST',
  
  data: JSON.stringify(data),
  
  contentType: 'application/json'
  
  }).done(function() {
  
  alert('Your mail is sent!');
  
  }).fail(function(error) {
  
  alert('Oops... ' + JSON.stringify(error));
  
  });
  this.router.navigate(['/pendinglog',this.empId]);
},
 err => {console.log(err)});
 //this.router.navigate[('/approve')];
}
deny():void{
  this.choice = 2;
  this.leaveDetailsService.approveDeny(this.leaveIdApprove,this.choice,this.managerComments)
  .subscribe(data1 => {this.message = data1;
  alert(data1);
  var data = {
  
    service_id: 'gmail',
    
    template_id: 'template_rs4rNMb0',
    
    user_id: 'user_7AZFvXjhn5Y5XybIV0xuZ',
    
    template_params: {
    
    'username': this.findEmpName(this.empIdEmail),
    'emailId' :this.findEmpEmail(this.empIdEmail),
    'leaveId' :this.leaveIdApprove,
    'message_html': "Your leave with leave ID :->" +this.leaveIdApprove +  " has been Denied",
    
    }
    
    };
    
     
    
    $.ajax('https://api.emailjs.com/api/v1.0/email/send', {
    
    type: 'POST',
    
    data: JSON.stringify(data),
    
    contentType: 'application/json'
    
    }).done(function() {
    
    alert('Your mail is sent!');
    
    }).fail(function(error) {
    
    alert('Oops... ' + JSON.stringify(error));
    
    });
    this.router.navigate(['/pendinglog',this.empId]);},
 err => {console.log(err)});
}
// action(i:number):void { //after login

//   this.leaveDetailsLeaveId=this.leaveUndermanager[i].leaveId;
//   //this.leaveEmpId=this.leaveUndermanager[i].leaveEmpId;
//   //Storing leaveId for aprroval
//   console.log("leave Id",this.leaveDetailsLeaveId,this.leaveEmpId);
//   this.getLeaveDetailsByLeaveId(this.leaveDetailsLeaveId);
//   }
getLeaveDetailsByLeaveId(leaveDetailsLeaveId:number):void {
    this.leaveDetailsService.getLeaveDetailsByLeaveId(this.leaveDetailsLeaveId).then(leaveDetailsByLeaveId => {
    console.log('getEmployees promise resolved : ' + leaveDetailsByLeaveId);
    this.leaveDetailsByLeaveId = leaveDetailsByLeaveId;
    //this.leaveId = this.leave[0].leaveId;
    console.log(leaveDetailsByLeaveId);
    this.leaveEmpId=this.leaveDetailsByLeaveId.empId;
    console.log("hjhajksdhkhsdkhkszhdkfh" ,this.leaveEmpId);
    this.leaveId= this.leaveDetailsByLeaveId.leaveId;
    this.leaveIdApprove = leaveDetailsLeaveId;
    this.startDate = leaveDetailsByLeaveId.startDate;
    this.endDate = leaveDetailsByLeaveId.endDate;
    this.reason = leaveDetailsByLeaveId.reason;
    this.type = leaveDetailsByLeaveId.leaveType;
    this.noofDays = leaveDetailsByLeaveId.noOfDays;
    // this.leaveEmpId1 =leaveEmpId;
    // this.employeeService.getEmployeesById(this.leaveEmpId1).then(leaveEmpName => {
    //   console.log('getleaveDetails promise resolved : ' + leaveEmpName);
    //   this.leaveEmpName = leaveEmpName;
      
      // console.log(leaveEmpName.empNa
   }
  ); 
}

findEmpName (empId:number): String{
  this.empIdEmail= empId;
  console.log("gwdkhhkdhkhkhqqqqqqqqqqqqqqqqqqqqqq",this.empIdEmail);
  //this.getEmployees();
  for (var _i = 0; _i <  this.employees.length; _i++) {
    //this.empNme=null;
    if(this.empIdEmail==this.employees[_i].empId){
      this.empName=this.employees[_i].empName;
      break;
    }
  }
  return this.empName;
  
}
findEmpEmail(empId:number): String{
  //this.getEmployees();
  for (var _i = 0; _i <  this.employees.length; _i++) {
    //this.empNme=null;
    if(empId==this.employees[_i].empId){
      this.empEmail=this.employees[_i].empEmail;
      break;
    }
  }
  return this.empEmail;
  
}
managerCommentsEnable():boolean{
  if (this.managerComments==null){
    return  true;
  }
  else{
    return false;
  }
}
goBack():void{
  this.router.navigate(['/pendinglog',this.empId]);
}
}
