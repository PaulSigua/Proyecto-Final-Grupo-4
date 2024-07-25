import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IngresoComponent } from './ingreso/ingreso.component';
import { AgradecimientoComponent } from './agradecimiento/agradecimiento.component';
import { RecuperarCuentaComponent } from './recuperar-cuenta/recuperar-cuenta.component';
import { RegistroComponent } from './registro/registo.component';

const routes: Routes = [
  { path: 'ingreso', component: IngresoComponent},
  { path: 'agradecimiento', component: AgradecimientoComponent},
  { path: 'registro', component: RegistroComponent},
  { path: 'recuperar-cuenta', component: RecuperarCuentaComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AuthRouting { }
