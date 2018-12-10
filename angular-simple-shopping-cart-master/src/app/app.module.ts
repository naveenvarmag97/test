import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
//import { HttpModule } from "@angular/http";
import { BrowserModule } from "@angular/platform-browser";

import { Http } from "@angular/http";
import { BrowserAnimationsModule, NoopAnimationsModule } from "@angular/platform-browser/animations";
import { AppComponent } from "./app.component";
import { AppRoutingModule } from "./app.routing";
import { CheckoutComponent } from "./components/checkout/checkout.component";
import { HeaderComponent } from "./components/header/header.component";
import { LoginComponent } from "./components/login/login.component";
import { OrderConfirmationComponent } from "./components/order-confirmation/order-confirmation.component";
import { ShoppingCartComponent } from "./components/shopping-cart/shopping-cart.component";
import { StoreFrontComponent } from "./components/store-front/store-front.component";
import { PopulatedCartRouteGuard } from "./route-gaurds/populated-cart.route-gaurd";
import { DeliveryOptionsDataService } from "./services/delivery-options.service";
import { LoginService } from "./services/login.service";
import { ProductsDataService } from "./services/products.service";
import { ShoppingCartService } from "./services/shopping-cart.service";
import { LocalStorageServie, StorageService } from "./services/storage.service";
import { HTTP_INTERCEPTORS } from "@angular/common/http";
import { HttpXsrfInterceptor } from "./services/HttpXsrfInterceptor";
import { HttpClientModule } from "@angular/common/http";
import { HttpClient } from "@angular/common/http";
import { HttpClientXsrfModule } from "@angular/common/http";
import { HttpModule } from "@angular/http";


@NgModule({
  bootstrap: [AppComponent],
  declarations: [
    AppComponent,
    ShoppingCartComponent,
    StoreFrontComponent,
    CheckoutComponent,
    OrderConfirmationComponent,
    LoginComponent,
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
    DeliveryOptionsDataService,
    PopulatedCartRouteGuard,
    LocalStorageServie,
    LoginService,
    { provide: StorageService, useClass: LocalStorageServie },
    {
      deps: [StorageService, ProductsDataService, DeliveryOptionsDataService, HttpClient],
      provide: ShoppingCartService,
      useClass: ShoppingCartService
    },
    {provide: HTTP_INTERCEPTORS, useClass: HttpXsrfInterceptor, multi: true}
  ]
})
export class AppModule { }
