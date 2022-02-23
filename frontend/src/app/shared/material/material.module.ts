import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';


@NgModule({
  exports: [
    MatButtonModule,
    MatInputModule
  ],
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class MaterialModule { }
