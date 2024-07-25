import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ProductoService } from 'src/app/services/producto.service';

@Component({
  selector: 'app-tendencias-container',
  templateUrl: './tendencias-container.component.html',
  styleUrls: ['./tendencias-container.component.scss']
})
export class TendenciasContainerComponent implements OnInit{
  productos: any[] = [];
  @ViewChild('containerEtiquetas') containerEtiquetas: ElementRef;
  constructor(private _productosService: ProductoService, containerEtiquetas: ElementRef) {
    this.containerEtiquetas = containerEtiquetas;
  }

  ngOnInit(): void {
    this._productosService.getProductos().subscribe(
      (data) => {
        this.productos = data;
      },
      (error) => {
        console.error('Error al obtener los productos:', error);
      })
  }

  scrollToRight() {
    const container = this.containerEtiquetas.nativeElement;
    container.scrollLeft += 400;
  }

  scrollToLeft() {
    const container = this.containerEtiquetas.nativeElement;
    container.scrollLeft -= 400;
  }
}
