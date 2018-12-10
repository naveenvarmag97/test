import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl,Validators } from '@angular/forms';
import { Router,ActivatedRoute } from '@angular/router';
import { Employee } from '../employee/employee';
import { EmployeeService } from '../employee/employee.service';
import * as $ from 'jquery';
@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {
  emp: number;
  employees:Employee;

  constructor(private route:ActivatedRoute, private router : Router, private employeeService:EmployeeService) {this.emp=this.route.snapshot.params['emp']; }
  ngOnInit() {
    this.getEmployees(this.emp);
  }
  getEmployees(emp:number): void {
    console.log("anuj emp",emp);
    this.employeeService.getOneEmployees(emp).then(employees => {
      console.log('getEmployees promise resolved : ' + employees);
      this.employees = employees;
      console.log(this.employees);
    }
  );
}

  cancelButton(){

    this.router.navigate(['/employees']);
  }
  loginButton(){

  // var data = {
  
  // service_id: 'gmail',
  
  // template_id: 'template_rs4rNMb0',
  
  // user_id: 'user_7AZFvXjhn5Y5XybIV0xuZ',
  
  // template_params: {
  
  // 'username': 'YOLO',
  
  // }
  
  // };
  
   
  
  // $.ajax('https://api.emailjs.com/api/v1.0/email/send', {
  
  // type: 'POST',
  
  // data: JSON.stringify(data),
  
  // contentType: 'application/json'
  
  // }).done(function() {
  
  // alert('Your mail is sent!');
  
  // }).fail(function(error) {
  
  // alert('Oops... ' + JSON.stringify(error));
  
  // });
  
  this.router.navigate(['/dashboard',this.emp]);
  
  }
}
