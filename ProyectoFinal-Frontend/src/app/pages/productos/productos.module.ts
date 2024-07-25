import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductosRouting } from './productos.routing';
import { ProductosComponent } from './productos/productos.component';
import { CategoriasListComponent } from './categorias-list/categorias-list.component';
import { SharedModule } from 'src/app/shared/shared.module';


@NgModule({
  declarations: [
    ProductosComponent,
    CategoriasListComponent
  ],
  imports: [
    CommonModule,
    ProductosRouting,
    SharedModule
  ]
})
export class ProductosModule { }
