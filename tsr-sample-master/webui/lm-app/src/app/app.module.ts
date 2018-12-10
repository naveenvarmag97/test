import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { EmployeeComponent } from './employee/employee.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { Router, RouterModule,Routes } from '@angular/router';
import { PendinglogComponent } from './pendinglog/pendinglog.component'; 
import { EmployeeService } from './employee/employee.service';
import{LeaveHistoryComponent} from './leave-history/leave-history.component';
import { LeavedetailsService } from './leavedetails.service';
//import { LeavedetailsComponent } from './leavedetails/leavedetails.component';
import { PendingComponent } from './pending/pending.component';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import {AppRoutingModule} from './app-routing.module';
import{EmployeeDetailsComponent} from './employee-details/employee-details.component';
import { ManagerDetailsComponent } from './manager-details/manager-details.component';
import { ApplyLeaveComponent } from './apply-leave/apply-leave.component';
import { ApproveDenyComponent } from './approve-deny/approve-deny.component';
import { ManagersReviewComponent } from './managers-review/managers-review.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { EditLeaveApplyComponent } from './edit-leave-apply/edit-leave-apply.component';
//import { ChatModule } from './chat/chat.module';
import * as $ from 'jquery';
//import { GaugeModule } from 'angular-gauge';
import { Ng2OrderModule } from 'ng2-order-pipe';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeComponent,
    LoginFormComponent,
    DashboardComponent,
    PendinglogComponent,
    //LeavedetailsComponent,
    PendingComponent,
    LeaveHistoryComponent,
    EmployeeDetailsComponent,
    DashboardComponent,
    ManagerDetailsComponent,
    ApplyLeaveComponent,
    ApproveDenyComponent,
    ManagersReviewComponent,
    EditLeaveApplyComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    HttpModule,
    AppRoutingModule,
    HttpClientModule,
    Ng2SearchPipeModule,
    //ChatModule,
    Ng2OrderModule

    
  ],
  providers: [EmployeeService,LeavedetailsService],
  bootstrap: [AppComponent]
})

export class AppModule { }
