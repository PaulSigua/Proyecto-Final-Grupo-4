import { Component } from '@angular/core';
import { Producto } from 'src/app/models/producto';
import { Carrito } from '../../../../../models/carrito';
import { DetallesCarrito } from '../../../../../models/detallesCarrito';
import { ProductoService } from 'src/app/services/producto.service';
import { CarritoService } from 'src/app/services/carrito.service';
import { ClienteService } from 'src/app/services/cliente.service';
import { Cliente } from 'src/app/models/Cliente';
import { TotalPrecioService } from 'src/app/services/total-precio.service';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-carrito-container',
  templateUrl: './carrito-container.component.html',
  styleUrls: ['./carrito-container.component.scss']
})
export class CarritoContainerComponent {
  carrito: any;
  subTotal: number = 0;
  iva: number = 0;
  total: number = 0;


  detalleCarrito: DetallesCarrito = new DetallesCarrito();

  constructor(private _productoService: ProductoService, private _carritoService: CarritoService, private _clienteService: ClienteService, private _totalPrecioService: TotalPrecioService, private router: Router) {

  }

  ngOnInit(): void {
    const cliente = this._clienteService.getClienteLocalStorage();
    console.log(cliente);
    this._carritoService.getCarritoPorCliente(cliente.cliente.codigo).subscribe(
      (data) => {
        this.carrito = data;
        console.log(data)
      },
      (error) => {
        console.error('Error al obtener los productos:', error);
      });
  }

  onPrecioTotalChange(precioTotal: number): void {
    console.log('Precio total actualizado:', precioTotal);
    this.subTotal = this.subTotal + precioTotal;
    this.iva = this.subTotal * (12 / 100)
    this.total = this.subTotal + this.iva
    
  }

  verficarCompra() {
    localStorage.setItem('subtotal', JSON.stringify(this.subTotal));
    this.router.navigate(['/checkout/verificacion']);
  }
}

