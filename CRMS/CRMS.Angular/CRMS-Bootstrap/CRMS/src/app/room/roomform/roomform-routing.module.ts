import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { Route } from '../../core/route.service';
import { RoomformComponent } from './roomform.component';

const routes: Routes = Route.withShell([
  { path: 'room/form', component: RoomformComponent, data: { title: 'Add/Edit Room' } }]);

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RoomformRoutingModule { }
