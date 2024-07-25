import { Component, Input } from '@angular/core';
import { Factura } from 'src/app/models/factura';

@Component({
  selector: 'app-productos-container',
  templateUrl: './productos-container.component.html',
  styleUrls: ['./productos-container.component.scss']
})
export class ProductosContainerComponent {

  cantidad: number = 0;
  precioTotal: number = 0;
  precioUnitario: number = 102.00;

  @Input() factura?: Factura;

  constructor() {

  }


  increment() {
    this.cantidad++;
    this.precioTotal = this.precioUnitario * this.cantidad;
  }

  decrement() {
    if (this.cantidad > 1) {
      this.cantidad--;
      this.precioTotal = this.precioUnitario * this.cantidad;
    }
  }
}
