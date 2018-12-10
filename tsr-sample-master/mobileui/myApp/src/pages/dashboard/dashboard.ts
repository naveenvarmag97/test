import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import{EmployeeDetailsPage} from '../employee-details/employee-details'

/**
 * Generated class for the DashboardPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-dashboard',
  templateUrl: 'dashboard.html',
})
export class DashboardPage {
empId:number;
  constructor(public navCtrl: NavController, public navParams: NavParams) {
   this.empId= this.navParams.data;
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad DashboardPage');
  }
  goToEmpDetail(){
    this.navCtrl.push(EmployeeDetailsPage,this.empId);
  }
}
