import { Component, EventEmitter, Output } from '@angular/core';
import { Router } from '@angular/router';
import { TotalPrecioService } from 'src/app/services/total-precio.service';

@Component({
  selector: 'app-total-confirmacion',
  templateUrl: './total-confirmacion.component.html',
  styleUrls: ['./total-confirmacion.component.scss']
})
export class TotalConfirmacionComponent {
  precioTotal: number = 0;
  iva: number = 0;
  total: number = 0;
  @Output() botonPresionado = new EventEmitter<void>();
  direccionConfirmada = false;
  aceptaPromociones = false;

  // Llama a este método cuando se presione el botón

  constructor(private _totalPrecioService: TotalPrecioService, private router: Router) { }

  ngOnInit(): void {
    const subtotal = localStorage.getItem('subtotal');
    if (subtotal) {
      const objeto: any = JSON.parse(subtotal);

      this.precioTotal = objeto;
      this.iva = this.precioTotal * (12 / 100)
      this.total = this.precioTotal + this.iva
      console.log(objeto);
    } else {
      console.log('El objeto no existe en el localStorage.');
    }
  }

  onButtonPress(): void {
    if (this.direccionConfirmada && this.aceptaPromociones) {
      this.botonPresionado.emit();
      alert("Gracias por su honestidad y aceptar las promociones");

    } else if (this.direccionConfirmada) {
      this.botonPresionado.emit();
      alert("Gracias por su honestidad");
    } else {
      alert("Debe confirmar que la informacion es totalmente verdadera");
    }
  }
}
