import { Router, RouterModule,Routes } from '@angular/router'; 
import { NgModule } from '@angular/core';
import { EmployeeComponent } from './employee/employee.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { PendinglogComponent } from './pendinglog/pendinglog.component';
import { PendingComponent } from './pending/pending.component';
import{ManagerDetailsComponent} from './manager-details/manager-details.component';

import { DashboardComponent } from './dashboard/dashboard.component';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';
import { LeaveHistoryComponent } from './leave-history/leave-history.component';
import{ApplyLeaveComponent} from './apply-leave/apply-leave.component';
import { ApproveDenyComponent } from './approve-deny/approve-deny.component';
import { ManagersReviewComponent } from './managers-review/managers-review.component';
import {EditLeaveApplyComponent} from './edit-leave-apply/edit-leave-apply.component';
//import { ChatDialogComponent } from './chat/chat-dialog/chat-dialog.component';
 
const routes : Routes = [
    {
        path:'login/:emp' , component :LoginFormComponent
    },
    // {
    //     path:'chatbot' , component :ChatDialogComponent
    // },

     {   path:'pendinglog/:empId' ,component :PendinglogComponent
     },
     {   path:'pendinglog' ,component :PendinglogComponent
    },
    {
        path:'editLeave/:empId/:leaveId/:startDate/:endDate' , component :EditLeaveApplyComponent
    },
    {
        path:'pending/:empId' ,component :PendingComponent
    },
    { path:'employees' ,component :EmployeeComponent
    },
    {
        path:'dashboard/:empId' , component :DashboardComponent
    },
    {
        path:'empDetails/:empId' , component :EmployeeDetailsComponent
    },
    {
        path:'leavedetails/:empId' , component :LeaveHistoryComponent
    },
    {
        path:'manager/:empId' , component :ManagerDetailsComponent
    },
    {
        path:'applyLeave/:empId' , component :ApplyLeaveComponent
    },
    {
        path:'approve/:leaveId/:empId' , component :ApproveDenyComponent
    },
    {
        path:'managerReview/:empId' , component :ManagersReviewComponent
    },
]
@NgModule({
    imports : [RouterModule.forRoot(routes)],
    exports :[RouterModule]
})
export class AppRoutingModule{

}