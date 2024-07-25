import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarritoContainerComponent } from './carrito-container.component';

describe('CarritoContainerComponent', () => {
  let component: CarritoContainerComponent;
  let fixture: ComponentFixture<CarritoContainerComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CarritoContainerComponent]
    });
    fixture = TestBed.createComponent(CarritoContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
