
import { Injectable } from '@angular/core';
import { environment } from 'src/Environments/environmets';
import { HttpClient } from '@angular/common/http';
import { Producto } from '../models/producto';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  productos: any[] = [
    {
      categoria: "Celulares y Tablets",
      img: "/assets/img/productos/iphone.png",
      nombre: "Iphone 15 pro max color blanco con 512GB de almacenamiento",
      precio: "102.00",
      descuento: "70%"
    },
    {
      categoria: "Celulares y Tablets",
      img: "/assets/img/productos/iphone.png",
      nombre: "Iphone 15 pro max color blanco con 512GB de almacenamiento",
      precio: "102.00",
      descuento: "70%"
    },
    {
      categoria: "Celulares y Tablets",
      img: "/assets/img/productos/iphone.png",
      nombre: "Iphone 15 pro max color blanco con 512GB de almacenamiento",
      precio: "102.00",
      descuento: "70%"
    },
    {
      categoria: "Celulares y Tablets",
      img: "/assets/img/productos/iphone.png",
      nombre: "Iphone 15 pro max color blanco con 512GB de almacenamiento",
      precio: "102.00",
      descuento: "70%"
    },
    {
      categoria: "Celulares y Tablets",
      img: "/assets/img/productos/iphone.png",
      nombre: "Iphone 15 pro max color blanco con 512GB de almacenamiento",
      precio: "102.00",
      descuento: "70%"
    },
    {
      categoria: "Celulares y Tablets",
      img: "/assets/img/productos/iphone.png",
      nombre: "Iphone 15 pro max color blanco con 512GB de almacenamiento",
      precio: "102.00",
      descuento: "70%"
    },
    {
      categoria: "Celulares y Tablets",
      img: "/assets/img/productos/iphone.png",
      nombre: "Iphone 15 pro max color blanco con 512GB de almacenamiento",
      precio: "102.00",
      descuento: "70%"
    },
    {
      categoria: "Celulares y Tablets",
      img: "/assets/img/productos/iphone.png",
      nombre: "Iphone 15 pro max color blanco con 512GB de almacenamiento",
      precio: "102.00",
      descuento: "70%"
    },
    {
      categoria: "Celulares y Tablets",
      img: "/assets/img/productos/iphone.png",
      nombre: "Iphone 15 pro max color blanco con 512GB de almacenamiento",
      precio: "102.00",
      descuento: "70%"
    },
  ]

  constructor(private http: HttpClient) {

  }


  //Metodo para devolver Productos:
  getProductos(){
    let url = environment.WS_PATH + "/productos/list"
    return this.http.get<any>(url)
  }

  //Metodo para guardar Productos
  saveProducto(Producto: Producto){
    let url = environment.WS_PATH + "/productos"
    return this.http.post<any>(url, Producto);
  }

  //Metodo para eliminar
  deleteProducto(Producto: Producto){
    let url = environment.WS_PATH + `/productos?id=${Producto.codigo}`
    return this.http.delete<any>(url);
  }

  //MEtodo para devolver una Producto:
  getProductoPorId(codigo: number){
    let url = environment.WS_PATH + `/productos?codigo=${codigo}`
    return this.http.get<any>(url)
  }

  getOfertas(){
    let url = environment.WS_PATH + "/productos/ofertas"
    return this.http.get<any>(url)
  }

  getProductoPorNombre(cadenaBusqueda: String) {
    let url = environment.WS_PATH + `/productos/buscar?nombre=${cadenaBusqueda}`
    return this.http.get<any>(url)
  }

}
