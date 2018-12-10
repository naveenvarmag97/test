import { Component, OnInit } from '@angular/core';
import { LeavedetailsService } from '../leavedetails.service';
import { LeaveDetails } from '../leavedetails';
import { Router,RouterModule ,ActivatedRoute} from '@angular/router';
import { FormsModule } from '@angular/forms';



@Component({
  selector: 'app-pending',
  templateUrl: './pending.component.html',
  styleUrls: ['./pending.component.css'],
  providers: [ LeavedetailsService ]
})
export class PendingComponent implements OnInit {
empId : number;
title:string="Pending Details";

  constructor(private leavedetailsService: LeavedetailsService, private router: Router,private route: ActivatedRoute) { 
    this.empId=this.route.snapshot.params['empId'];
  }
 
  leavePending:LeaveDetails[];
  
  getPendingLeave(empId): void {
    //this.empId;
    console.log("ellllll",empId);
    this.leavedetailsService.getPending(this.empId).then(leavePending =>{
      console.log('getpending promise resolve :'+leavePending.length);
      this.leavePending=leavePending;
      console.log("ellllll", this.leavePending);
    });
  }
  
  
  ngOnInit(): void{
    this.getPendingLeave(this.empId);
  }
  onback() {
    this.router.navigate(['dashboard',this.empId]);
  }
   goToEditLeave(i:number) {
    
    this.router.navigate(['editLeave',this.empId, this.leavePending[i].leaveId,this.leavePending[i].startDate,this.leavePending[i].endDate]);
  }
}

