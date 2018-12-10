
import { Component, OnInit } from '@angular/core';
import { EmployeeService } from './employee/employee.service';
import { LeavedetailsService } from './leavedetails.service';
import { Employee } from './employee/employee';
import { LeaveDetails } from './leavedetails';
import {Router,Route,ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [ EmployeeService,LeavedetailsService ]
})
export class AppComponent implements OnInit {
  constructor(private employeeService: EmployeeService,private leavedetailaservice: LeavedetailsService , private router:Router) { }
  

  title = 'Leave Management Application';
  employees: Employee[];
  leavedetails: LeaveDetails[];

  getEmployees(): void {
      this.employeeService.getEmployees().then(employees => {
        console.log('getEmployees promise resolved : ' + employees.length);
        this.employees = employees;
      }
    );
  }
  goToLogin() {
    this.router.navigate(['/employees']);
  }
  
  ngOnInit(): void {
    this.getEmployees();
    this.router.navigate(['/employees']);
  }

}