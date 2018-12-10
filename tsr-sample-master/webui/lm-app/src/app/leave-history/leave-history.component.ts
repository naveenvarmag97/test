import { Component, OnInit } from '@angular/core';
import{LeaveDetails} from '../leavedetails';
import {Router, RouterModule,Routes,ActivatedRoute} from '@angular/router';
//import { EmployeeService } from '../employee/employee.service';
import{LeavedetailsService} from '../leavedetails.service'
import { Ng2SearchPipeModule } from 'ng2-search-filter';

@Component({
  selector: 'app-leave-history',
  templateUrl: './leave-history.component.html',
  styleUrls: ['./leave-history.component.css'],
  providers: [ LeavedetailsService]
})
export class LeaveHistoryComponent implements OnInit {
  emp:number;
  title:string="Leave Details";
  leaveHistory:LeaveDetails[];
  filter:number;
  constructor(private route:ActivatedRoute ,private router: Router,private leaveService: LeavedetailsService) { this.emp=this.route.snapshot.params['empId'];}
  getHistory(): void {
    console.log("ssss",this.emp);
    this.leaveService.getLeaveHistory(this.emp).then(leaveHistory => {
      console.log('getEmployees promise resolved : ' + leaveHistory);
      this.leaveHistory = leaveHistory;
    }
  );
}
test():string{
  return "testing";
}
  ngOnInit() {
    this. getHistory();
  }
  onback() {
    this.router.navigate(['dashboard',this.emp]);
  }

}


