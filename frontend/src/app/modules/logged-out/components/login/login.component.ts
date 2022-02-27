import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UsuariosService } from 'src/app/core/services/usuarios/usuarios.service';
import { UserModel } from '../../../../core/models/user.model'
import { MatSnackBar } from '@angular/material/snack-bar';
import { finalize } from 'rxjs/operators';
import { ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class LoginComponent implements OnInit {

  formLogin: FormGroup

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
    this.formLogin = this.fb.group({
      email: [null, [Validators.required]],
      password: [null, [Validators.required]]
    })
  }

  onSubmit(){

    if(this.formLogin.valid){
      this.usuarioService.confirmLogin(this.email, this.password)
      .pipe(
        finalize(() => {
          // finaliza o carregamento
        })
      )
      .subscribe((answer) => {

        if(answer){
          this.openSnackBar('Bem-vindo(a)!', 'success-snack-bar');
        }else{
          this.openSnackBar("Dados incorretos!", 'failure-snack-bar');
        }

        // setar a rota para área do feed
      })
    }
  }

  openSnackBar(message: string, styleClass: string) {
    this.snackBar.open(message, '', {
      duration: 4000,
      panelClass: styleClass
    });
  }

//sessionStorage.setItem(this.usuarioModel)

  get email(){
    return this.formLogin.get('email').value;
  }

  get password(){
    return this.formLogin.get('password').value;
  }
}
