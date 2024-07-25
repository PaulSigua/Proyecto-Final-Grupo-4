import { Cliente } from './Cliente';
export class Direccion {
  codigo?: number;
  nombrePais?: String;
  direccionPricipal?: String;
  direccionSecundaria?: String;
  nombreCiudad?: String;
  nombreProvincia?: String;
  codigoPostal?: String;
  cliente?: Cliente;
}
