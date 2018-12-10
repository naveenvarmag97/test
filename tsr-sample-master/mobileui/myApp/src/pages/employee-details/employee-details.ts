import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { EmployeeServiceProvider } from '../../providers/employee-service/employee-service';
import { Employee } from '../../providers/employee-service/employee';
/**
 * Generated class for the EmployeeDetailsPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-employee-details',
  templateUrl: 'employee-details.html',
})
export class EmployeeDetailsPage {
empId:number;
employees:Employee;
  constructor(public navCtrl: NavController, public navParams: NavParams,private employeeService: EmployeeServiceProvider) {
    this.empId=this.navParams.data
    this.getEmployees(this.empId);
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad EmployeeDetailsPage');
    this.getEmployees(this.empId);
  }
  getEmployees(emp:number): Employee {
    console.log("anuj emp",emp);
    this.employeeService.getOneEmployees(emp).then(employees => {
      console.log('getEmployees promise resolved : ' + employees);
      this.employees = employees;
      console.log("klklklklk",this.employees)
    }
  );
  return this.employees 
}

}
