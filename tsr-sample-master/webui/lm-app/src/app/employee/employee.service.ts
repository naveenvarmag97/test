import { Employee } from './employee';
import{LeaveDetails} from '../leavedetails';

import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/toPromise';

import { Http ,Response } from '@angular/http';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Metrics } from '../metrics';

@Injectable()
export class EmployeeService {
    constructor(private http: Http) {
    }

    getEmployees(): Promise<Employee[]> {
        console.log('getEmployees called on employee.service');
        return this.http.get('http://localhost:8070/ftp46/api/employees')
        .toPromise()
        .then(response => response.json() as Employee[])
        .catch(this.handleError);
    }
    // getSpecificEmployees(empId:number): Promise<Employee> {
    //     console.log('getSpecific Employees called on employee.service');
    //     console.log("return anyuj",this.http.get('http://localhost:8070/ftp46/api/employees/emp/'+empId));
    //     return this.http.get('http://localhost:8070/ftp46/api/employees/emp/'+empId)
    //     .toPromise()
    //     .then(response => response.json() as Employee)
    //     .catch(this.handleError);
    // }
    


    getOneEmployees(empid:number): Promise<Employee> {
        console.log('getEmployees called on employee.service',empid);
        return this.http.get('http://localhost:8070/ftp46/api/employees/emp/'+ empid)
        .toPromise()
        .then(response => response.json() as Employee)
        .catch(this.handleError);
    }

    getNoOfEmployees(empId:number): Promise<Metrics>{
        var n:number;
        console.log('getNumberOfEmployees called on employee.service');
        return this.http.get('http://localhost:8070/ftp46/api/employees/mgremp/'+ empId)
        .toPromise()
        .then(response => response.json() as Metrics)
        .catch(this.handleError);
    }
    getLeaveHistory(empid:number): Promise<LeaveDetails[]> {
        console.log('getLeaveDetails called on employee.service');
        return this.http.get('http://localhost:8070/ftp46/api/leaveDetails/history/'+ empid)
        .toPromise()
        .then(response => response.json() as LeaveDetails[])
        .catch(this.handleError);
    }
//     getEmpDetails(empid:number) {
//  this.httpClient.get('http://localhost:8070/ftp46/api/employees/emp/${empid}');
//  .subscribe(

//  )
//     }
    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error); // for demo purposes only
        return Promise.reject(error.message || error);
    }
}
