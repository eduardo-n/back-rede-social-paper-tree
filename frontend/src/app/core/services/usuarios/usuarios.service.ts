import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserModel } from '../../models/user.model';


@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  constructor(
    private httpService: HttpClient,
  ) { }

  confirmLogin(email:String, password: String){
    return this.httpService.get('http://localhost:8080/usuarios/login/'+email+'/'+password);
  }

  registerUser(user){
    return this.httpService.post('http://localhost:8080/usuarios/inserir', user);
  }
}
