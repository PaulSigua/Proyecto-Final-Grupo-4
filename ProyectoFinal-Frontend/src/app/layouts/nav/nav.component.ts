import { Component, OnInit, ViewChild } from '@angular/core';
import { SidebarComponent } from '../sidebar/sidebar.component';
import { SidebarService } from 'src/app/services/sidebar.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss']
})
export class NavComponent implements OnInit {

  cadenaTexto: string = "";
  mostrarSugerencias: boolean = false;
  sugerencias: string[] = [
    "Hola",
    "Como",
    "Estan"
  ];

  constructor(private sidebarService: SidebarService) { }

  // Método para abrir el sidebar
  openSidebar() {
    this.sidebarService.open();
  }

  ngOnInit(): void {
    this.verificarInformacionLocalStorage();
    this.cargarSugerencias();
  }

  cargarSugerencias() {
    const busquedasExistentes = localStorage.getItem('busquedas');
    if (busquedasExistentes) {

    } else {
      localStorage.setItem('busquedas', JSON.stringify(this.sugerencias));
    }

  }

  ocultarSugerencias() {
    setTimeout(() => this.mostrarSugerencias = false, 200);
  }

  verificarInformacionLocalStorage(): boolean {
    const informacion = localStorage.getItem('cliente');
    return informacion !== null;
  }

  guardarBusqueda(cadenaTexto: string) {
    let busquedas = JSON.parse(localStorage.getItem('busquedas') || '[]');
    if (!busquedas.includes(cadenaTexto) && !this.sugerencias.includes(cadenaTexto)) {
      this.sugerencias.push(cadenaTexto);
      busquedas.push(cadenaTexto);
      localStorage.setItem('busquedas', JSON.stringify(busquedas));
    }
  }

  seleccionarSugerencia(sugerencia: string) {
    this.cadenaTexto = sugerencia;
    this.mostrarSugerencias = false;
  }
}
