import { Component, EventEmitter, Input, Output } from '@angular/core';
import { DetalleFactura, Factura } from 'src/app/models/factura';
import { FacturaService } from 'src/app/services/factura.service';

@Component({
  selector: 'app-completado',
  templateUrl: './completado.component.html',
  styleUrls: ['./completado.component.scss']
})
export class CompletadoComponent {

  detalleFactura: DetalleFactura = new DetalleFactura();
  factura: Factura = new Factura();

  idCliente: number = 0;

  constructor(private _facturaSevice: FacturaService) {

  }

  ngOnInit(): void {
    const informacion = localStorage.getItem('cliente');
    if (informacion) {
      let informacionCliente = JSON.parse(informacion);
      let cliente = informacionCliente.cliente;
      this.idCliente = informacionCliente.cliente.codigo;
    }
    this._facturaSevice.getFacturaPorCliente(this.idCliente).subscribe(
      (data) => {
        this.factura = data;
        console.log(this.factura);
      },
      (error) => {
        console.error('Error al obtener la direccion', error);
      });
  }
}
