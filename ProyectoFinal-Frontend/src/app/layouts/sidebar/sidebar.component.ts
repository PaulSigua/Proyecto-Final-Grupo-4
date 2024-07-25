import { Component } from '@angular/core';
import { SidebarService } from 'src/app/services/sidebar.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss'],
})
export class SidebarComponent{
  sidebarActive: boolean = false;

  constructor(private sidebarService: SidebarService) {
    this.sidebarService.sidebarState.subscribe(isOpen => {
      this.sidebarActive = isOpen;
    });
  }

  toggleSidebar() {
    this.sidebarService.toggle();
  }

  verificarInformacionLocalStorage(): boolean {
    const informacion = localStorage.getItem('cliente');
    return informacion !== null;
  }

}
