import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductoService } from 'src/app/services/producto.service';
import { Producto } from '../../../models/producto';
import { CarritoService } from 'src/app/services/carrito.service';
import { DetallesCarrito } from 'src/app/models/detallesCarrito';

@Component({
  selector: 'app-descripcion',
  templateUrl: './descripcion.component.html',
  styleUrls: ['./descripcion.component.scss']
})
export class DescripcionComponent {
  cantidad: number = 0;
  precioTotal: number = 0;
  precioUnitario: number = 102.00;
  producto!: Producto;
  detalleCarrito: DetallesCarrito = new DetallesCarrito();

  constructor(private _route: ActivatedRoute,
    private _productoService: ProductoService,
    private _carritoService: CarritoService) {

  }
  ngOnInit() {
    const identificador = parseInt(this._route.snapshot.paramMap.get('identificador') || '0');
    this._productoService.getProductoPorId(identificador).subscribe(
      (data) => {
        this.producto = data;
      },
      (error) => {
        console.error('Error al obtener el producto:', error);
      })
  }

  increment() {
    this.cantidad++;
    this.precioTotal = this.precioTotal * this.cantidad;
  }

  decrement() {
    if (this.cantidad > 1) {
      this.cantidad--;
      this.precioTotal = this.precioTotal * this.cantidad;
    }
  }

  addDetalleCarrito(producto: Producto) {
    if (this.cantidad == 0) {
      alert("no ha seleccionado una cantidad");
    } else {
      this.detalleCarrito.cantidad = this.cantidad;
      this.detalleCarrito.codigoCarrito = this._carritoService.getCarritoLocalStorage();
      this.detalleCarrito.codigoProducto = producto.codigo;
      this._carritoService.updateDetalleCarrito(this.detalleCarrito).subscribe((data: any) => {
        console.log(data);
        alert("Producto ingresado con exito");
      });
      this.detalleCarrito = new DetallesCarrito();
    }

  }

}
