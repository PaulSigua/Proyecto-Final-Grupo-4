import { Injectable } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FormBuilderService {
  private data = new BehaviorSubject<any>(null);
  sharedData = this.data.asObservable();

  constructor() { }

  updateData(data: any) {
    this.data.next(data);
  }
}
