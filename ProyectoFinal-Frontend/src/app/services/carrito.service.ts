import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/Environments/environmets';
import { Carrito } from '../models/carrito';
import { DetallesCarrito } from '../models/detallesCarrito';

@Injectable({
  providedIn: 'root'
})
export class CarritoService {

  constructor(private http: HttpClient) {

  }

  //Metodo para guardar Carrito
  saveCarrito(Carrito: Carrito) {
    let url = environment.WS_PATH + "/carrito"
    return this.http.post<any>(url, Carrito);
  }

  getCarritoPorCliente(codigo: number) {
    let url = environment.WS_PATH + `/carritos?codigo=${codigo}`
    return this.http.get<any>(url)
  }

  updateCarrito(codigo: number) {
    let url = environment.WS_PATH + `/carritos/clear`
    const codigoCarrito =
    {
      "codigo_cliente": codigo
    }

    return this.http.post<any>(url, codigoCarrito)
  }

  updateDetalleCarrito(detalleCarrito: DetallesCarrito) {
    let url = environment.WS_PATH + "/carritos"
    return this.http.post(url, detalleCarrito);
  }


  getCarritoLocalStorage() {
    const carrito = localStorage.getItem('carrito');
    if (carrito) {
      const objeto: any = JSON.parse(carrito);

      return objeto;
      console.log(objeto);
    } else {
      console.log('El objeto no existe en el localStorage.');
    }

  }
}
