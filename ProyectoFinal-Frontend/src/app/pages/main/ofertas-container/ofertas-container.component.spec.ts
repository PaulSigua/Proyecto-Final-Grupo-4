import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OfertasContainerComponent } from './ofertas-container.component';

describe('OfertasContainerComponent', () => {
  let component: OfertasContainerComponent;
  let fixture: ComponentFixture<OfertasContainerComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [OfertasContainerComponent]
    });
    fixture = TestBed.createComponent(OfertasContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
