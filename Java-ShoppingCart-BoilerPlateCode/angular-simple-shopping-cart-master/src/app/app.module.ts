import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
//import { HttpModule } from "@angular/http";
import { BrowserModule } from "@angular/platform-browser";

import { Http } from "@angular/http";
import { BrowserAnimationsModule, NoopAnimationsModule } from "@angular/platform-browser/animations";
import { AppComponent } from "./app.component";
import { AppRoutingModule } from "./app.routing";

import { HeaderComponent } from "./components/header/header.component";


import { StoreFrontComponent } from "./components/store-front/store-front.component";

import { ProductsDataService } from "./services/products.service";

import { HTTP_INTERCEPTORS } from "@angular/common/http";
//import { HttpXsrfInterceptor } from "./services/HttpXsrfInterceptor";
import { HttpClientModule } from "@angular/common/http";
import { HttpClient } from "@angular/common/http";
import { HttpClientXsrfModule } from "@angular/common/http";
import { HttpModule } from "@angular/http";


@NgModule({
  bootstrap: [AppComponent],
  declarations: [
    AppComponent,

    StoreFrontComponent,

    HeaderComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    NoopAnimationsModule,
    FormsModule,
    HttpModule,
    AppRoutingModule,
    HttpClientModule,  
    HttpClientXsrfModule.withOptions({
      cookieName: 'XSRF-TOKEN', // this is optional
      headerName: 'XSRF-TOKEN' // this is optional
    })
  ] 
  ,
  providers: [
    ProductsDataService,



  ]
})
export class AppModule { }
