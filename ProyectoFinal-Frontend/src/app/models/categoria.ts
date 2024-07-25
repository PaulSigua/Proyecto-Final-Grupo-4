import { Producto } from "./producto";

export class Categoria {
  codigo?: number;
  nombre?: string;
  imagen?: string;
  productosList?: Producto[] = [];
}


