import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-room',
  templateUrl: './room.component.html',
  styleUrls: ['./room.component.css']
})
export class RoomComponent implements OnInit {
  constructor(private http: Http, private router: Router, private toast: ToastrService) { }
  roomslist;

  public data;
  public filterQuery = '';
  public rowsOnPage = 4;
  public sortBy = 'id';
  public sortOrder = 'desc';

  ngOnInit() {

    this.bindRoomsGrid();
  }

  bindRoomsGrid() {
    this.http
      .get('room/GetRooms')
      .map(res => res.json())
      .subscribe((data) => {
        this.roomslist = data;
      });
  }

  refresh() {
    this.roomslist = [];
    this.bindRoomsGrid();
  }

  edit(room) {
    console.log(room);
    this.router.navigate(['/room/form', { roomId: room.Id }], { replaceUrl: true });
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

