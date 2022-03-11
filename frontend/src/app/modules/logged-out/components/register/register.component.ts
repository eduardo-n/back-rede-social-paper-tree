import { Component, OnInit } from '@angular/core';
import { AbstractControl, ControlContainer, FormBuilder, FormGroup, ValidationErrors, ValidatorFn, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserModel } from 'src/app/core/models/user.model';
import { UsuariosService } from 'src/app/core/services/usuarios/usuarios.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { finalize } from 'rxjs/operators';
import { pptValidators } from 'src/app/shared/validators/ppt-validators';
import { disableDebugTools } from '@angular/platform-browser';

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
    this.buildForm();
  }

  buildForm() {
    this.formPersonal = this.fb.group({
      nome: [null, [Validators.required, pptValidators.fullNameSurname]],
      cpf: [null, [Validators.required, pptValidators.cpf]]
    });

    this.formCollege = this.fb.group({
      curso: [null, [Validators.required]],
      matricula: [null, [Validators.required]],
      // entryDate: [null, [Validators.required]]
    })

    debugger
    this.formLogon = this.fb.group({
      email: [null, [Validators.required, Validators.email, pptValidators.emailUfvDomain]],
      senha: [null, [Validators.required]],
      confirmarSenha: [null, [Validators.required]]
    })
    debugger
  }

  onSubmit(){

    if(this.formPersonal.valid && this.formCollege.valid && this.formLogon.valid){

      if(this.senha.value !== this.confirmarSenha.value){
        this.openSnackBar("Senhas não conferem", 'failure-snack-bar');
        return;
      }

      const userDate={
        ...this.formPersonal.value,
        ...this.formCollege.value,
        ...this.formLogon
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
    else{
      this.openSnackBar("Dados incorretos!", 'failure-snack-bar');
    }
  }

  openSnackBar(message: string, styleClass: string) {
    this.snackBar.open(message, '', {
      duration: 5000,
      panelClass: styleClass
    });
  }

  nivelSenhaVar: number = 0;
  nivelSenha() {
    this.nivelSenhaVar = 15;
  }

  get nome(){
    return this.formPersonal.get('nome');
  }

  get cpf(){
    return this.formPersonal.get('cpf');
  }

  get curso(){
    return this.formCollege.get('curso');
  }

  get matricula(){
    return this.formCollege.get('matricula');
  }

  get dataIngresso(){
    return this.formCollege.get('dataIngresso');
  }

  get email(){
    return this.formLogon.get('email');
  }

  get senha(){
    return this.formLogon.get('senha');
  }

  get confirmarSenha(){
    return this.formLogon.get('confirmarSenha');
  }
}
