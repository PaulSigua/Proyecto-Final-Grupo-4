import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NosotrosComponent } from './nosotros/nosotros.component';
import { NosotrosRouting } from './nosotros.routing';

@NgModule({
  declarations: [
    NosotrosComponent,
  ],
  imports: [
    CommonModule,
    NosotrosRouting,
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]  // Añade esta línea
})
export class NosotrosModule { }
