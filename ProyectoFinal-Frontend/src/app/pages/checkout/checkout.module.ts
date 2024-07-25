import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CheckoutRouting } from './checkout.routing';
import { CarritoComponent } from './carrito/carrito/carrito.component';
import { CompletadoComponent } from './completado/completado/completado.component';
import { VerificacionComponent } from './verificacion/verificacion/verificacion.component';
import { CarritoContainerComponent } from './carrito/components/carrito-container/carrito-container.component';
import { TotalPrecioComponent } from './carrito/components/total-precio/total-precio.component';
import { ProductosContainerComponent } from './completado/components/productos-container/productos-container.component';
import { TotalComponent } from './completado/components/total/total.component';
import { FormularioEnvioComponent } from './verificacion/components/formulario-envio/formulario-envio.component';
import { TotalConfirmacionComponent } from './verificacion/components/total-confirmacion/total-confirmacion.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    CarritoComponent,
    CompletadoComponent,
    VerificacionComponent,
    CarritoContainerComponent,
    TotalPrecioComponent,
    ProductosContainerComponent,
    TotalComponent,
    FormularioEnvioComponent,
    TotalConfirmacionComponent,
  ],
  imports: [
    CommonModule,
    CheckoutRouting,
    SharedModule,
    FormsModule,
    ReactiveFormsModule,
  ]
})
export class CheckoutModule { }
