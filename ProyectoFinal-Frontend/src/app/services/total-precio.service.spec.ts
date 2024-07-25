import { TestBed } from '@angular/core/testing';

import { TotalPrecioService } from './total-precio.service';

describe('TotalPrecioService', () => {
  let service: TotalPrecioService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TotalPrecioService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
