import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AuthcredentialstoreService } from '../core/authentication/authcredentialstore.service';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

  constructor(private http: Http, private router: Router, private toast: ToastrService, private authstore: AuthcredentialstoreService) { }
  bookings;

  public data;
  public filterQuery = '';
  public rowsOnPage = 10;
  public sortBy = 'id';
  public sortOrder = 'desc';
  private isFacultyManager;
  userid;

  ngOnInit() {
    this.isFacultyManager = this.authstore.isFacultyManager();
    this.userid = this.authstore.credentials.userid;

    this.bindBookingsGrid();
  }

  bindBookingsGrid() {
    if (this.isFacultyManager) {
      this.http
        .get('booking/getbookings')
        .map(res => res.json())
        .subscribe((data) => {
          this.bookings = data;
        });
    } else {
      this.http
        .get('booking/GetBookingsByUser?userId=' + this.userid)
        .map(res => res.json())
        .subscribe((data) => {
          this.bookings = data;
        });
    }
  }

  refresh() {
    this.bookings = [];
    this.bindBookingsGrid();
  }

  cancelBooking(booking) {
    
      // Cancel Booking
      console.log(booking);
      this.http.put('booking/CancelBooking', booking).subscribe(res => {
        this.toast.success('Booking Cancelled!!');
        this.refresh();
      });
    
  }

  delete(deleteitem) {
    console.log(deleteitem);
    if (confirm('Are you sure to delete \'' + deleteitem.name + '\' ?')) {
      this.http
        .delete('room/delete?id=' + deleteitem.id)
        .subscribe((data) => {
          this.toast.success('Deleted Successfully!!!');
          this.refresh();
        });
    }
  }

  public toInt(num: string) {
    return +num;
  }

  public sortByWordLength = (a: any) => {
    return a.city.length;
  }

}
