import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { Route } from '../core/route.service';
import { BookingComponent } from './booking.component';

const routes: Routes = Route.withShell([
  { path: 'booking', component: BookingComponent, data: { title: 'Booking' } }]);

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BookingRoutingModule { }
