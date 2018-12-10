import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Http } from '@angular/http';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

// import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-roomform',
  templateUrl: './roomform.component.html',
  styleUrls: ['./roomform.component.css']
})
export class RoomformComponent implements OnInit {
  roomTypeList: any;
  roomForm: FormGroup;
  isAddForm = true;
  constructor(private formBuilder: FormBuilder,
    private http: Http,
    private toast: ToastrService,
    private router: Router, private route: ActivatedRoute, ) { }

  ngOnInit() {
    this.createForm();
    this.initBindControls();

    this.route.params.subscribe(
      (params: Params) => {
        console.log(params);
        if (params && params.id) {
          this.isAddForm = false;
          this.roomForm.setValue({
            id: params.id,
            name: params.name,
            location: params.location,
            capacity: params.capacity,
            roomTypeId: params.roomTypeId,
            isActive: params.isActive,
            creationTs: params.creationTs,
            createdBy: params.createdBy,
            statusType: params.statusType
          });
        }

      }
    );

  }



  save() {
    console.log(this.roomForm.value);
    this.http.post('room/Save', this.roomForm.value).subscribe(res => {
      if (this.isAddForm) {
        this.toast.success('Added Successfully!!!');
      } else {
        this.toast.success('Updated Successfully!!!');
      }

      this.router.navigate(['/room'], { replaceUrl: true });
    });
  }

  initBindControls() {
    this.http.get('roomtype/GetRoomTypes')
      .map(res => res.json())
      .subscribe((data) => {
        this.roomTypeList = data;
        console.log(this.roomTypeList);
      });
  }

  private createForm() {
    this.roomForm = this.formBuilder.group({
      id: 0,
      name: ['', Validators.required],
      location: ['', Validators.required],
      capacity: ['', Validators.required],
      roomTypeId: ['', Validators.required],
      isActive: ['', Validators.required],
      creationTs: Date,
      createdBy: '',
      // modifiedTs: Date,
      // modifiedBy: '',
       statusType: Number
    });
  }
}
