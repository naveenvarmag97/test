import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginFormComponent } from './login-form.component';
import { Router, RouterModule,Routes,ActivatedRoute } from '@angular/router';
describe('LoginFormComponent', () => {
  let component: LoginFormComponent;
  let fixture: ComponentFixture<LoginFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginFormComponent ]
      
    })
    .compileComponents();
  }));

  // beforeEach(() => {
  //   fixture = TestBed.createComponent(LoginFormComponent);
  //   component = fixture.componentInstance;
  //   fixture.detectChanges();
  // });

  // it('should be created', () => {
  //   expect(component).toBeUndefined();
  // });
});
