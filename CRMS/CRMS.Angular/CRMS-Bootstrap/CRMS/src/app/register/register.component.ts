import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { Http } from '@angular/http';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  error: string = null;
  registerForm: FormGroup;
  isLoading = false;

  constructor(private formBuilder: FormBuilder,
    private http: Http,
    private toast: ToastrService,
    private router: Router, ) { }

  ngOnInit() {
    this.createForm();
  }

  register() {
    console.log(this.registerForm.value);
    this.http.post('account/RegisterUser', this.registerForm.value).subscribe(res => {
      console.log(res);
      this.toast.success('Registered Successfully!!!');
      this.router.navigate(['/login'], { replaceUrl: true });
    });
  }

  private createForm() {
    this.registerForm = this.formBuilder.group({
      empid: ['', Validators.required],
      firstname: ['', Validators.required],
      lastname: ['', Validators.required],
      userType: ['', Validators.required],
      email: ['', Validators.required],
      password: ['', Validators.required],
      confirmPassword: ['', Validators.required],
      phoneNumber: ['', Validators.required],
      empAddress: ['', Validators.required],
    });
  }

}
