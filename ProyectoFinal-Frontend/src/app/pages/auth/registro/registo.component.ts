import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Cliente } from 'src/app/models/Cliente';
import { CarritoService } from 'src/app/services/carrito.service';
import { ClienteService } from 'src/app/services/cliente.service';
import { Carrito } from '../../../models/carrito';
import { DetallesCarrito } from 'src/app/models/detallesCarrito';

@Component({
  selector: 'app-registo',
  templateUrl: './registo.component.html',
  styleUrls: ['./registo.component.scss']
})
export class RegistroComponent {

  boolean: boolean = false;
  contrasenia: String = '';
  cliente: Cliente = new Cliente();
  carrito: Carrito = new Carrito();
  detalleCarrito: DetallesCarrito[] = [];

  public constructor(private clienteService: ClienteService, private router: Router, private _carritoService: CarritoService) { }

  public ingresarCliente() {
    this.validarContrasenia();
    if (this.boolean == false) {
      console.log('Las contraseñas no coinciden');
      return;
    } else {
      this.clienteService.ingresarCliente(this.cliente).subscribe((data: any) => {
        console.log(data);
        this.agradecimiento();
      });
      this.cliente = new Cliente();
      this.contrasenia = '';
    }

  }

  public agradecimiento() {
    this.router.navigate(['/auth/agradecimiento']);
  }

  public validarContrasenia() {
    try {
      if (this.cliente.contrasenia != this.contrasenia) {
        this.boolean = false;
      } else {
        this.boolean = true;
      }
    } catch (error) {
      console.log(error);
    }
  }

}
