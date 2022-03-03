import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { UserModel } from '../../models/user.model';


@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  constructor(
    private httpService: HttpClient,
  ) { }

  confirmLogin(email:String, password: String){
    return this.httpService.get(environment.baseURL+'usuarios/login/'+email+'/'+password);
  }

  registerUser(user){
    return this.httpService.post(environment.baseURL+'usuarios/inserir', user);
  }
}
