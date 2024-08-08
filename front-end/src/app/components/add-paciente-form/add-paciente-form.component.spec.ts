import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddPacienteFormComponent } from './add-paciente-form.component';

describe('AddPacienteFormComponent', () => {
  let component: AddPacienteFormComponent;
  let fixture: ComponentFixture<AddPacienteFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddPacienteFormComponent]
    });
    fixture = TestBed.createComponent(AddPacienteFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
