import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-categorias-card',
  templateUrl: './categorias-card.component.html',
  styleUrls: ['./categorias-card.component.scss']
})
export class CategoriasCardComponent {
  @Input() categoria?: any;
}
