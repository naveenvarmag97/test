import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { EmployeeService } from '../employee/employee.service';
import { ManagerDetailsComponent } from './manager-details.component';
import {Router, RouterModule,Routes,ActivatedRoute} from '@angular/router';
import { inject } from '@angular/core/testing';
import { Http,HttpModule } from '@angular/http';
import { Employee } from '../employee/employee';
import { FormsModule } from '@angular/forms';
import {
  RouterTestingModule
} from '@angular/router/testing';

import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { HttpClient } from '@angular/common/http';

class MockEmployeeService {
  getEmployeeDetails(empId): Promise<Employee> {
    console.log('Mock getEmployees called');
    empId = 1000;
    return Promise.resolve(new Employee(empId,"Yogesh","123@gmail.com",555252525,1000,"CSC",30,"2019-03-24","url"));
  }
}
describe('ManagerDetailsComponent', () => {
  let component: ManagerDetailsComponent;
  let fixture: ComponentFixture<ManagerDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        ManagerDetailsComponent
      ],
      imports: [ RouterTestingModule, FormsModule ]
    }).overrideComponent(ManagerDetailsComponent, {
      set: {
        providers: [
          {provide: EmployeeService, useClass: MockEmployeeService },
           {provide: EmployeeService, useClass: MockEmployeeService },
          //  {provide: LeavedetailsService, useClass: MockLeavedetailsService },
        ]
        
      }
    }).compileComponents();
  }));

  // beforeEach(() => {
  //   fixture = TestBed.createComponent(ManagerDetailsComponent);
  //   component = fixture.componentInstance;
  //  // fixture.detectChanges();
  // });

  // it('should be created', () => {
  //   expect(component).toBeTruthy();
  // });
  //testing -test case - not working properly
  // it('should be created EMPID', () => {
  //   expect(component.getEmpId.length).toBe(0);
  // });
});
