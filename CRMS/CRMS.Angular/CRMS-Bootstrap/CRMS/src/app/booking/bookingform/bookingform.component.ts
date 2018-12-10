import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { ActivatedRoute, Router, Params } from '@angular/router';
import { Http } from '@angular/http';
import { ToastrService } from 'ngx-toastr';
import * as moment from 'moment';
import { AuthcredentialstoreService } from '../../core/authentication/authcredentialstore.service';
import { ValidateDateRange } from './booking-validator';
import { Observable } from 'rxjs/Observable';
import { startWith, map } from 'rxjs/operators';

@Component({
  selector: 'app-bookingform',
  templateUrl: './bookingform.component.html',
  styleUrls: ['./bookingform.component.css']
})
export class BookingformComponent implements OnInit {

  roomList: any;
  bookingForm: FormGroup;
  isAddForm = true;
  mindate = new Date();
  errors = [];
  filteredOptions: Observable<any[]>;
  roomControl: FormControl = new FormControl();
  filteredRoomList: any[];


  constructor(private formBuilder: FormBuilder,
    private http: Http,
    private toast: ToastrService,
    private router: Router, private route: ActivatedRoute, private authstore: AuthcredentialstoreService) { }

  ngOnInit() {
    this.createForm();
    this.initBindControls();
    this.roomControl.valueChanges.subscribe(newValue => {
      this.filteredRoomList = this.filter(newValue);
    });
  }

  filter(val: string): any[] {
    return this.roomList.filter(room =>
      room.value.toLowerCase().indexOf(val.toString().toLowerCase()) > -1);
  }

  displayFn(room?: any): string | undefined {
    return room ? room.value : undefined;
  }

  formatDatetime(datestr, timestr) {
    const dateformated = moment(datestr).format('DD/MM/YYYY');
    // var timeformated = moment(timestr).format('HH:mm');
    const datetime = moment(dateformated + ' ' + timestr, 'DD/MM/YYYY HH:mm');
    return datetime.format('YYYY/MM/DD HH:mm');
  }


  save() {
    console.log(this.bookingForm.value);
    console.log(this.roomControl.value);
    const formvalue = this.bookingForm.value;
    const bookingData = {
      startDateTs: this.formatDatetime(formvalue.startDate, formvalue.startTime),
      endDateTs: this.formatDatetime(formvalue.endDate, formvalue.endTime),
      roomId: this.roomControl.value.key,
      userId: this.authstore.credentials.userid
    };

    console.log(bookingData);
    this.http.post('booking/Save', bookingData).subscribe((res) => {
      this.toast.success('Room booked Successfully!!!');
      this.router.navigate(['/booking'], { replaceUrl: true });
    }, (err) => {
      const error = err.json();
      this.handleException(error);
      // if (error.exceptionMessage.indexOf("room is not available")) {
      //   this.toast.error(error.exceptionMessage);
      // }
    });
  }

  handleException(error) {
    if (error.exceptionMessage) {
      // Unhandled Exception
      this.toast.error(error.exceptionMessage);
    } else if (error.modelState) {
      // console.log(JSON.parse(error.text()));
      for (const propname of Object.keys(error.modelState)) {
        this.errors.push(error.modelState[propname]);
      }
    } else {
      console.log(error);
    }
  }

  onFormMouseLeave(event) {
    console.log(event);
    this.errors = [];
  }
  initBindControls() {
    this.http.get('room/GetRoomsLookup')
      .map(res => res.json())
      .subscribe((data) => {
        this.roomList = data;
        console.log(this.roomList);
        this.filteredRoomList = this.roomList;

      });
  }

  private createForm() {
    this.bookingForm = this.formBuilder.group({
      id: 0,
      roomId: ['', Validators.required],
      startDate: ['', Validators.required],
      startTime: ['', Validators.required],
      endDate: ['', Validators.required],
      endTime: ['', Validators.required],
      creationTs: Date,
      createdBy: '',
      statusType: Number
    });
  }

  dateLessThan(from: string, to: string) {
    return (group: FormGroup): { [key: string]: any } => {
      const f = group.controls[from];
      const t = group.controls[to];
      if (f.value > t.value) {
        return {
          dates: 'Date from should be less than Date to'
        };
      }
      return {};
    };
  }
}
