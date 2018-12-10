import { Component, OnInit } from "@angular/core";
import { User } from "app/models/user";

@Component({
  selector: "app-header",
  templateUrl: "./header.component.html",
  styleUrls: ["./header.component.scss"]
})
export class HeaderComponent implements OnInit {
 // currentUser: User;
  currentUser: string;
  constructor() {

   
      this.currentUser = "Guest";

    
   }

  ngOnInit() {
    
  }

}
