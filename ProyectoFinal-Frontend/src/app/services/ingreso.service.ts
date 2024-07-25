import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/Environments/environmets';

@Injectable({
  providedIn: 'root'
})
export class IngresoService {

  constructor(private http: HttpClient) { }

  public ingresarUsuario(ingreso: any){
    let url = environment.WS_PATH + '/ingreso'
    return this.http.post(url, ingreso);
  }

}
