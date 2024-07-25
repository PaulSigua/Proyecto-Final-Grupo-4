import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/Environments/environmets';
import { Direccion } from '../models/direccion';

@Injectable({
  providedIn: 'root'
})
export class DireccionService {

  constructor(private http: HttpClient) {

  }


  //Metodo para devolver Direccion:
  getDireccion(){
    let url = environment.WS_PATH + "/direcciones/list"
    return this.http.get<any>(url)
  }

  //Metodo para guardar Direccion
  saveDireccion(Direccion: Direccion){
    let url = environment.WS_PATH + "/direcciones"
    return this.http.post<any>(url, Direccion);
  }

  //MEtodo para devolver una Direccion:
  getDireccionPorCliente(codigo: number){
    let url = environment.WS_PATH + `/direcciones?codigo=${codigo}`
    return this.http.get<any>(url)
  }


  actualizarDireccion(direccion: Direccion) {
    let url = environment.WS_PATH + "/direcciones";
    return this.http.put<any>(url, direccion);
  }
}
