import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductosComponent } from './productos/productos.component';

const routes: Routes = [
  { path: '', component: ProductosComponent },
  { path: 'descripcion', loadChildren: () => import('../descripcion-producto/descripcion.module').then(m => m.DescripcionModule) },
  { path: ':identificador', component: ProductosComponent },
  { path: 'busqueda/:cadena', component: ProductosComponent }
];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProductosRouting { }
