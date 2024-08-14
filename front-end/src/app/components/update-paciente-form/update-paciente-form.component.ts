import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { PacienteService } from 'src/app/services/paciente.service';

@Component({
  selector: 'app-update-paciente-form',
  templateUrl: './update-paciente-form.component.html',
  styleUrls: ['./update-paciente-form.component.css']
})
export class UpdatePacienteFormComponent implements OnInit{

  updatePacienteForm: FormGroup
  pacienteId!: number

  constructor(
    private fb: FormBuilder,
    private pacienteService: PacienteService,
    private route: ActivatedRoute,
    private router: Router
  ) {
    this.updatePacienteForm = this.fb.group({
      nome: ['', Validators.required],
      dataNascimento: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.pacienteId = +this.route.snapshot.paramMap.get('id')!
    this.loadPacienteData()
  }

  private loadPacienteData(): void {
    this.pacienteService.getPacienteById(this.pacienteId).subscribe(paciente => {
      this.updatePacienteForm.setValue({
        nome: paciente.nome,
        dataNascimento: paciente.dataNascimento
      });
    });
  }

  onSubmit(): void {
    if (this.updatePacienteForm.valid) {
      const updatedPaciente = this.updatePacienteForm.value;
      this.pacienteService.updatePaciente(this.pacienteId, updatedPaciente).subscribe(() => {
        this.router.navigate(['/pacientes']);
      });

    }
  }
}