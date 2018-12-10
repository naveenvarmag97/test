import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { Route } from '../core/route.service';
import { RoomtypeComponent } from './roomtype.component';

const routes: Routes = Route.withShell([
  { path: 'roomtype', component: RoomtypeComponent, data: { title: 'Manage Room Type' } }]);

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RoomtypeRoutingModule { }
