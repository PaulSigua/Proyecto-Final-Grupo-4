import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/Environments/environmets';

@Injectable({
  providedIn: 'root'
})
export class FacturaService {

  constructor(private http: HttpClient) { }

   //Metodo para guardar Carrito
   generarFactura(codigoCliente: number){
     let url = environment.WS_PATH + "/facturas"
     const cliente = {
       codigo_cliente: codigoCliente
     }
    return this.http.post<any>(url, cliente);
   }

   getFacturaPorCliente(codigo: number){
    let url = environment.WS_PATH + `/facturas?codigo=${codigo}`
    return this.http.get<any>(url)
  }
}
