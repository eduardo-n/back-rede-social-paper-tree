import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatFormField } from '@angular/material/form-field';

@NgModule({
  exports: [
    MatButtonModule,
    // MatFormField,
    MatInputModule,
  ],
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class MaterialModule { }
