import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TendenciasContainerComponent } from './tendencias-container.component';

describe('TendenciasContainerComponent', () => {
  let component: TendenciasContainerComponent;
  let fixture: ComponentFixture<TendenciasContainerComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TendenciasContainerComponent]
    });
    fixture = TestBed.createComponent(TendenciasContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
