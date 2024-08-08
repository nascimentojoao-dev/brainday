import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PacienteDetailsComponent } from './paciente-details.component';

describe('PacienteDetailsComponent', () => {
  let component: PacienteDetailsComponent;
  let fixture: ComponentFixture<PacienteDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PacienteDetailsComponent]
    });
    fixture = TestBed.createComponent(PacienteDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
