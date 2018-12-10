import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { Route } from '../core/route.service';
import { RoomComponent } from './room.component';

const routes: Routes =  Route.withShell([
  { path: 'room', component: RoomComponent, data: { title: 'Manange Rooms' } }]);

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RoomRoutingModule { }
