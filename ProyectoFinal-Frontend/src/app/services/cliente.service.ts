import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/Environments/environmets';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor(private http: HttpClient) { }

  public ingresarCliente(cliente: any) {
    let url = environment.WS_PATH + '/clientes'
    return this.http.post(url, cliente);
  }

  public getClienteEmail(email: string) {
    let url = environment.WS_PATH + '/clientes/email/' + email;
    return this.http.get(url);
  }

  public getClientePorId(codigo: number) {
    let url = environment.WS_PATH + `/clientes?codigo=${codigo}`
    return this.http.get<any>(url);
  }

  getClienteLocalStorage() {
    const cliente = localStorage.getItem('cliente');
    if (cliente) {
      const objeto: any = JSON.parse(cliente);

      return objeto;
      console.log(objeto);
    } else {
      console.log('El objeto no existe en el localStorage.');
    }
  }
  public actualizarCliente(cliente: any) {
    let url = environment.WS_PATH + '/clientes'
    return this.http.put(url, cliente);
  }
}
