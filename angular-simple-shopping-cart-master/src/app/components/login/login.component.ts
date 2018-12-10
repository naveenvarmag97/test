import { Component, OnInit, ViewEncapsulation  } from "@angular/core";
import {Router} from "@angular/router";
import { User } from "app/models/user";
import { LoginService } from "app/services/login.service";
import { ShoppingCartService } from "app/services/shopping-cart.service";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.scss"],
  encapsulation: ViewEncapsulation.None

})
export class LoginComponent implements OnInit {

  private user: User = new User();
  errorMessage: string;
  
  constructor(private loginS: LoginService, private router: Router, private shoppingCartService: ShoppingCartService) {}

  ngOnInit() {
    this.shoppingCartService.empty();
  }
  onLogin(): void {
    this.loginS.login(this.user)
    .subscribe((data) => {
      this.router.navigate(["/home"]);
      }, (err) => {
      this.errorMessage = "error :  Username or password is incorrect";
      }
    );

  }

}
