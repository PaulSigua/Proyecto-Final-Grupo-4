import { Component, Input } from '@angular/core';
import { DetallesCarrito } from 'src/app/models/detallesCarrito';
import { Producto } from 'src/app/models/producto';
import { CarritoService } from 'src/app/services/carrito.service';

@Component({
  selector: 'app-producto-card',
  templateUrl: './producto-card.component.html',
  styleUrls: ['./producto-card.component.scss']
})
export class ProductoCardComponent {
  @Input() producto?: Producto;
  detalleCarrito: DetallesCarrito = new DetallesCarrito();
  constructor(private _carritoService: CarritoService) {

  }

  addDetalleCarrito(producto: Producto) {
    this.detalleCarrito.cantidad = 1;
    this.detalleCarrito.codigoCarrito = this._carritoService.getCarritoLocalStorage();
    this.detalleCarrito.codigoProducto = producto.codigo;
    this._carritoService.updateDetalleCarrito(this.detalleCarrito).subscribe((data: any) => {
      console.log(data);
      alert("Producto ingresado con exito");
    });
    this.detalleCarrito = new DetallesCarrito();
  }
}
