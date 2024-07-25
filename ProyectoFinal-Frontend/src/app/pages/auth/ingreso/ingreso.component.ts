import { Component } from '@angular/core';
import { Cliente } from 'src/app/models/Cliente';
import { Ingreso } from 'src/app/models/Ingreso';
import { Carrito } from 'src/app/models/carrito';
import { CarritoService } from 'src/app/services/carrito.service';
import { IngresoService } from 'src/app/services/ingreso.service';

@Component({
  selector: 'app-ingreso',
  templateUrl: './ingreso.component.html',
  styleUrls: ['./ingreso.component.scss']
})
export class IngresoComponent {

  ingreso: Ingreso = new Ingreso();
  carrito: Carrito = new Cliente();
  cliente: Cliente = new Cliente();

  public constructor(private ingresoService: IngresoService, private _carritoService: CarritoService) { }

  public ingresarUsuario() {
    this.ingresoService.ingresarUsuario(this.ingreso).subscribe((data: any) => {
      console.log(data);
      if (data.inicioExitoso) {
        localStorage.setItem('cliente', JSON.stringify(data));
        this.cliente = data.cliente;
        console.log("entro 1")
        this._carritoService.getCarritoPorCliente(data.cliente.codigo).subscribe(
          (data) => {
            console.log(data)
            if (data != null) {
              localStorage.setItem('carrito', JSON.stringify(data.codigo));
              console.log("entro 3")
            } else {
              this.carrito.cliente = this.cliente;
              this.carrito.detalles = [];
              this._carritoService.saveCarrito(this.carrito).subscribe(
                (data) => {
                  this._carritoService.getCarritoPorCliente(this.cliente.codigo).subscribe(
                    (data) => {
                      console.log(data)
                      localStorage.setItem('carrito', JSON.stringify(data.codigo));
                    });
                },
                (error) => {
                  console.error('Error al obtener los productos:', error);
                });
            }

          },
          (error) => {
            console.log(error)

          });
      }
    });
    this.ingreso = new Ingreso();
  }




}
