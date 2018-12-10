import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatTableModule, MatPaginatorModule,
  MatSlideToggleModule, MatDatepickerModule,
  MdNativeDateModule, NoConflictStyleCompatibilityMode,
  MatAutocompleteModule, MatCardModule, MatListModule} from '@angular/material';


@NgModule({
  imports:
   [MatTableModule,
    MatPaginatorModule,
    MatSlideToggleModule,
    MatDatepickerModule,
    MdNativeDateModule,
    NoConflictStyleCompatibilityMode, MatAutocompleteModule, MatCardModule, MatListModule],
  exports:
  [MatTableModule,
   MatPaginatorModule,
   MatSlideToggleModule,
   MatDatepickerModule,
   MdNativeDateModule,
   NoConflictStyleCompatibilityMode, MatAutocompleteModule, MatCardModule, MatListModule],
  declarations: []
})
export class MatmoduleModule { }
