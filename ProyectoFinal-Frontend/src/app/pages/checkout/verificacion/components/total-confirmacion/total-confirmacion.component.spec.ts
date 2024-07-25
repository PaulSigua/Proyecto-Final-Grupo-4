import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TotalConfirmacionComponent } from './total-confirmacion.component';

describe('TotalConfirmacionComponent', () => {
  let component: TotalConfirmacionComponent;
  let fixture: ComponentFixture<TotalConfirmacionComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TotalConfirmacionComponent]
    });
    fixture = TestBed.createComponent(TotalConfirmacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
