import { TestBed, async } from '@angular/core/testing';
import { Http } from '@angular/http';
import { MockBackend } from '@angular/http/testing';
import {
  RouterTestingModule
} from '@angular/router/testing';
//import { LeaveDetailsService } from './leave-details.service';
//import { MockLeaveDetailsService } from './leave-details.service.spec';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { Employee } from './employee/employee';
import { EmployeeService } from './employee/employee.service';
import { LeaveDetails } from './leavedetails';
import {LeavedetailsService} from './leavedetails.service'
// import { Employee } from './employee';
// import { EmployeeService } from './employee.service';

class MockEmployeeService {
  getEmployees(): Promise<Employee[]> {
    console.log('Mock getEmployees called');
    return Promise.resolve([new Employee(1000,"Anuj Pancholi","anujpachOO@gmail.com",3152441590,1000,"Higher Management",24,'1999-05-12',"url")]);
  }
}
class MockLeaveDetailsService {
  getEmployees(): Promise<LeaveDetails[]> {
    console.log('Mock getEmployees called');
    return Promise.resolve([new LeaveDetails(1000,1,"2018-07-20","2018-07-22","2018-07-17",3,"EL","sick","Pending","gggggggggg")]);
  }
}
class MockLeavedetailsService {
  getEmployees(): Promise<LeaveDetails[]> {
    console.log('Mock getEmployees called');
    return Promise.resolve([new LeaveDetails(1000,1,"2018-07-20","2018-07-22","2018-07-17",3,"EL","sick","Pending","gggggggggg")]);
  }
}


describe('AppComponent', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent
      ],
      imports: [ RouterTestingModule, FormsModule ]
    }).overrideComponent(AppComponent, {
      set: {
        providers: [
          {provide: EmployeeService, useClass: MockEmployeeService },
           {provide: EmployeeService, useClass: MockEmployeeService },
           {provide: LeavedetailsService, useClass: MockLeavedetailsService },
        ]
        
      }
    }).compileComponents();
    
  }));


  it('should create the app', async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  }));

  it(`should have as title 'app'`, async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.title).toEqual('Leave Management Application');
  }));

  it('should render title in a h1 tag', async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    // fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('li').textContent).toContain('Home');
  }));

  it('should render one employee record', async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    // fixture.detectChanges();
    fixture.whenStable().then(() => {
      // fixture.detectChanges();
      const compiled = fixture.debugElement.nativeElement;
      expect(compiled.querySelectorAll('.employees tr').length).toBe(0);
    });
  }));
});
