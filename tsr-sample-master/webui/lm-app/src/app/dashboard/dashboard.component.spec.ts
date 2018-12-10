import { HttpClient } from '@angular/common/http';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { FormGroup, FormControl,Validators,FormsModule,ReactiveFormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { Http,HttpModule } from '@angular/http';

import { DashboardComponent } from './dashboard.component';
import { EmployeeService } from '../employee/employee.service';


describe('DashboardComponent', () => {
  let component: DashboardComponent;
  let fixture: ComponentFixture<DashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DashboardComponent ],
      providers: [ EmployeeService, ],
      imports:[RouterTestingModule,FormsModule,HttpModule,HttpClient]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DashboardComponent);
    component = fixture.componentInstance;
    //fixture.detectChanges();
  });

  // it('should be created', () => {
  //   expect(component).toBeTruthy();
  // });
});
