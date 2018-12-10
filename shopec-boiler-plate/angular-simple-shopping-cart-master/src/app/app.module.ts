import { NgModule } from "@angular/core";
//import { HttpModule } from "@angular/http";

import { AppComponent } from "./app.component";
import { BrowserModule } from '@angular/platform-browser';



@NgModule({
  bootstrap: [AppComponent],
  declarations: [
    AppComponent,
  ],
  imports: [ BrowserModule,] 
  ,
  providers: [
  ]
})
export class AppModule { }
