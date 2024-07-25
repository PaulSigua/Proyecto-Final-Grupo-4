import { FacturaService } from './../../../../../services/factura.service';
import { Component, EventEmitter, Input } from '@angular/core';
import { Cliente } from 'src/app/models/Cliente';
import { ClienteService } from 'src/app/services/cliente.service';
import { DireccionService } from 'src/app/services/direccion.service';
import { Direccion } from '../../../../../models/direccion';
import { FormBuilderService } from '../../form-builder.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { CarritoService } from 'src/app/services/carrito.service';

@Component({
  selector: 'app-formulario-envio',
  templateUrl: './formulario-envio.component.html',
  styleUrls: ['./formulario-envio.component.scss']
})
export class FormularioEnvioComponent {

  string = '';
  @Input() botonPresionado?: EventEmitter<void>;
  formulario?: FormGroup;

  cliente: Cliente = new Cliente();
  informacionCliente: any;
  direccion: Direccion = new Direccion();

  clineteAct: Cliente = new Cliente();
  direccionAct: Direccion = new Direccion();

  existeDireccion: Boolean = false;

  constructor(private clienteService: ClienteService, private _direccionService: DireccionService, private _formBuilderService: FormBuilderService, private _facturaService: FacturaService, private router: Router, private _carritoService: CarritoService, private _clienteService: ClienteService) {
  }

  ngOnInit(): void {
    this.verificarInformacionLocalStorage();
    this.obtenerDireccion();

    this.formulario = new FormGroup({
      nombre: new FormControl('', [Validators.required]),
      apellido: new FormControl('', [Validators.required]),
      pais: new FormControl('', [Validators.required]),
      principal: new FormControl('', [Validators.required]),
      secundaria: new FormControl('', [Validators.required]),
      ciudad: new FormControl('', [Validators.required]),
      provincia: new FormControl('', [Validators.required]),
      codigoPostal: new FormControl('', [Validators.required]),
      celular: new FormControl('', [Validators.required]),
      correo: new FormControl('', [Validators.required]),
    });

    if (this.botonPresionado) {
      this.botonPresionado.subscribe(() => {
        this.enviarDatos();
      });
    }
  }

  onButtonPress(): void {
    this.enviarDatos();
    console.log(this.cliente.codigo)

  }

  enviarDatos(): void {
    // Crea un objeto con los datos del formulario
    if (this.formulario) {
      if (this.formulario.invalid) {
        alert('La informacion ingresada es incorrecta o incompleta');
        return
      }
      this.clineteAct.codigo = this.cliente.codigo;
      this.clineteAct.primerNombre = this.formulario.get('nombre')?.value;
      this.clineteAct.primerApellido = this.formulario.get('apellido')?.value;
      this.clineteAct.correo = this.formulario.get('correo')?.value;
      this.clineteAct.contrasenia = this.cliente.contrasenia;
      this.clineteAct.celular = this.formulario.get('celular')?.value;

      this.clienteService.actualizarCliente(this.clineteAct).subscribe(data => {
        console.log()
      });

      this.direccionAct.codigo = this.direccion.codigo;
      this.direccionAct.nombrePais = this.formulario.get('pais')?.value;
      //this.direccionAct.nombreProvincia = this.formulario.get('provincia')?.value;
      this.direccionAct.nombreProvincia = this.formulario.get('provincia')?.value;;
      this.direccionAct.nombreCiudad = this.formulario.get('ciudad')?.value;
      this.direccionAct.codigoPostal = this.formulario.get('codigoPostal')?.value;
      this.direccionAct.direccionPricipal = this.formulario.get('principal')?.value;
      this.direccionAct.direccionSecundaria = this.formulario.get('secundaria')?.value;
      this.direccionAct.cliente = this.clineteAct;

      const dir = this.direccionAct;

      console.log(dir)
      this._direccionService.actualizarDireccion(this.direccionAct).subscribe(data => {

      });

      this._facturaService.generarFactura(this.cliente.codigo).subscribe(data => {
        console.log(data);
      });

      const informacion = localStorage.getItem('carrito');
      if (informacion) {
        const informacionCarrito = JSON.parse(informacion);
        const codigo = informacionCarrito
        this._carritoService.updateCarrito(codigo).subscribe(data => {
        });
      }



      this.clineteAct = new Cliente();
      this.direccionAct = new Direccion();

      this.router.navigate(['/checkout/completado']);
    }
  }

  public actualizarCliente() {
    this.clienteService.actualizarCliente(this.cliente).subscribe(data => {

      alert('Se actualizo con exito');
      localStorage.setItem('cliente', JSON.stringify(data));
      this.ngOnInit();
    });
  }

  verificarInformacionLocalStorage() {
    const informacion = localStorage.getItem('cliente');
    if (informacion) {
      this.informacionCliente = JSON.parse(informacion);
      this._clienteService.getClientePorId(this.informacionCliente.cliente.codigo).subscribe(
        (data) => {
          this.cliente = data;
          console.log(data)
        });
      this.string = this.informacionCliente.cliente.primerNombre;
    }
  }

  obtenerDireccion() {
    const informacion = localStorage.getItem('cliente');
    if (informacion) {
      this.informacionCliente = JSON.parse(informacion);
      this._direccionService.getDireccionPorCliente(this.informacionCliente.cliente.codigo).subscribe(
        (data) => {
          this.direccion = data;
          console.log(data)
        },
        (error) => {
          this.direccion.cliente = this.cliente;
          this.direccion.codigoPostal = "";
          this.direccion.direccionPricipal = "";
          this.direccion.direccionSecundaria = "";
          this.direccion.nombreCiudad = "";
          this.direccion.nombrePais = "";
          this.direccion.nombreProvincia = "";
          this._direccionService.saveDireccion(this.direccion).subscribe(
            (data) => {
              this._direccionService.getDireccionPorCliente(this.cliente.codigo).subscribe(
                (data) => {
                  this.direccion = data;
                  console.log(data)
                });
            });
        });
    }
  }
}
