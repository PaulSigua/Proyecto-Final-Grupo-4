import { Producto } from "./producto";
import { Cliente } from './Cliente';

export class DetalleFactura {
  codigo?: number;
  cantidad?: number;
  precioTotal?: number;
  precioSubtotal?: number;
  precioIva?: number;
  productos?: Producto;
}
export class Factura {
  codigo?: number;
  fecha?: Date;
  precioTotal?: number;
  precioSubtotal?: number;
  precioIva?: number;
  cliente?: Cliente;
  detallesList?: DetalleFactura[];
}
