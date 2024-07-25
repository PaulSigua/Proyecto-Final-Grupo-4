import { Component } from '@angular/core';

@Component({
  selector: 'app-carrusel',
  templateUrl: './carrusel.component.html',
  styleUrls: ['./carrusel.component.scss']
})
export class CarruselComponent {
  currentIndex = 0;
  images = [
    '/assets/img/carrusel/descuentos.png',
    '/assets/img/carrusel/1.jpg',
    '/assets/img/carrusel/2.jpg',
    '/assets/img/carrusel/3.jpg'
  ];
  touchStartX = 0;
  touchEndX = 0;

  constructor() {}

  setTouchStartX(event: TouchEvent) {
    this.touchStartX = event.touches[0].clientX;
  }

  setTouchEndX(event: TouchEvent) {
    this.touchEndX = event.changedTouches[0].clientX;
    this.handleTouchMove();
  }

  handleTouchMove() {
    if (this.touchStartX - this.touchEndX > 75) {
      // Deslizar hacia la izquierda
      this.next();
    } else if (this.touchEndX - this.touchStartX > 75) {
      // Deslizar hacia la derecha
      this.previous();
    }
  }

  next() {
    this.currentIndex = (this.currentIndex + 1) % this.images.length;
  }

  previous() {
    this.currentIndex = (this.currentIndex + this.images.length - 1) % this.images.length;
  }
}
