import { Component, OnInit } from "@angular/core";
import { User } from "app/models/user";

@Component({
  selector: "app-header",
  templateUrl: "./header.component.html",
  styleUrls: ["./header.component.scss"]
})
export class HeaderComponent implements OnInit {
  currentUser: User;
  
  constructor() {

    this.currentUser = JSON.parse(localStorage.getItem("currentUser"));
    if ( this.currentUser == null){

      this.currentUser = new User("", "");
      this.currentUser.firstname = "Guest";

    }
   }

  ngOnInit() {
    
  }

}
