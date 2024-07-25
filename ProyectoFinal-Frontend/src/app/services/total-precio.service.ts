import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TotalPrecioService {

  private precioTotalSubject: BehaviorSubject<number> = new BehaviorSubject<number>(0);
  precioTotal$: Observable<number> = this.precioTotalSubject.asObservable();

  constructor() {}

  setPrecioTotal(precioTotal: number): void {
    this.precioTotalSubject.next(precioTotal);
  }
}
