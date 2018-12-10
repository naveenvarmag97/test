import { Component, OnInit} from '@angular/core';
import { LeavedetailsService } from '../leavedetails.service';
import { EmployeeService } from '../employee/employee.service';
import { LeaveDetails } from '../leavedetails';
import { Router,RouterModule,ActivatedRoute} from '@angular/router';
import { FormsModule } from '@angular/forms';
import { Employee } from '../employee/employee';
import { Ng2SearchPipeModule } from 'ng2-search-filter';


@Component({
  selector: 'app-pendinglog',
  templateUrl: './pendinglog.component.html',
  styleUrls: ['./pendinglog.component.css'],
   providers: [ EmployeeService ,LeavedetailsService]
})
export class PendinglogComponent implements OnInit {
  empNme:String;
  empId:number;
  empName:String;
  empLeaveBalance1:number;
  empLeaveBalance:number;
  employees:Employee[];
  title="Leave Management Application";
  leavePending:LeaveDetails[];
  leaveDetailsByLeaveId:number;
  buttonApproveDeny:boolean=true;
  approveLeaveId:number;
  leavePendingRevisit:LeaveDetails[];
  //selectedRowIndex: number = -1;
  leaveIdSelect:number;
//uniqueEmpUnderManager:number[];
  k:number=0;
  leave:number;
  choice:number;
  managerComments:String;
  filter:number;
  key: any;
  reverse: boolean = false;

  constructor(private leavedetailsService: LeavedetailsService, private router: Router,private employeeService: EmployeeService,private route: ActivatedRoute) { 
    this.empId=this.route.snapshot.params['empId'];
    }
   
 
  
    
    getPendingLeaveUnderManagerr(empId:number): void {
      //this.empId;
      console.log("empppp",empId);
      this.leavedetailsService.getPendingLeaveUnderManager(empId).then(leavePending =>{
        console.log('getpending promise resolve :'+leavePending.length);
        this.leavePending=leavePending;

        console.log("ld",leavePending)
        this.getEmpName(empId); 
        
      });
  
      
    }
    // getEmpName(empId : number) :String{
    //   return this.getEmpNameApi(empId);
    // }



    // getEmpNameApi(empId : number) :String{
    //   console.log("empId",empId);
    //   this.employeeService.getSpecificEmployees
    //   (empId).then(employees => {
    //     console.log('getEmployeeName promise resolved : ' + employees);
    //     this.employees = employees;
    //   }
    // );
   
    // return this.employees.empName;
     
    // }
   getEmpName(empId:number) :void{
    
      this.employeeService.  getEmployees().then(employees => {
        console.log('getEmployeeName promise resolved : ' + employees);
        this.employees = employees;
        console.log("ayaaaa",this.employees);
        console.log("ayaaaa empId",this.empId);

        this.empIdforTable();
      }
      ); 
    }
    findEmpName(empId:number): String{
      for (var _i = 0; _i <  this.employees.length; _i++) {
        //this.empNme=null;
        if(empId==this.employees[_i].empId){
          this.empNme=this.employees[_i].empName;
          break;
        }
      }
      return this.empNme;
      
    }
    
    findEmpLeaveBalance(empId:number): number{
      for (var _i = 0; _i < this.employees.length;_i++) {
        if(empId==this.employees[_i].empId){
          this.empLeaveBalance1=this.employees[_i].empLeaveBalance;
          break;
        }
      }
      return this.empLeaveBalance1;
    }
    
    ngOnInit(): void{
      //this.empIdforTable(this.empId);
      this.getPendingLeaveUnderManagerr(this.empId);
      this.getEmpName(this.empId);   
    }
  //  goToApproveDeny(i:number):void{
  //    console.log("isndie approve denyu");
  //   this.leaveDetailsByLeaveId = this.leavePending[i].leaveId;
  //   console.log("helloooo",this.leaveDetailsByLeaveId);
  //   this.router.navigate(['/approve',this.leaveDetailsByLeaveId,this.empId]);
  //  }
   onSelect(selectedItemFromTable:any):void{
     console.log("selected item",this.leavePending[selectedItemFromTable].leaveId);
     this.approveLeaveId=this.leavePending[selectedItemFromTable].leaveId

      if(this.leavePending[selectedItemFromTable].leaveId) {
        this.buttonApproveDeny = false;
        console.log("button value",this.buttonApproveDeny);
      }
    }
    goToApproveDeny1():void{
      console.log("isndie approve denyu");
     console.log("helloooo",this.approveLeaveId);
     this.router.navigate(['/approve',this.approveLeaveId,this.empId]);
    }
   
    selectRow(event:any, leavepending:any) {
    this.leaveIdSelect = leavepending.leaveId;
  }
  empIdforTable():number[]{
    console.log("insiede empiD",this.employees);
    console.log("insiede empiD hhhh",this.empId);
    var uniqueEmpUnderManager = [];
    for(var i = 0;i<this.employees.length;i++){
      console.log("swdsd",this.employees[i].empId);
      if(this.employees[i].managerId==this.empId) {
        console.log("iloooop hjhD",this.employees[i].empId);
        uniqueEmpUnderManager.push(this.employees[i].empId);
      }
    }
    console.log("insiede sdhkfhhhhhhjhD",uniqueEmpUnderManager);
    // ;
    return uniqueEmpUnderManager;
  }
  goback() {
    this.router.navigate(['dashboard',this.empId]);
  }
  managerReview(){
    this.router.navigate(['/managerReview',this.empId]);
  }
  sort(key){
    this.key = key;
    this.reverse = !this.reverse;
  }
 
}