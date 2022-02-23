import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UsuariosService } from 'src/app/core/services/usuarios/usuarios.service';
import { UsuarioModel } from '../../../../shared/models/usuario.model'
import { MatSnackBar } from '@angular/material/snack-bar';
import { finalize } from 'rxjs/operators';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  formLogin: FormGroup

  sessionStorage: WindowSessionStorage

  usuarioModel: UsuarioModel;

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

        // if(answer){
        //   console.log("Logado!");
        // }else{
        //   console.log("Dados incorretos!");
        // }
        this.openSnackBar('Bem-vindo, "Eduardo"!');
        // setar a rota para área do feed
      })
    }
  }

  openSnackBar(message: string) {
    this.snackBar.open(message, '', {
      duration: 5000,
      panelClass: 'snack-bar-sucess'
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
