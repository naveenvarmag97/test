import { HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';
import { NgModule, ErrorHandler } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { IonicApp, IonicModule, IonicErrorHandler } from 'ionic-angular';
import { MyApp } from './app.component';

import { AboutPage } from '../pages/about/about';

import { HomePage } from '../pages/home/home';
import { TabsPage } from '../pages/tabs/tabs';
import {LoginFormPage} from  '../pages/login-form/login-form'
import{DashboardPage} from '../pages/dashboard/dashboard'

import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { EmployeeServiceProvider } from '../providers/employee-service/employee-service';
import{EmployeeDetailsPage} from '../pages/employee-details/employee-details'




@NgModule({
  declarations: [
    MyApp,
    AboutPage,
  
    HomePage,
    TabsPage,
    LoginFormPage,
    DashboardPage,
    EmployeeDetailsPage
  ],
  imports: [
    BrowserModule,
    IonicModule.forRoot(MyApp),
    HttpModule,
    HttpClientModule,
    
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    AboutPage,
    
    HomePage,
    TabsPage,
    LoginFormPage,
    DashboardPage,
    EmployeeDetailsPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    EmployeeServiceProvider
  ]
})
export class AppModule {}
