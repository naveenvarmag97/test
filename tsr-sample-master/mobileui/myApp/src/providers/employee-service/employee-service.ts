import { Metrics } from './../../../../../webui/lm-app/src/app/metrics';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Http ,Response } from '@angular/http';
import { Employee } from './employee';
import 'rxjs/add/operator/toPromise';
import { LeaveDetails } from '../../../../../webui/lm-app/src/app/leavedetails';


/*
  Generated class for the EmployeeServiceProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class EmployeeServiceProvider {

  constructor(private http: Http, private httpClient:HttpClient) {
    console.log('Hello EmployeeServiceProvider Provider');
  }
  getEmployees(): Promise<Employee[]> {
    console.log('getEmployees called on employee.service');
    return this.http.get('http://localhost:8080/ftp46/api/employees')
    .toPromise()
    .then(response => response.json() as Employee[])
    .catch(this.handleError);
}
getOneEmployees(empid:number): Promise<Employee> {
  console.log('getEmployees called on employee.service',empid);
  return this.http.get('http://localhost:8080/ftp46/api/employees/emp/'+ empid)
  .toPromise()
  .then(response => response.json() as Employee)
  .catch(this.handleError);
}

getNoOfEmployees(empId:number): Promise<Metrics>{
  var n:number;
  console.log('getNumberOfEmployees called on employee.service');
  return this.http.get('http://localhost:8080/ftp46/api/employees/mgremp/'+ empId)
  .toPromise()
  .then(response => response.json() as Metrics)
  .catch(this.handleError);
}
getLeaveHistory(empid:number): Promise<LeaveDetails[]> {
  console.log('getLeaveDetails called on employee.service');
  return this.http.get('http://localhost:8080/ftp46/api/leaveDetails/history/'+ empid)
  .toPromise()
  .then(response => response.json() as LeaveDetails[])
  .catch(this.handleError);
}


private handleError(error: any): Promise<any> {
  console.error('An error occurred', error); // for demo purposes only
  return Promise.reject(error.message || error);
}
  

}
