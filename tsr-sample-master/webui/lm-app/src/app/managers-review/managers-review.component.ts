import { Component, OnInit} from '@angular/core';
import { LeavedetailsService } from '../leavedetails.service';
import { EmployeeService } from '../employee/employee.service';
import { LeaveDetails } from '../leavedetails';
import { Router,RouterModule,ActivatedRoute} from '@angular/router';
import { FormsModule } from '@angular/forms';
import { Employee } from '../employee/employee';
import { Ng2SearchPipeModule } from 'ng2-search-filter';


@Component({
  selector: 'app-managers-review',
  templateUrl: './managers-review.component.html',
  styleUrls: ['./managers-review.component.css'],
  providers: [ EmployeeService ,LeavedetailsService]

})
export class ManagersReviewComponent implements OnInit {
  leavePendingRevisit:LeaveDetails[];
  //selectedRowIndex: number = -1;
  leaveIdSelect:number;
//uniqueEmpUnderManager:number[];
  k:number=0;
  leave:number;
  choice:number;
  managerComments:String;
  empId:number;
  revisitApprove:boolean=true;
  revisitDeny:boolean=true;
  filter:number;
  key:any;
  reverse: boolean = false;


  constructor(private leavedetailsService: LeavedetailsService, private router: Router,private employeeService: EmployeeService,private route: ActivatedRoute) { 
    this.empId=this.route.snapshot.params['empId'];
    }

  ngOnInit() {
    this.getPendingLeaveUnderManagerRevisit(this.empId);
    
  }
  getPendingLeaveUnderManagerRevisit(empId:number): void {
    //this.empId;
    console.log("empppp",empId);
    this.leavedetailsService.getPendingLeaveUnderManagerRevisit(empId).then(leavePendingRevisit =>{
      console.log('getpending under manager Revisit promise resolve :'+leavePendingRevisit.length);
      this.leavePendingRevisit=leavePendingRevisit;

      console.log("ld",leavePendingRevisit)
      // this.getEmpName(empId); 
      // this.selectReview();
      
      
    });

    
  }
  approveDenyRevisit(i:number):void{
    // this.leaveId = this.leaveIdApprove;
    this.leavePendingRevisit[i].leaveId;
    //console.log(this.leaveIdApprove);
    this.choice = 1;
    this.managerComments = "after Revisit";
    this.leavedetailsService.approveDenyRevisit(this.leavePendingRevisit[i].leaveId,this.choice,this.managerComments)
    .subscribe(data => { 
    alert(data);
    this.router.navigate(['/pendinglog',this.empId]);
  },
   err => {console.log(err)});
   //this.router.navigate[('/approve')];
  }
  DenyRevisit(i:number):void{
    // this.leaveId = this.leaveIdApprove;
    this.leavePendingRevisit[i].leaveId;
    //console.log(this.leaveIdApprove);
    this.choice = 2;
    this.managerComments = "after Revisit denied";
    this.leavedetailsService.approveDenyRevisit(this.leavePendingRevisit[i].leaveId,this.choice,this.managerComments)
    .subscribe(data => { 
    alert(data);
    this.router.navigate(['/pendinglog',this.empId]);
  },
   err => {console.log(err)});
   //this.router.navigate[('/approve')];
  }
  selectReview(i:number):boolean{
    // for(var i=0;i<this.leavePendingRevisit.length;i++){
    if(this.leavePendingRevisit[i].leaveStatus=="APPROVED"){
       return this.revisitApprove=true;

    }
    else{
      return this.revisitDeny=false;;

    }
  }
    selectReviewDeny(i:number):boolean{
      // for(var i=0;i<this.leavePendingRevisit.length;i++){
      if(this.leavePendingRevisit[i].leaveStatus=="DENIED"){
         return this.revisitApprove=true;
  
      }
      else{
        return this.revisitDeny=false;;
  
      }
  // }
  }
  goBack():void{
    this.router.navigate(['/pendinglog',this.empId]);
  }
  sort(key){
    this.key =key ;
    this.reverse = !this.reverse;
  }

}
