import { tipoContribuidorEnum } from "../enums/tipoContribuidor.enum";

export interface UsuarioModel{
  id: number;
  nome: string,
  email: string,
  cpf: string,
  matricula: number,
  curso: string,
  senha: string,
  dataIngresso: Date,
  tipoContribuidor: tipoContribuidorEnum
}
