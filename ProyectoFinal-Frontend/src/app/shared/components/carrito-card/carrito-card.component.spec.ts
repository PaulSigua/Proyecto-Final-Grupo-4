import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarritoCardComponent } from './carrito-card.component';

describe('CarritoCardComponent', () => {
  let component: CarritoCardComponent;
  let fixture: ComponentFixture<CarritoCardComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CarritoCardComponent]
    });
    fixture = TestBed.createComponent(CarritoCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
