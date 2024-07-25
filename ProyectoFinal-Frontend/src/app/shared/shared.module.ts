import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductoCardComponent } from './components/producto-card/producto-card.component';
import { CarritoCardComponent } from './components/carrito-card/carrito-card.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from '../app-routing.module';
import { RouterModule } from '@angular/router';




@NgModule({
  declarations: [
    ProductoCardComponent,
    CarritoCardComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule
  ],
  exports: [
    ProductoCardComponent,
    CarritoCardComponent
  ]
})
export class SharedModule { }
