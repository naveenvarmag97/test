import { Component, OnInit } from '@angular/core';
import {Router, RouterModule,Routes,ActivatedRoute} from '@angular/router';
import { Employee } from '../employee/employee';
import { EmployeeService } from '../employee/employee.service';

@Component({
  selector: 'app-manager-details',
  templateUrl: './manager-details.component.html',
  styleUrls: ['./manager-details.component.css']
})
export class ManagerDetailsComponent implements OnInit {

  empid:number;
  num:number;
  employees : Employee[];
  managerId :number;
  managerDetail:Employee;
  emp : number;
  employees1: Employee;
  manager: Employee;
  mgr:number;
  j : number;
 
    constructor(private employeeService: EmployeeService,private route:ActivatedRoute, private router : Router) { this.empid=this.route.snapshot.params['empId'];}
  
    getEmployees(): void {
      this.employeeService.getEmployees().then(employees => {
        console.log('getEmployees promise resolved : ' + employees.length);
        this.employees = employees;
        console.log(this.employees);
      }
    );
  }
  // getmanagerDetails(mgrId:number): void{
  //   this.employeeService.getOneEmployees(mgrId).then(employees => {
  //     console.log('getEmployees promise resolved : ' + employees);
  //     this.managerDetail = employees;
  //   }
  // );

  // }
  getEmp(){
    for(var i=0;i< 5  ;i++){
      if(this.empid==this.employees[i].empId)
      {
      this.j=i;
      }
    }
    console.log("ssssss",this.empid)
    console.log(this.j);
    console.log(this.employees[this.j]);
    this.employees1=this.employees[this.j];
    console.log(this.employees1);
  }
  getMgr(){
    for(var i=0;i< 5;i++){
      if(this.mgr==this.employees[i].empId)
      {
      this.j=i;
      }
    }
    this.manager=this.employees[this.j];
    
  }
  getEmpId():number{
    console.log("ssc vs",this.empid)
    this.getEmp();
    this.mgr=this.employees1.managerId;
    this.getMgr();
    return this.manager.empId;
  }
  getEmpName():String{
    return this.employees1.empName;
  }

  onback() {
    this.router.navigate(['/dashboard',this.empid]);
  }
  ngOnInit(): void {
    this. getEmployees();
    
   }
  
  

}
