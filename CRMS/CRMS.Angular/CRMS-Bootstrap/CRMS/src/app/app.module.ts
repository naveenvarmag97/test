import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DataTableModule } from 'angular2-datatable';
import { MatmoduleModule } from './matmodule.module';
import { AmazingTimePickerModule } from 'amazing-time-picker'; // this line you need
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CoreModule } from './core/core.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { AppRoutingModule } from './app-routing.module';
import { LoginModule } from './login/login.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import { BookingComponent } from './booking/booking.component';
import { HistoryComponent } from './history/history.component';
import { ReportsComponent } from './reports/reports.component';
import { RoomtypeComponent } from './roomtype/roomtype.component';
import { RegisterComponent } from './register/register.component';
import { RegisterModule } from './register/register.module';
import { ReportsModule } from './reports/reports.module';
import { RoomtypeModule } from './roomtype/roomtype.module';
import { HistoryModule } from './history/history.module';
import { DashboardModule } from './dashboard/dashboard.module';
import { BookingModule } from './booking/booking.module';
import { RoomComponent } from './room/room.component';
import { RoomModule } from './room/room.module';
import { RoomformComponent } from './room/roomform/roomform.component';
import { RoomformModule } from './room/roomform/roomform.module';
import { BookingformModule } from './booking/bookingform/bookingform.module';
import { BookingformComponent } from './booking/bookingform/bookingform.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    BookingComponent,
    HistoryComponent,
    ReportsComponent,
    RoomtypeComponent,
    RegisterComponent,
    RoomComponent,
    RoomformComponent,
    BookingformComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    NgbModule.forRoot(),
    BrowserAnimationsModule,
    ToastrModule.forRoot(), // ToastrModule added
    MatmoduleModule,
    DataTableModule,
    AmazingTimePickerModule,
    CoreModule,
    LoginModule,
    RegisterModule,
    ReportsModule,
    RoomtypeModule,
    HistoryModule,
    DashboardModule,
    BookingModule,
    RoomModule,
    RoomformModule,
    BookingformModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
