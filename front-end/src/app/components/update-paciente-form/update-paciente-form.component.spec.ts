import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatePacienteFormComponent } from './update-paciente-form.component';

describe('UpdatePacienteFormComponent', () => {
  let component: UpdatePacienteFormComponent;
  let fixture: ComponentFixture<UpdatePacienteFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdatePacienteFormComponent]
    });
    fixture = TestBed.createComponent(UpdatePacienteFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
