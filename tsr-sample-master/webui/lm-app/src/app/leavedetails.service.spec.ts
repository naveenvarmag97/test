import { TestBed, inject } from '@angular/core/testing';
import { LeavedetailsService } from './leavedetails.service';
import { HttpModule} from '@angular/http';
import { HttpClient } from '@angular/common/http';
import { MockBackend } from '@angular/http/testing';
import { EmployeeService } from './employee/employee.service';
import { LeaveDetails } from './leavedetails';
// //import {HttpTestingController} from '@angular/http/testing';
// import {HttpClientTestingModule} from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import {
  RouterTestingModule
} from '@angular/router/testing';
class MockLeavedetailsService {
  getEmployees(): Promise<LeaveDetails[]> {
    console.log('Mock getEmployees called');
    return Promise.resolve([new LeaveDetails(1000,1,"2018-07-20","2018-07-22","2018-07-17",3,"EL","sick","Pending","gggggggggg")]);
  }
}

describe('LeaveDetailsService', () => {
  describe ('LeaveDetailsService (with spies)', () => {
    let httpClientSpy: { get: jasmine.Spy };
    let leaveDetailsService: LeavedetailsService;
  beforeEach(() => {
    httpClientSpy = jasmine.createSpyObj('HttpClient', ['get']);
    leaveDetailsService = new LeavedetailsService(<any> httpClientSpy);
    TestBed.configureTestingModule({
      providers: [LeavedetailsService], imports:[HttpModule]
    });
  });
  it('should be created', inject([LeavedetailsService], (service: LeavedetailsService) => {
    expect(service).toBeTruthy();
  }));
  });});
  describe('LeaveDetails Service check', () => {
    let httpClient: HttpClient;
    let httpTestingController: HttpTestingController;
    let leaveDetailsService: LeavedetailsService;
  
    beforeEach(() => {
      TestBed.configureTestingModule({
        // Import the HttpClient mocking services
        imports: [ HttpClientTestingModule, HttpModule ],
        // Provide the service-under-test
        providers: [ LeavedetailsService ]
      });
  
      // Inject the http, test controller, and service-under-test
      // as they will be referenced by each test.
      httpClient = TestBed.get(HttpClient);
      httpTestingController = TestBed.get(HttpTestingController);
      leaveDetailsService= TestBed.get(LeavedetailsService);
    });
    afterEach(() => {
      // After every test, assert that there are no more pending requests.
      httpTestingController.verify();
    });
    it('should compare LeaveDetailsByLeaveId by Id ', () => {
      const empId = 2;
      let expectedDetails: LeaveDetails;
      expectedDetails = new LeaveDetails(1000,2, "2019-06-24", "2019-06-25", "2019-06-21",  2,"SICK", "EL", "PENDING",
      "APP") as LeaveDetails;
       leaveDetailsService.getLeaveDetailsByLeaveId(empId).then(
        data => expect(data).toEqual(expectedDetails, 'should return the LeaveDetails By leave ID'),
        fail
      )});
      
  });
//   it('should be created', inject([LeavedetailsService], (service: LeavedetailsService) => {
//      expect(service).toBeTruthy();
//    }));
// });

