import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RoomRoutingModule } from './room-routing.module';
import { RoomformComponent } from './roomform/roomform.component';
import { RoomformModule } from './roomform/roomform.module';


@NgModule({
  imports: [
    CommonModule,
    RoomRoutingModule,
  ],
  declarations: []
})
export class RoomModule { }
