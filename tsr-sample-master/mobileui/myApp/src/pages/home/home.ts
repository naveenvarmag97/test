import { Component, OnInit } from '@angular/core';
import { NavController } from 'ionic-angular';
import { EmployeeServiceProvider } from '../../providers/employee-service/employee-service';
import { Employee } from '../../providers/employee-service/employee';
import {LoginFormPage} from '../login-form/login-form'



@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  constructor(public navCtrl: NavController,private employeeService: EmployeeServiceProvider) {

  }
  title = 'Leave Management Application';
  employees: Employee[];

  getEmployees(): void {
      this.employeeService.getEmployees().then(employees => {
        console.log('getEmployees promise resolved : ' + employees.length);
        this.employees = employees;
        console.log("ehhehehehhe",this.employees);
      }
    );
  }
  ngOnInit(): void {  
    this.getEmployees();
  }
  loginForm(i:number){
this.navCtrl.push(LoginFormPage,this.employees[i].empId);
  }

}
