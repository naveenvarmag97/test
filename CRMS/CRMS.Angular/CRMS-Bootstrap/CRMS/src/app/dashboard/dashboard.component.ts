import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { Router } from '@angular/router';
import { AuthcredentialstoreService } from '../core/authentication/authcredentialstore.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  userid: string;
  bookings: any[];

  upcomingBookings: any[];
  cancelledBooking: any[];
  bookingHistory: any[];

  private isFacultyManager;

  constructor(private http: Http, private router: Router, private authstore: AuthcredentialstoreService) { }

  ngOnInit() {
    this.isFacultyManager = this.authstore.isFacultyManager();
    this.userid = this.authstore.credentials.userid;

    this.upcomingBookings = [];
    this.cancelledBooking = [];
    this.bookingHistory = [];


    if (this.isFacultyManager) {
      this.loadFacilityManagerDashboard();
    } else {
      this.loadEmployeeDashboard();
    }
  }

  loadFacilityManagerDashboard() {
    this.http
      .get('booking/GetCurrentMonthBookings')
      .map(res => res.json())
      .subscribe((data) => {
        this.bookings = data;
        this.applyfilters(data);
      });
  }

  loadEmployeeDashboard() {
    this.http
      .get('booking/GetCurrentMonthBookings?userId=' + this.userid)
      .map(res => res.json())
      .subscribe((data) => {
        this.bookings = data;
        this.applyfilters(data);
      });
  }

  applyfilters(allbookings) {
    console.log(allbookings);
    this.upcomingBookings = allbookings.filter(d => new Date(d.startDateTs) > new Date() && !d.isCancelled);
    this.cancelledBooking = allbookings.filter(d => d.isCancelled);
    this.bookingHistory = allbookings.filter(d => new Date(d.startDateTs) < new Date());

    console.log(this.upcomingBookings);
  }
}
