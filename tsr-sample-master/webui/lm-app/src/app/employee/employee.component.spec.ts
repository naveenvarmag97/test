import { TestBed, inject } from '@angular/core/testing';
import { Http,HttpModule } from '@angular/http';

import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { async, ComponentFixture} from '@angular/core/testing';
import { HttpClient } from '@angular/common/http';
import { EmployeeService } from './employee.service';
import { Employee } from './employee';

describe('Employee Details Service', () => {
  describe ('Employee Details Service(with spies)', () => {
    let httpClientSpy: { get: jasmine.Spy };
    let employeeService: EmployeeService;
  beforeEach(() => {
    httpClientSpy = jasmine.createSpyObj('HttpClient', ['get']);
    employeeService = new EmployeeService(<any> httpClientSpy);
    TestBed.configureTestingModule({
      providers: [EmployeeService], imports:[HttpModule]
    });
  });

  it('should be created', inject([EmployeeService], (service: EmployeeService) => {
    expect(service).toBeTruthy();
  }));
  });
  describe('LeaveHistory', () => {
    let httpClient: HttpClient;
    let httpTestingController: HttpTestingController;
    let leaveDetailsService: EmployeeService;
  
    beforeEach(() => {
      TestBed.configureTestingModule({
        // Import the HttpClient mocking services
        imports: [ HttpClientTestingModule, HttpModule ],
        // Provide the service-under-test
        providers: [ EmployeeService ]
      });
  
      // Inject the http, test controller, and service-under-test
      // as they will be referenced by each test.
      httpClient = TestBed.get(HttpClient);
      httpTestingController = TestBed.get(HttpTestingController);
      leaveDetailsService= TestBed.get(EmployeeService);
    });
  
    afterEach(() => {
      // After every test, assert that there are no more pending requests.
      httpTestingController.verify();
    });
  
  
      it('should compare EmployeeDetails by Id ', () => {
        const empId = 1000;
        let expectedDetails: Employee;
        expectedDetails = new Employee(1000,"Anuj Pancholi","anujpachOO@gmail.com",3152441590,1000,"Higher Management",24,'1999-05-12',"url") as Employee;
         leaveDetailsService.getOneEmployees(empId).then(
          data => expect(data).toEqual(expectedDetails, 'should return the employeeDetails'),
          fail
        )});
        
  
});
  });