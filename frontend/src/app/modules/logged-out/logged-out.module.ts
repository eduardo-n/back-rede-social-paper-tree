import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoggedOutService } from './logged-out.service';

@NgModule({
  declarations: [],
  imports: [
    //modules
    CommonModule
  ],
  providers: [
    //services
    LoggedOutService
  ]
})
export class LoggedOutModule { }
