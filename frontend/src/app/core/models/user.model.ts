import { tipoContribuidorEnum } from "../../shared/enums/tipoContribuidor.enum";

export interface UserModel{
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