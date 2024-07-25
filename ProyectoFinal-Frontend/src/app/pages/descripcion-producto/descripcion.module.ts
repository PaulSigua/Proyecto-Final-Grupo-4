import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DescripcionRouting } from './descripcion.routing';
import { DescripcionComponent } from './descripcion/descripcion.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule, NgModel } from '@angular/forms';


@NgModule({
  declarations: [

    DescripcionComponent
  ],
  imports: [
    CommonModule,
    DescripcionRouting,
    FormsModule,
  ]
})
export class DescripcionModule { }
