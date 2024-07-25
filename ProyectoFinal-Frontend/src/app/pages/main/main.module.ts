import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CarruselComponent } from './carrusel/carrusel.component';
import { MainRouting } from './main.routing';
import { CategoriasContainerComponent } from './categorias-container/categorias-container.component';
import { CategoriasCardComponent } from './categorias-card/categorias-card.component';
import { OfertasContainerComponent } from './ofertas-container/ofertas-container.component';
import { TendenciasContainerComponent } from './tendencias-container/tendencias-container.component';
import { PrincipalComponent } from './principal/principal.component';import { SharedModule } from 'src/app/shared/shared.module';
;



@NgModule({
  declarations: [
    CarruselComponent,
    CategoriasContainerComponent,
    CategoriasCardComponent,
    OfertasContainerComponent,
    TendenciasContainerComponent,
    PrincipalComponent,
  ],
  imports: [
    CommonModule,
    MainRouting,
    SharedModule
  ]
})
export class MainModule { }
