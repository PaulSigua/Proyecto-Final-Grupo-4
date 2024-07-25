import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/Environments/environmets';

@Injectable({
  providedIn: 'root'
})
export class CategoriasService {

  categorias: any[] = [
    {
      img: "/assets/img/categorias/xbox-logo.png",
      nombre: "Video-juegos"
    },
    {
      img: "/assets/img/categorias/xbox-logo.png",
      nombre: "Video-juegos"
    },
    {
      img: "/assets/img/categorias/xbox-logo.png",
      nombre: "Video-juegos"
    },
    {
      img: "/assets/img/categorias/xbox-logo.png",
      nombre: "Video-juegos"
    },
    {
      img: "/assets/img/categorias/xbox-logo.png",
      nombre: "Video-juegos"
    },
    {
      img: "/assets/img/categorias/xbox-logo.png",
      nombre: "Video-juegos"
    },
    {
      img: "/assets/img/categorias/xbox-logo.png",
      nombre: "Video-juegos"
    },
    {
      img: "/assets/img/categorias/xbox-logo.png",
      nombre: "Video-juegos"
    },
    {
      img: "/assets/img/categorias/xbox-logo.png",
      nombre: "Video-juegos"
    },
  ]

  constructor(private http: HttpClient) { }

  getCategorias() {
    return this.categorias
  }

  getCategotiasBackend() {
    let url = environment.WS_PATH + '/categorias/list';
    return this.http.get<any>(url);
  }

  getCategoriaPorId(codigo: number){
    let url = environment.WS_PATH + `/categorias?codigo=${codigo}`
    return this.http.get<any>(url)
  }
}
