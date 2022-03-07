import { AbstractControl, ValidationErrors } from "@angular/forms";
import { isValidCpf } from "./documentos/is-valid-cpf.utils";

export class pptValidators {

  static cpf(control: AbstractControl): ValidationErrors {
    if(control.value && control.value != ''){
      if(!isValidCpf(control.value)){
        return { 'invalidCpf': { 'message': 'CPF inválido' } };
      }
    }
    return null;
  }

  static emailUfvDomain(control: AbstractControl): ValidationErrors {
    if(control.value && !control.value.endsWith("@ufv.br")){
      return { 'invalidEmail': { 'message': 'Email precisa ter o domínio da UFV (@ufv.br)' } };
    }
    return null;
  }

  // static validPassword(control: AbstractControl): ValidationErrors {
  //   if(control.value){
  //     if(control.value.length < 6){
  //       return { 'invalidPassword': { 'message': 'Sua senha deve conter no mínimo 6 caracteres' } };
  //     }
  //   }
  //   return null;
  // }
}
