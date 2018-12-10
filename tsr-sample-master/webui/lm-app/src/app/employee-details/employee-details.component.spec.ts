import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeDetailsComponent } from './employee-details.component';
import { EmployeeService } from '../employee/employee.service';
import { Employee } from '../employee/employee';
import {
  RouterTestingModule
} from '@angular/router/testing';
import {LeavedetailsService} from '../leavedetails.service'
import { FormsModule } from '@angular/forms';

class MockEmployeeService {
  getEmployeeDetails(empId): Promise<Employee> {
    console.log('Mock getEmployees called');
    empId = 1000;
    return Promise.resolve(new Employee(empId,"Yogesh","123@gmail.com",555252525,1000,"CSC",30,"2019-03-24","url"));
  }
}
describe('EmployeeDetailsComponent', () => {
  let component: EmployeeDetailsComponent;
  let fixture: ComponentFixture<EmployeeDetailsComponent>;
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        EmployeeDetailsComponent
      ],
      imports: [ RouterTestingModule, FormsModule ]
    }).overrideComponent(EmployeeDetailsComponent, {
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
  //   fixture = TestBed.createComponent(EmployeeDetailsComponent);
  //   component = fixture.componentInstance;
  //   //fixture.detectChanges();
  // });

  // it('should be created', () => {
  //   expect(component).toBeTruthy();
  // });
  // it('should compare employee Details', async(() => {
  //   const fixture = TestBed.createComponent(EmployeeDetailsComponent);
  //   // fixture.detectChanges();
  //   fixture.whenStable().then(() => {
  //     //fixture.detectChanges();
  //     const compiled = fixture.debugElement.nativeElement;
  
  //     expect(component.getEmployees.length).toBe(1);
  //   });
  // }));
});
