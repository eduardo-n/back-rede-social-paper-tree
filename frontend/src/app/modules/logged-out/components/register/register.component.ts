import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UsuarioModel } from 'src/app/core/models/usuario.model';
import { UsuariosService } from 'src/app/core/services/usuarios/usuarios.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  formRegister: FormGroup

  sessionStorage: WindowSessionStorage

  usuarioModel: UsuarioModel;

  hidePassword: boolean = true;

  constructor(
    private fb: FormBuilder,
    private usuarioService: UsuariosService,
    private router: Router,
    private snackBar: MatSnackBar
  ) { }

  ngOnInit(): void {
    this.formRegister = this.fb.group({
      email: [null, [Validators.required]],
      newPassword: [null, [Validators.required]],
      confirmPassword: [null, [Validators.required]]
    })
  }

  onSubmit(){

    // if(this.formRegister.valid){
    //   this.usuarioService.confirmLogin(this.email, this.newPassword)
    //   .pipe(
    //     finalize(() => {
    //       // finaliza o carregamento
    //     })
    //   )
    //   .subscribe((answer) => {

    //     if(answer){
    //       this.openSnackBar('Bem-vindo, "Eduardo"!', 'success-snack-bar');
    //     }else{
    //       this.openSnackBar("Dados incorretos!", 'failure-snack-bar');
    //     }

    //     // setar a rota para área do feed
    //   })
    // }
  }

  openSnackBar(message: string, styleClass: string) {
    this.snackBar.open(message, '', {
      duration: 5000,
      panelClass: styleClass
    });
  }

  get email(){
    return this.formRegister.get('email').value;
  }

  get newPassword(){
    return this.formRegister.get('newPassword').value;
  }

  get confirmPassword(){
    return this.formRegister.get('confirmPassword').value;
  }
}
