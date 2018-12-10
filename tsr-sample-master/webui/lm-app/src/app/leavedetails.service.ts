import { Injectable } from '@angular/core';
import { LeaveDetails } from './leavedetails';
import { Metrics } from './metrics';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/toPromise';

import { Http } from '@angular/http';

@Injectable()
export class LeavedetailsService {
 url:string;
  constructor(private http: Http) {
  }
  getLeaveDetails(empId): Promise<LeaveDetails[]>{
    //this.managerComments="hello";
    console.log('getLeaveDetails called on LeaveDetails.service');
        return this.http.get('http://localhost:8070/ftp46/api/employees/'+empId)
        .toPromise()
        .then(response => response.json() as LeaveDetails[])
        .catch(this.handleError);
  }
  approveDeny(leaveId:number, choice:number, managerComments:String):Observable<String> {
    this.url="http://localhost:8070/ftp46/api/leaveDetails/pending/"+leaveId+"/"+choice;
     return this.http.put(this.url,{"managerComments":managerComments})
     .map(response => response.text())
     .catch((error:any) => Observable.throw(error.toString() || 'Server error'));
   }
   getLeaveDetailsByLeaveId(leaveId): Promise<LeaveDetails>{
     console.log('getLeaveDetailsByLeaveId called on LeaveDetails.service');
         return this.http.get('http://localhost:8070/ftp46/api/leaveDetails/leaveId/'+leaveId)
         .toPromise()
         .then(response => response.json() as LeaveDetails)
         .catch(this.handleError);
   }
    getPending(empId): Promise<LeaveDetails[]> {
      console.log('getPending called on leavedetails.service');
      return this.http.get('http://localhost:8070/ftp46/api/leaveDetails/'+ empId)
      .toPromise()
      .then(response => response.json() as LeaveDetails[])
      .catch(this.handleError);
  }
  getPendingLeaveUnderManager(empId): Promise<LeaveDetails[]>{
    console.log('getPendingLeaveunderMangaer called on leavedetails.service');
    return this.http.get('http://localhost:8070/ftp46/api/employees/'+empId)
    .toPromise()
    .then(response => response.json() as LeaveDetails[])
    .catch(this.handleError);
  }
  getLeaveHistory(empId:number) :Promise<LeaveDetails[]>{
    console.log('getPendingLeaveunderMangaer called on leavedetails.service');
    return this.http.get('http://localhost:8070/ftp46/api/leaveDetails/history/'+empId)
    .toPromise()
    .then(response => response.json() as LeaveDetails[])
    .catch(this.handleError);
  }
  doApply(empId:number,startDate:string,endDate:string,reason:string, leaveOption:number):Observable<String>{
    this.url="http://localhost:8070/ftp46/api/leaveDetails/"+empId+"/apply/" +leaveOption;
    return this.http.post(this.url,{"startDate":startDate,"endDate":endDate,"reason":reason})
     .map(response=>response.text())
     .catch((error:any) => Observable.throw(error.toString() || 'Server error'));
 
   }
   doEditApply(empId:number,startDate:string,endDate:string,reason:string,leaveId:number):Observable<String>{
    this.url="http://localhost:8070/ftp46/api/leaveDetails/"+empId+"/Edit/"+leaveId;
    return this.http.post(this.url,{"startDate":startDate,"endDate":endDate,"reason":reason})
     .map(response=>response.text())
     .catch((error:any) => Observable.throw(error.toString() || 'Server error'));
 
   }
   getLatestLeave(empId:number) :Promise<LeaveDetails>{
    console.log('getLatestLeave called on leavedetails.service');
    return this.http.get('http://localhost:8070/ftp46/api/leaveDetails/latestLeave/'+empId)
    .toPromise()
    .then(response => response.json() as LeaveDetails)
    .catch(this.handleError);
  }


  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
}
getLeaveDetailsRevisit(empId): Promise<LeaveDetails[]>{
  //this.managerComments="hello";
  console.log('getLeaveDetailsRevsit Under mabnager called on LeaveDetails.service');
      return this.http.get('http://localhost:8070/ftp46/api/employees/revisit'+empId)
      .toPromise()
      .then(response => response.json() as LeaveDetails[])
      .catch(this.handleError);
}
approveDenyRevisit(leaveId:number, choice:number, managerComments:String):Observable<String> {
  this.url="http://localhost:8070/ftp46/api/leaveDetails/revisit/pending/"+leaveId+"/"+choice;
   return this.http.put(this.url,{"managerComments":managerComments})
   .map(response => response.text())
   .catch((error:any) => Observable.throw(error.toString() || 'Server error'));
 }
 getPendingLeaveUnderManagerRevisit(empId): Promise<LeaveDetails[]>{
  console.log('getPendingLeaveunderMangaer called on leavedetails.service');
  return this.http.get('http://localhost:8070/ftp46/api/employees/revisit/'+empId)
  .toPromise()
  .then(response => response.json() as LeaveDetails[])
  .catch(this.handleError);
}
getLeaveDays(empId:number) :Promise<Metrics>{
  console.log('getLatestLeave called on leavedetails.service');
  return this.http.get('http://localhost:8070/ftp46/api/leaveDetails/days/'+empId)
  .toPromise()
  .then(response => response.json() as Metrics)
  .catch(this.handleError);
}
getNoOfPending(empId:number) :Promise<Metrics>{
  console.log('getLatestLeave called on leavedetails.service');
  return this.http.get('http://localhost:8070/ftp46/api/leaveDetails/pendingcount/'+empId)
  .toPromise()
  .then(response => response.json() as Metrics)
  .catch(this.handleError);
}
getNoOfAppliedLeaves(empId:number) :Promise<Metrics>{
  console.log('getLatestLeave called on leavedetails.service');
  return this.http.get('http://localhost:8070/ftp46/api/leaveDetails/applied/'+empId)
  .toPromise()
  .then(response => response.json() as Metrics)
  .catch(this.handleError);
}
}






//     getEmployees(): Promise<Employee[]> {
//         console.log('getEmployees called on employee.service');
//         return this.http.get('http://localhost:8070/ftp46/api/employees')
//         .toPromise()
//         .then(response => response.json() as Employee[])
//         .catch(this.handleError);
//     }

//     private handleError(error: any): Promise<any> {
//         console.error('An error occurred', error); // for demo purposes only
//         return Promise.reject(error.message || error);
//     }
// }
