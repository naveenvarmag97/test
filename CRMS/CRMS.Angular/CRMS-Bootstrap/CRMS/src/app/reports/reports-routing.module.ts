import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { Route } from '../core/route.service';
import { ReportsComponent } from './reports.component';

const routes: Routes = Route.withShell([
  { path: 'reports', component: ReportsComponent, data: { title: 'Reports' } }]);

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ReportsRoutingModule { }
