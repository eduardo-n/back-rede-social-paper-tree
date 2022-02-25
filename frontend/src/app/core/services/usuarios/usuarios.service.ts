import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  constructor(
    private httpService: HttpClient,
  ) { }

  confirmLogin(email:String, senha: String){
    return this.httpService.get('http://localhost:8080/usuarios/login/'+email+'/'+senha);
  }
}
