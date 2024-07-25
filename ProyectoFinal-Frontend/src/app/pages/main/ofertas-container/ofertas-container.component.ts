import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ProductoService } from 'src/app/services/producto.service';

@Component({
  selector: 'app-ofertas-container',
  templateUrl: './ofertas-container.component.html',
  styleUrls: ['./ofertas-container.component.scss']
})
export class OfertasContainerComponent implements OnInit{
  productos: any[] = [];
  @ViewChild('containerEtiquetas') containerEtiquetas: ElementRef;
  constructor(private _productosService: ProductoService, containerEtiquetas: ElementRef) {
    this.containerEtiquetas = containerEtiquetas;
    this._productosService.getProductos().subscribe((productos: any[]) => {
      this.productos = productos;
    });
  }

  ngOnInit(): void {
    this._productosService.getOfertas().subscribe(
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
