import { Component, OnInit } from '@angular/core';
import { EmployeeService } from './employee.service';
import { Employee } from './employee';
import { Router, RouterModule ,ActivatedRoute} from '@angular/router';


@Component({
  selector: 'appR2',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css'],
  providers: [ EmployeeService ]
})
export class EmployeeComponent implements OnInit {
  empId:number;
  constructor(private employeeService: EmployeeService, private router: Router,private route: ActivatedRoute) { this.empId=this.route.snapshot.params['emp'];}
 
  title = 'Leave Management Application';
  employees: Employee[];

  getEmployees(): void {
      this.employeeService.getEmployees().then(employees => {
        console.log('getEmployees promise resolved : ' + employees.length);
        this.employees = employees;
      }
    );
  }

  ngOnInit(): void {
    this.getEmployees();
  }
  loginForm(i:number){
    console.log("aya",i)
    this.router.navigate(['/login',this.employees[i].empId])
}
// goToChatbot(){
//   this.router.navigate(['/chatbot']);
// }
}
