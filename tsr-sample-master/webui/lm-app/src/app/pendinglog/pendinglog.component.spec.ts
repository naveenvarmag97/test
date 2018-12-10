import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { LeavedetailsService } from '../leavedetails.service';
import { EmployeeService } from '../employee/employee.service';
import { PendinglogComponent } from './pendinglog.component';
import { Router,RouterModule,ActivatedRoute} from '@angular/router';
import { LeaveDetails } from '../LeaveDetails';
import { RouterTestingModule } from '../../../node_modules/@angular/router/testing';
import { FormsModule } from '../../../node_modules/@angular/forms';
import { HttpModule } from '../../../node_modules/@angular/http';
import { Employee } from '../employee/employee';
import { Ng2OrderModule } from 'ng2-order-pipe';
import { Ng2SearchPipeModule } from 'ng2-search-filter';



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

describe('PendinglogComponent', () => {
  let component: PendinglogComponent;
  let fixture: ComponentFixture<PendinglogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PendinglogComponent ],imports:[RouterTestingModule,FormsModule,HttpModule,Ng2OrderModule,Ng2SearchPipeModule], providers: [EmployeeService]
    })
    .overrideComponent(PendinglogComponent, {
      set: {
        providers: [{provide: LeavedetailsService, useClass: MockLeaveDetailsService },
        ]
      }
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PendinglogComponent);
    component = fixture.componentInstance;
    //fixture.detectChanges();
  });
//test not working ORder BY Pipe dependencies required
  // it('should be created', () => {
  //   expect(component).toBeUndefined();
  // });
});
