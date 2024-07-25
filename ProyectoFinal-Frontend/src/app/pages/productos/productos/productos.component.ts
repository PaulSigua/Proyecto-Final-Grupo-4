import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Producto } from 'src/app/models/producto';
import { CategoriasService } from 'src/app/services/categorias.service';
import { ProductoService } from 'src/app/services/producto.service';
import { Categoria } from '../../../models/categoria';

@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.scss']
})
export class ProductosComponent implements OnInit {
  productos: Producto[] = [];
  categorias?: Categoria;
  producto?: Producto;
  titulo: string = "";
  codigo: number = 0;

  constructor(private _productosService: ProductoService, private _route: ActivatedRoute, private _categoriaService: CategoriasService) {

  }

  ngOnInit(): void {
    this._route.params.subscribe(params => {
      const cadenaBusqueda = this._route.snapshot.paramMap.get('cadena');
      const identificador = parseInt(this._route.snapshot.paramMap.get('identificador') || '0');
      if (cadenaBusqueda) {
        console.log("ES una busqueda")
        console.log(cadenaBusqueda)
        this._productosService.getProductoPorNombre(cadenaBusqueda).subscribe(
          (data) => {
            if (cadenaBusqueda != "") {
              this.productos = data;
              this.titulo = cadenaBusqueda
            } else {
              this.titulo = "No ha mandano a buscar nada"
            }

          },
          (error) => {
            console.error('Error al obtener la categoria:', error);
            this.titulo = "No existe el producto: " + cadenaBusqueda
            this.productos = []
          });
      } else if (identificador) {
        this._categoriaService.getCategoriaPorId(identificador).subscribe(
          (data) => {
            this.categorias = data;
            if (this.categorias && this.categorias.productosList && this.categorias.nombre && this.categorias.codigo) {
              this.productos = this.categorias.productosList
              this.titulo = this.categorias.nombre
              this.codigo = this.categorias.codigo;
              console.log(this.codigo)
            }
          },
          (error) => {
            console.error('Error al obtener la categoria:', error);
          });
      } else {
        this._productosService.getProductos().subscribe(
          (data) => {
            this.productos = data;
            this.titulo = "Todos los productos"
          },
          (error) => {
            console.error('Error al obtener los productos:', error);
          })
      }
    });



  }
}
