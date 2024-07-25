import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { DetallesCarrito } from 'src/app/models/detallesCarrito';
import { Producto } from 'src/app/models/producto';
import { CarritoService } from 'src/app/services/carrito.service';
import { ProductoService } from 'src/app/services/producto.service';

@Component({
  selector: 'app-carrito-card',
  templateUrl: './carrito-card.component.html',
  styleUrls: ['./carrito-card.component.scss']
})
export class CarritoCardComponent {
  precioTotal: number = 0;
  precioUnitario: number = 0;
  producto?: Producto;
  cantidad: number = 0;
  precioTotalUnitario: number = 0;
  detalleCarrito: DetallesCarrito = new DetallesCarrito();

  totalFactura: number = 0;

  @Input() detalle?: DetallesCarrito;

  @Output() precioTotalChange: EventEmitter<number> = new EventEmitter<number>();

  constructor(private _productoService: ProductoService, private _carritoService: CarritoService) {

  }

  ngOnInit() {
    console.log("Entro al oninit")
    if (this.detalle) {
      const idProducto = this.detalle.codigoProducto
      if (idProducto) {
        this._productoService.getProductoPorId(idProducto).subscribe(
          (data) => {
            this.producto = data;
            if (this.producto?.precio) {
              this.precioUnitario = this.producto?.precio;
              console.log(this.precioUnitario);
              this.precioTotalUnitario = this.precioUnitario * this.cantidad;
              this.precioTotalChange.emit(this.precioTotalUnitario);
            }
            console.log(data)
          },
          (error) => {
            console.error('Error al obtener los productos:', error);
          });
      }
    }
    if (this.detalle?.cantidad) {
      this.cantidad = this.detalle?.cantidad;
    }

  }


  increment() {
    if (this.producto) {
      this.detalleCarrito.cantidad = 1;
      this.detalleCarrito.codigoCarrito = this._carritoService.getCarritoLocalStorage();
      this.detalleCarrito.codigoProducto = this.producto.codigo;
      this._carritoService.updateDetalleCarrito(this.detalleCarrito).subscribe((data: any) => {
        this.cantidad++;
        this.precioTotal = this.precioUnitario;
        this.precioTotalUnitario = this.precioUnitario * this.cantidad;
        this.precioTotalChange.emit(this.precioTotal);
      });
      this.detalleCarrito = new DetallesCarrito();
    }

  }

  decrement() {
    if (this.cantidad && this.cantidad > 1 && this.producto) {
      this.detalleCarrito.cantidad = -1;
      this.detalleCarrito.codigoCarrito = this._carritoService.getCarritoLocalStorage();
      this.detalleCarrito.codigoProducto = this.producto.codigo;
      this._carritoService.updateDetalleCarrito(this.detalleCarrito).subscribe((data: any) => {
        this.cantidad--;
        this.precioTotal = -this.precioUnitario;
        this.precioTotalUnitario = this.precioUnitario * this.cantidad;
        this.precioTotalChange.emit(this.precioTotal);
      });
      this.detalleCarrito = new DetallesCarrito();
    }
  }

  eliminar() {
    if (this.producto) {
      this.detalleCarrito.cantidad = 0;
      this.detalleCarrito.codigoCarrito = this._carritoService.getCarritoLocalStorage();
      this.detalleCarrito.codigoProducto = this.producto.codigo;
      this._carritoService.updateDetalleCarrito(this.detalleCarrito).subscribe((data: any) => {
        this.cantidad = 0;
        this.precioTotal = -this.precioTotalUnitario;
        this.precioTotalUnitario = 0;
        this.precioTotalChange.emit(this.precioTotal);
      });
      this.detalleCarrito = new DetallesCarrito();
    }

    window.location.reload();
  }

}

