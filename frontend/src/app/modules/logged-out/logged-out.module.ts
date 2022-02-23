import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoggedOutService } from './logged-out.service';
import { LoginComponent } from './components/login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from 'src/app/shared/shared.module';
import { HttpClientModule } from '@angular/common/http';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MaterialModule } from 'src/app/shared/material/material.module';

@NgModule({
  declarations: [
    LoginComponent
  ],
  imports: [
    //modules
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    SharedModule,
    HttpClientModule,
    MatSnackBarModule,
    MaterialModule
  ],
  exports: [
    //components
    LoginComponent
  ],
  providers: [
    //services
    LoggedOutService
  ]
})
export class LoggedOutModule { }
