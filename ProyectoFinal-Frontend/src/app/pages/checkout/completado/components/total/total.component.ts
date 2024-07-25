import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { Factura } from 'src/app/models/factura';

@Component({
  selector: 'app-total',
  templateUrl: './total.component.html',
  styleUrls: ['./total.component.scss']
})
export class TotalComponent {
  @Input() factura?: Factura;

  constructor(private router: Router) { }


  segirComprando() {
    localStorage.removeItem('subtotal');
    this.router.navigate(['/home']);

  }
}

