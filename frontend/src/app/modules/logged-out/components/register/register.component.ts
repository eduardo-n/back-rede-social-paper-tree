import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserModel } from 'src/app/core/models/user.model';
import { UsuariosService } from 'src/app/core/services/usuarios/usuarios.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { finalize } from 'rxjs/operators';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  isLinear = false;

  formPersonal: FormGroup;
  formCollege: FormGroup;
  formLogon: FormGroup;

  sessionStorage: WindowSessionStorage

  usuarioModel: UserModel;

  hidePassword: boolean = true;

  constructor(
    private fb: FormBuilder,
    private usuarioService: UsuariosService,
    private router: Router,
    private snackBar: MatSnackBar
  ) { }

  ngOnInit(): void {
    this.formPersonal = this.fb.group({
      nome: [null, [Validators.required]],
      cpf: [null, [Validators.required]]
    });

    this.formCollege = this.fb.group({
      curso: [null, [Validators.required]],
      matricula: [null, [Validators.required]],
      // entryDate: [null, [Validators.required]]
    })

    this.formLogon = this.fb.group({
      email: [null, [Validators.required]],
      senha: [null, [Validators.required]]
    })
  }

  onSubmit(){

    if(this.formPersonal.valid && this.formCollege.valid && this.formLogon.valid){

      debugger
      const userDate={
        ...this.formPersonal.value,
        ...this.formCollege.value,
        ...this.formLogon.value,
      };

      this.usuarioService.registerUser(userDate)
      .pipe(
        finalize(() => {
          // finaliza o carregamento
        })
      )
      .subscribe(() => {

        // setar a rota para área do feed
      })
    }
  }

  openSnackBar(message: string, styleClass: string) {
    this.snackBar.open(message, '', {
      duration: 5000,
      panelClass: styleClass
    });
  }

  // get email(){
  //   return this.formRegister.get('email').value;
  // }

  // get newPassword(){
  //   return this.formRegister.get('newPassword').value;
  // }

  // get confirmPassword(){
  //   return this.formRegister.get('confirmPassword').value;
  // }
}
