import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {TableModule} from 'primeng/table';
import { DataTableModule } from 'primeng/primeng';

@NgModule({
  imports: [
    CommonModule,
    TableModule,
    DataTableModule
  ],
  declarations: []
})
export class PrimeNgModule { }
