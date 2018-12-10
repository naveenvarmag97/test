import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { Http, HttpModule } from '@angular/http';
import { EditLeaveApplyComponent } from './edit-leave-apply.component';
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

describe('EditLeaveApplyComponent', () => {
  let component: EditLeaveApplyComponent;
  let fixture: ComponentFixture<EditLeaveApplyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditLeaveApplyComponent ],
      imports:[FormsModule, RouterTestingModule,HttpModule],
     
      
    }).overrideComponent(EditLeaveApplyComponent, {
      set: {
        providers:[ 
          {provide: LeavedetailsService, useClass: MockLeavedetailsService },
          {provide: EmployeeService, useClass: MockEmployeeService }],

        
      }
    }).compileComponents();
  }));
  // beforeEach(() => {
  //   fixture = TestBed.createComponent(EditLeaveApplyComponent);
  //   component = fixture.componentInstance;
  //   // fixture.detectChanges();
  // });
  // it('should compare employee Details', async(() => {
  //   const fixture = TestBed.createComponent(EditLeaveApplyComponent);
  //   //fixture.detectChanges();
  //   fixture.whenStable().then(() => {
  //    //fixture.detectChanges();
  //     const compiled = fixture.debugElement.nativeElement;
  //     expect(component.getEmployees.length).toBe(0);
  //   });
  // }));

    // it('should be created', () => {
    //   expect(component).toBeTruthy();
    // });
  });


  // it('should be created', () => {
  //   expect(component).toBeTruthy();
  // });



// import { async, ComponentFixture, TestBed } from '@angular/core/testing';

// import { EditLeaveApplyComponent } from './edit-leave-apply.component';

// describe('EditLeaveApplyComponent', () => {
//   let component: EditLeaveApplyComponent;
//   let fixture: ComponentFixture<EditLeaveApplyComponent>;

//   beforeEach(async(() => {
//     TestBed.configureTestingModule({
//       declarations: [ EditLeaveApplyComponent ]
//     })
//     .compileComponents();
//   }));

//   beforeEach(() => {
//     fixture = TestBed.createComponent(EditLeaveApplyComponent);
//     component = fixture.componentInstance;
//     fixture.detectChanges();
//   });

//   it('should be created', () => {
//     expect(component).toBeTruthy();
//   });
// });
