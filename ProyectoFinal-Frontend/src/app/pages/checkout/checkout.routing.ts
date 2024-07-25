import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CarritoComponent } from './carrito/carrito/carrito.component';
import { VerificacionComponent } from './verificacion/verificacion/verificacion.component';
import { CompletadoComponent } from './completado/completado/completado.component';

const routes: Routes = [
  { path:'carrito', component: CarritoComponent },
  { path:'verificacion', component:  VerificacionComponent},
  { path:'completado', component:  CompletadoComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CheckoutRouting { }
