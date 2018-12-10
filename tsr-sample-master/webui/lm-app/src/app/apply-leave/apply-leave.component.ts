import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee/employee';
import { Router,ActivatedRoute } from '@angular/router';
import { EmployeeService } from '../employee/employee.service';
import { LeavedetailsService } from '../leavedetails.service';
import { LeaveDetails } from '../leaveDetails';
import * as $ from 'jquery';
import { FormGroup, FormControl,Validators,FormsModule,ReactiveFormsModule } from '@angular/forms';
@Component({
  selector: 'app-apply-leave',
  templateUrl: './apply-leave.component.html',
  styleUrls: ['./apply-leave.component.css'],
  providers: [ EmployeeService,LeavedetailsService ]
})
export class ApplyLeaveComponent implements OnInit {
  empEmailId: any;
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
  holidays : Date[] = [new Date("2018-01-01"), new Date("2018-01-26"),new Date("2018-03-02"),new Date("2018-03-30"),
  new Date("2018-05-01"),new Date("2018-06-15"),new Date("2018-08-15"),new Date("2018-09-13"),new Date("2018-10-02"),
  new Date("2018-10-18"),new Date("2018-10-19"),new Date("2018-11-01"),new Date("2018-11-06"),new Date("2018-12-25")];
  startDate: string;
  endDate:string;
  reason:string;
  cDate: Date;
  noOfDays: number;
  leaveType:string;
  leaveOption:number;
    constructor(private leaveDetailsService: LeavedetailsService,private employeeService: EmployeeService,private route:ActivatedRoute, private router : Router) {this.emp=this.route.snapshot.params['empId'];}
  
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
    // this.noOfDays=((date2.getTime() - date1.getTime())/ (1000 * 60 * 60 * 24))+1;
    this.noOfDays=this.getDays(); 
    this.getEmp();
    this.mgr=this.employees1.managerId;
    this.getMgr();
    this.empEmailId=this.employees1.empEmail;
    console.log("employeee enailmmmmmmmmmmmmmmmmmmmmmmmllllllllllllllllllllll",this.empEmailId);
    console.log("employeee enailmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm",this.manager.empEmail);

    return this.employees1.empId;
  }
  getDays():number {
    var d1= new Date(this.startDate);
    var d2= new Date (this.endDate);
    var one_day=1000*60*60*24;
    var d1_days = ( d1.getTime() /one_day) - 1;
    var d2_days = (d2.getTime()/one_day);
    var days = (d2_days - d1_days);
    var weeks = (d2_days - d1_days) / 7;
    var day1 = d1.getDay();
    var day2 = d2.getDay();
    if (day1 == 0) {
        days--;
    } else if (day1 == 6) {
        days-=1;
    }
    if (day2 == 0) {
       days-=1;
    } else if (day2 == 6) {
       days--;
    }
    days -= (weeks) * 2;
    days = Math.floor(days);
    for(var i=0; i<this.holidays.length;i++){
      if(d1==this.holidays[i]||d2==this.holidays[i]){
        days=days-1;
      }
       if(d1<this.holidays[i]&&d2>this.holidays[i]){
        days=days-1;
      }
    }
    return days+1;
}

apply(emp):string{
  if(this.leaveType == "EL"){
    this.leaveOption = 1;
  } else if(this.leaveType == "SICK"){
    this.leaveOption = 2;
  }else {
    this.leaveOption = 3;
  }
  this.leaveDetailsService.doApply(emp,this.startDate,this.endDate,this.reason,this.leaveOption).subscribe(
    data => {
      console.log(data);
      alert(data);
      if(data=="Leave applied successfully"){
        this.leaveDetailsService.getLatestLeave(this.emp).then(leaveHistory => {
          console.log('getLatestLeave promise resolved : ' + leaveHistory);
          this.leave = leaveHistory;
          console.log(this.leave);
          alert("your applied Leave ID is "+this.leave.leaveId);
          //
          var data = {
  
            service_id: 'gmail',
            
            template_id: 'template_rs4rNMb0',
            
            user_id: 'user_7AZFvXjhn5Y5XybIV0xuZ',
            
            template_params: {
            
            'username': this.employees1.empName,
            'mEmailId' :this.manager.empEmail,
            'eEmailId' :this.empEmailId,
            'leaveId' :this.leave.leaveId,
            'message_html': "Your leave with leave ID :->" +this.leave.leaveId +  " has been applied",
            
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
           
          //
          this.router.navigate(['/dashboard',this.emp]);
          return "apply";
        }
      );

      }
    },
    err => {
      console.log(err);
    });

    return "apply";

}

applyButton():string{
  this.apply(this.emp)
  return "applied";
}
  
    ngOnInit() {
      this.cDate= new Date;
      this.getEmployees();
      //this.getMan(this.employees1.managerId)
    }

}
