import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TotalPrecioComponent } from './total-precio.component';

describe('TotalPrecioComponent', () => {
  let component: TotalPrecioComponent;
  let fixture: ComponentFixture<TotalPrecioComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TotalPrecioComponent]
    });
    fixture = TestBed.createComponent(TotalPrecioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
