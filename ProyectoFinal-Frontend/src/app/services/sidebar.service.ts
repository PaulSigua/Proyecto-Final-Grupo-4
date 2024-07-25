import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SidebarService {
  private isOpen = new BehaviorSubject<boolean>(false);

  public sidebarState = this.isOpen.asObservable();

  constructor() { }

  open() {
    this.isOpen.next(true);
  }

  close() {
    this.isOpen.next(false);
  }

  toggle() {
    this.isOpen.next(!this.isOpen.value);
  }
}
