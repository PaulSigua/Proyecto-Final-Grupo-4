import { Cliente } from "./Cliente";
import { DetallesCarrito } from "./detallesCarrito";

export class Carrito {
  codigo?: number;
  cliente?: Cliente;
  detalles?: DetallesCarrito[];
}
