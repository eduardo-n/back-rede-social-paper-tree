import { AbstractControl, ValidationErrors } from "@angular/forms";
import { isValidCpf } from "./documentos/is-valid-cpf.utils";

export class pptValidators {

  static cpf(control: AbstractControl): ValidationErrors {
    if(control.value && control.value != ''){
      if(!isValidCpf(control.value)){
        return { 'cpfInvalid': { 'message': 'CPF inválido' } };
      }
    }
    return null;
  }
}
