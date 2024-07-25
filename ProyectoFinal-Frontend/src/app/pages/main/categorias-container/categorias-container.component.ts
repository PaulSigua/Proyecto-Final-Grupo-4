import { Component, HostListener, OnInit } from '@angular/core';
import { CategoriasService } from 'src/app/services/categorias.service';

@Component({
  selector: 'app-categorias-container',
  templateUrl: './categorias-container.component.html',
  styleUrls: ['./categorias-container.component.scss']
})
export class CategoriasContainerComponent implements OnInit{
  categorias: any[] = [];
  
  constructor(private _categoriasService: CategoriasService) {
    this._categoriasService.getCategotiasBackend().subscribe((result: any[]) => {
      this.categorias = result;
    });
  }

  ngOnInit() {
    this.updateCategoriasMostradas();
  }

  @HostListener('window:resize')
  onResize() {
    this.updateCategoriasMostradas();
  }

  updateCategoriasMostradas() {
    const width = window.innerWidth;

    let numCategorias;
    if (width <= 600) {
      numCategorias = 6; // 2 filas x 3 columnas
    } else {
      numCategorias = this.categorias.length; // todas las categorías
    }

    this.categorias = this.categorias.slice(0, numCategorias);
  }
}
