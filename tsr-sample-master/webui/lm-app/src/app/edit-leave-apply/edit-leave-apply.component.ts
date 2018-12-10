import { Component, OnInit } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';
import { EmployeeService } from '../employee/employee.service';
import { LeavedetailsService } from '../leavedetails.service';
import { LeaveDetails } from '../leaveDetails';
import { FormGroup, FormControl,Validators,FormsModule } from '@angular/forms';
import { Employee } from '../employee/employee';
@Component({
  selector: 'app-edit-leave-apply',
  templateUrl: './edit-leave-apply.component.html',
  styleUrls: ['./edit-leave-apply.component.css'],
  providers: [ LeavedetailsService ]
})
export class EditLeaveApplyComponent implements OnInit {
  emp : number;
  empid:Number;
  num:number;
  date: String;
  date1: String;
  date2: String;
  leave: LeaveDetails;
  employees : Employee[];
  employees1: Employee;
  manager: Employee;
  mgr:number;
  j : number;
  startDate: string;
  endDate:string;
  reason:string;
  cDate: Date;
  noOfDays: number;
  leaveId:number;
  sDate:string;
  eDate:string;
    constructor(private leaveDetailsService: LeavedetailsService,private employeeService: EmployeeService,private route:ActivatedRoute, private router : Router) {this.emp=this.route.snapshot.params['empId'];
    this.leaveId=this.route.snapshot.params['leaveId'];
    this.startDate=this.route.snapshot.params['startDate'];
    this.endDate=this.route.snapshot.params['endDate'];
    console.log("cons leaviod", this.leaveId);
  }
  
    getEmployees(): void {
      this.employeeService.getEmployees().then(employees => {
        console.log('getEmployees promise resolved : ' + employees.length);
        this.employees = employees;
      }
    );
  }
  getEmp(){
    for(var i=0;i<5;i++){
      if(this.emp==this.employees[i].empId)
      {
      this.j=i;
      }
    }
    this.employees1=this.employees[this.j];
    
  }
  getMgr(){
    for(var i=0;i<5;i++){
      if(this.mgr==this.employees[i].empId)
      {
      this.j=i;
      }
    }
    this.manager=this.employees[this.j];
    
  }
  getEmpId():number{
    var date1= new Date(this.startDate);
    var date2= new Date (this.endDate);
    this.noOfDays=((date2.getTime() - date1.getTime())/ (1000 * 60 * 60 * 24))+1;
    this.getEmp();
    this.mgr=this.employees1.managerId;
    this.getMgr();
    return this.employees1.empId;
  }

apply(emp):void{
  console
  this.leaveDetailsService.doEditApply(emp,this.startDate,this.endDate,this.reason,this.leaveId).subscribe(
    data => {
      alert(data);
      if(data=="Leave updated successfully"){
        this.leaveDetailsService.getLatestLeave(this.emp).then(leaveHistory => {
          console.log('getLatestLeave promise resolved : ' + leaveHistory);
          this.leave = leaveHistory;
          console.log(this.leave);
          this.router.navigate(['/dashboard',this.emp]);
        }
      );

      }
    },
    err => {
      console.log(err);
    });

}

applyButton(){
  console.log("asdasdasdasdsadsadsa")
  this.apply(this.emp);
}
  
    ngOnInit() {
      this.cDate= new Date;
      this.getEmployees();
      //this.getMan(this.employees1.managerId)
    }

}