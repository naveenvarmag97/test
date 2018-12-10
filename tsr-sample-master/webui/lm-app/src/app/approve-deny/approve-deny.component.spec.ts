import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { Http,HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { ApproveDenyComponent } from './approve-deny.component';
import { EmployeeService } from '../employee/employee.service';
import { Employee } from '../employee/employee';
import { LeavedetailsService } from '../leavedetails.service';
import { LeaveDetails } from '../LeaveDetails';

class MockEmployeeService {
  getEmployees(): Promise<Employee[]> {
    console.log('Mock getEmployees called');
    
    return Promise.resolve([new Employee(1000,"sai","YOLO@gmail.com",9912140507,1000,"IT",30,"2019-03-24","url"), new Employee(2000,"sai","YOLO@gmail.com",9912140507,1000,"IT",30,"2019-03-24","url")]);
  }
}
class MockLeaveDetailsService {
  getLeaveDetails(empId): Promise<LeaveDetails> {
    console.log('Mock getLeavePending called');
    return Promise.resolve(new LeaveDetails(1000,2, "2019-06-24", "2019-06-25", "2019-06-21",  2,"SICK", "EL", "PENDING",
    "APP"));
  }
  getLeaveDetailsByLeaveId(leaveId): Promise<LeaveDetails> {
    console.log('Mock getLeavePending called');
    return Promise.resolve(new LeaveDetails(1000,2, "2019-06-24", "2019-06-25", "2019-06-21",  2,"SICK", "EL", "PENDING",
    "APP"));
  }
}




describe('ApproveDenyComponent', () => {
  let component: ApproveDenyComponent;
  let fixture: ComponentFixture<ApproveDenyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApproveDenyComponent ],imports:[RouterTestingModule,FormsModule,HttpModule], providers: [EmployeeService]
    })
    .overrideComponent(ApproveDenyComponent, {
      set: {
        providers: [{provide: LeavedetailsService, useClass: MockLeaveDetailsService },
          {provide: EmployeeService, useClass: MockEmployeeService }
        ]
      }
    }).compileComponents();
  }));

  // beforeEach(() => {
  //   fixture = TestBed.createComponent(ApproveDenyComponent);
  //   component = fixture.componentInstance;
  //   // fixture.detectChanges();
  // });
  // it('should compare employee Details', async(() => {
  //   const fixture = TestBed.createComponent(ApproveDenyComponent);
  //   //fixture.detectChanges();
  //   fixture.whenStable().then(() => {
  //     // fixture.detectChanges();
  //     const compiled = fixture.debugElement.nativeElement;
  //     expect(component.managerCommentsEnable()).toBeTruthy();
  //   });
  // }));
  // // it('should compare leave Details', async(() => {
  // //   const fixture = TestBed.createComponent(ApproveDenyComponent);
  // //   fixture.detectChanges();
  // //   fixture.whenStable().then(() => {
  // //     // fixture.detectChanges();
  // //     const compiled = fixture.debugElement.nativeElement;
  // //     expect(component.getLeaveId.length).toBe(1);
  // //   });
  // }));
  // it('should be created', () => {
  //   expect(component).toBeTruthy();
  // });
});



