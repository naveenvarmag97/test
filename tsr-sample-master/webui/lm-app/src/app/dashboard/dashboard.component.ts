import { Component, OnInit } from '@angular/core';
import {Router, RouterModule,Routes,ActivatedRoute} from '@angular/router'
import { Employee } from '../employee/employee';
import { EmployeeService } from '../employee/employee.service';
import { DomSanitizer, SafeHtml,SafeUrl,SafeStyle} from '@angular/platform-browser';
import { Metrics } from '../metrics';
import { LeavedetailsService} from '../leavedetails.service';
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
  providers: [ EmployeeService, LeavedetailsService ]
})
export class DashboardComponent implements OnInit {
  empId:number;
  empid:number;
  num:number;
  employees : Employee;
   profileUrl:string;
   profileUrlSafe:SafeStyle;
   count1:Metrics;
   count2:Metrics;
   count3:Metrics;
   count4:Metrics;
   gt:string;
   gv3:Metrics;
  gv4:Metrics;
  gv2:Metrics;
  gl:string;
  constructor(private leavedetailsService : LeavedetailsService, private employeeService: EmployeeService,private router: Router,private route:ActivatedRoute,private sanitization:DomSanitizer) {this.empId=this.route.snapshot.params['empId']; }
  getEmployees(emp:number): void {
    console.log("anuj emp",emp);
    this.employeeService.getOneEmployees(emp).then(employees => {
      console.log('getEmployees promise resolved : ' + employees);
      this.employees = employees;
      console.log(this.employees);
    }
  );
}
getNoOfEmployees(emp:number){
  console.log("metrics function");
  this.employeeService.getNoOfEmployees(emp).then(count=>{
    console.log('getting no of employees promise resolved: '+ count);
    this.count1=count;
    console.log(this.count1);
  })
}

getNoOfAppliedLeaves(emp:number){
  console.log("metrics function");
  this.leavedetailsService.getNoOfAppliedLeaves(emp).then(count=>{
    console.log('getting no of Applied Leaves: '+ count);
    this.count3=count;
    console.log(this.count3);
    this.gt="full";
    this.gv3=this.count3;
this.gl="applied Leaves";
  })
}
getLeaveDays(emp:number){
  console.log("metrics function");
  this.leavedetailsService.getLeaveDays(emp).then(count=>{
    console.log('getting no of LeaveDays: '+ count);
    this.count4=count;
    console.log(this.count4);
    this.gv4=this.count4;
  })
}
getNoOfPending(emp:number){
  console.log("metrics function");
  this.leavedetailsService.getNoOfPending(emp).then(count=>{
    console.log('getting no of pending '+ count);
    this.count2=count;
    console.log(this.count2);
    this.gv2=this.count2;
  })
}
  ngOnInit() {
    this.getEmployees(this.empId);
    this.getNoOfEmployees(this.empId);
    this.getLeaveDays(this.empId);
    this.getNoOfAppliedLeaves(this.empId);
    this.getNoOfPending(this.empId);
  }

  
  goToEmpDetails() {
    this.router.navigate(['/empDetails',this.empId]);
  }
  goToLeaveHistory(){
    this.router.navigate(['/leavedetails',this.empId]);
  }
  goToMgrDetails(){
    this.router.navigate(['/manager',this.empId]);
  }
  goToPending(){
    console.log("aya" )
    this.router.navigate(['/pending',this.empId]);
  }
  goToPendinglog(){
    this.router.navigate(['/pendinglog',this.empId]);
  }
  goToApplyLeave(){
    this.router.navigate(['/applyLeave',this.empId]);
  }
  // goToApprove(){
  //   this.router.navigate(['/approveDeny',this.empId]);
  // }

}
