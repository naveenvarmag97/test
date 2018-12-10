import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { Http, HttpModule } from '@angular/http';
import { ApplyLeaveComponent } from './apply-leave.component';
import { FormGroup, FormControl,Validators,FormsModule,ReactiveFormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { Employee } from '../employee/employee';
import { EmployeeService } from '../employee/employee.service';
import { LeaveDetails } from '../leavedetails';
import {LeavedetailsService} from '../leavedetails.service'
import { by } from 'protractor';
import { By } from '@angular/platform-browser';
class MockEmployeeService {
  getEmployees(): Promise<Employee[]> {
    console.log('Mock getEmployees called');
    return Promise.resolve([new Employee(1000,"Anuj Pancholi","anujpachOO@gmail.com",3152441590,1000,"Higher Management",24,'1999-05-12',"url")]);
  }
}
class MockLeavedetailsService {
  getEmployees(): Promise<LeaveDetails[]> {
    console.log('Mock getEmployees called');
    return Promise.resolve([new LeaveDetails(1000,1,"2018-07-20","2018-07-22","2018-07-17",3,"EL","sick","Pending","gggggggggg")]);
  }
}

describe('ApplyLeaveComponent', () => {
  let component: ApplyLeaveComponent;
  let fixture: ComponentFixture<ApplyLeaveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApplyLeaveComponent ],
      imports:[FormsModule, RouterTestingModule,HttpModule],
     
      
    }).overrideComponent(ApplyLeaveComponent, {
      set: {
        providers:[ 
          {provide: LeavedetailsService, useClass: MockLeavedetailsService },
          {provide: EmployeeService, useClass: MockEmployeeService }],

        
      }
    }).compileComponents();
  }));
  // beforeEach(() => {
  //   fixture = TestBed.createComponent(ApplyLeaveComponent);
  //   component = fixture.componentInstance;
  //   // fixture.detectChanges();
  // });
  // it('should compare employee Details', async(() => {
  //   const fixture = TestBed.createComponent(ApplyLeaveComponent);
  //   //fixture.detectChanges();
  //   fixture.whenStable().then(() => {
  //    //fixture.detectChanges();
  //     const compiled = fixture.debugElement.nativeElement;
  //     expect(component.getEmployees.length).toBe(0);
  //   });
  // }));

  //   it('should render title in a option EL ', async(() => {
  //     const fixture = TestBed.createComponent(ApplyLeaveComponent);
  //     // fixture.detectChanges();
  //     const compiled = fixture.debugElement.nativeElement;
  //     expect(compiled.querySelector('select').textContent).toContain('EL');
  //   }));
    // it('should be created', () => {
    //   expect(component).toBeTruthy();
    // });
  //   it('should be created  get days', () => {
  //     expect(component.getDays()).toBeNaN();
  //   });
  //   // it('should be created  get apply', () => {
  //   //   expect(component.getEmpId());
  //   // });
  // });


  // it('should be created', () => {
  //   expect(component).toBeTruthy();
  // });
});
