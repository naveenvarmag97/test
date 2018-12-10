import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { Employee } from '../../providers/employee-service/employee';
import { EmployeeServiceProvider } from '../../providers/employee-service/employee-service';
import {DashboardPage} from '../dashboard/dashboard'


/**
 * Generated class for the LoginFormPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-login-form',
  templateUrl: 'login-form.html',
})
export class LoginFormPage {
 empId:number;
 employees: Employee;
  constructor(public navCtrl: NavController, public navParams: NavParams,private employeeService:EmployeeServiceProvider) {
    this.empId=this.navParams.data
    
  }

  ionViewDidLoad() {
    this.getOneEmployees(this.navParams.data);
    console.log('ionViewDidLoad LoginFormPage');
    console.log(this.empId);
  }
  getOneEmployees(emp:number): void { 
    console.log("anuj emp",emp);
    this.employeeService.getOneEmployees(emp).then(employees => {
      console.log('getEmployees promise resolved : ' + employees);
      this.employees = employees;
      
    }
  );
}
gotToDash(){
  this.navCtrl.push(DashboardPage,this.empId);
    }
    cancelButton(){
      this.navCtrl.pop();  
    }


}
