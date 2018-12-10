import { async, ComponentFixture, TestBed } from '@angular/core/testing';
//import { EmployeeService } from '../employee/employee.service';
import { LeavedetailsService } from '../leavedetails.service';
import { LeaveHistoryComponent } from './leave-history.component';
import { RouterTestingModule } from '@angular/router/testing';
import { Http,HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { LeaveDetails } from '../leavedetails';
import { Employee } from '../employee/employee';




class MockLeavedetailsService {
  getLeaveHistory(empId): Promise<LeaveDetails[]> {
    console.log('Mock getLeaveHistory called');
    return Promise.resolve([new LeaveDetails(1000,2, "2019-06-24", "2019-06-25", "2019-06-21",  2,"SICK", "EL", "PENDING",
    "APP")]);
  }
}

describe('LeaveHistoryComponent', () => {
  let component: LeaveHistoryComponent;
  let fixture: ComponentFixture<LeaveHistoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LeaveHistoryComponent ],imports:[RouterTestingModule,FormsModule,HttpModule]
    }).overrideComponent(LeaveHistoryComponent, {
      set: {
        providers: [
          {provide: LeavedetailsService, useClass: MockLeavedetailsService }
        ]
      }
    }).compileComponents();
  }));

  // beforeEach(() => {
  //   fixture = TestBed.createComponent(LeaveHistoryComponent);
  //   component = fixture.componentInstance;
  //   //fixture.detectChanges();
  // });

  // it('should be created', () => {
  //   expect(component).toBeTruthy();
  // });
  // it('should render one history record', async(() => {
  //   const fixture = TestBed.createComponent(LeaveHistoryComponent);
  //   // fixture.detectChanges();
  //   fixture.whenStable().then(() => {
  //     // fixture.detectChanges();
  //     const compiled = fixture.debugElement.nativeElement;
  //     expect(compiled.querySelectorAll('.leaveHistory tr').length).toBe(0);
  //   });
  // }));
});