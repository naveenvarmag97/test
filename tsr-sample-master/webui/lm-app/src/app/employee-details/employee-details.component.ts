import { Component, OnInit } from '@angular/core';
import {Router, RouterModule,Routes,ActivatedRoute} from '@angular/router';
import { Employee } from '../employee/employee';
import { EmployeeService } from '../employee/employee.service';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css'],
  providers: [ EmployeeService ]
})
export class EmployeeDetailsComponent implements OnInit {
  title:string="Employee Details"
  empid:number;
  num:number;
  employees : Employee;
 
    constructor(private employeeService: EmployeeService,private route:ActivatedRoute, private router : Router) { this.empid=this.route.snapshot.params['empId'];}
  
    getEmployees(emp:number): Employee {
      console.log("anuj emp",emp);
      this.employeeService.getOneEmployees(emp).then(employees => {
        console.log('getEmployees promise resolved : ' + employees);
        this.employees = employees;
      }
    );
    return this.employees 
  }
  onback() {
    this.router.navigate(['/dashboard',this.empid]);
  }

 
  
    ngOnInit(): void {
      this.getEmployees(this.empid);
    
     }
    
     
    
    }
  


