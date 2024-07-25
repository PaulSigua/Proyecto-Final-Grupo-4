import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CategoriasContainerComponent } from './categorias-container.component';

describe('CategoriasContainerComponent', () => {
  let component: CategoriasContainerComponent;
  let fixture: ComponentFixture<CategoriasContainerComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CategoriasContainerComponent]
    });
    fixture = TestBed.createComponent(CategoriasContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
