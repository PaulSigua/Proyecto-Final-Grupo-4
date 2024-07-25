import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NotLoggedComponent } from './not-logged.component';

describe('NotLoggedComponent', () => {
  let component: NotLoggedComponent;
  let fixture: ComponentFixture<NotLoggedComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NotLoggedComponent]
    });
    fixture = TestBed.createComponent(NotLoggedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
