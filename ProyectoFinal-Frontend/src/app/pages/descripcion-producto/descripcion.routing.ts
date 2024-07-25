import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DescripcionComponent } from './descripcion/descripcion.component';

const routes: Routes = [
  { path: '', component: DescripcionComponent },
  { path:':identificador', component:  DescripcionComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DescripcionRouting { }
