import { Component, ViewChild } from '@angular/core';
import { SidebarComponent } from './layouts/sidebar/sidebar.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'ProyectoFinal';

  @ViewChild(SidebarComponent)
  sidebar?: SidebarComponent;

  hola: string = "hola";
}
