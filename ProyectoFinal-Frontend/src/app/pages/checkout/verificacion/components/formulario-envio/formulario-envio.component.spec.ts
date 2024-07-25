import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormularioEnvioComponent } from './formulario-envio.component';

describe('FormularioEnvioComponent', () => {
  let component: FormularioEnvioComponent;
  let fixture: ComponentFixture<FormularioEnvioComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FormularioEnvioComponent]
    });
    fixture = TestBed.createComponent(FormularioEnvioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
