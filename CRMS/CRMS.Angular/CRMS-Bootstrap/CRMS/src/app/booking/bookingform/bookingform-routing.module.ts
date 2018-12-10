import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { Route } from '../../core/route.service';
import { BookingformComponent } from './bookingform.component';

const routes: Routes =  Route.withShell([
  { path: 'booking/form', component: BookingformComponent, data: { title: 'Booking' } }]);

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BookingformRoutingModule { }
