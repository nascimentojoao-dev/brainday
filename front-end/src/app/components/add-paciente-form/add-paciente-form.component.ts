import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { PacienteService } from 'src/app/services/paciente.service';

@Component({
  selector: 'app-add-paciente-form',
  templateUrl: './add-paciente-form.component.html',
  styleUrls: ['./add-paciente-form.component.css']
})
export class AddPacienteFormComponent {
  paciente: any = {
    nome: '',
    dataNascimento: ''
  };

  constructor(private pacienteService: PacienteService, private router: Router) {}

  onSubmit(): void {
    this.pacienteService.addPaciente(this.paciente).subscribe(() => {
      this.router.navigate(['/pacientes']);
    });
  }

  goBack(): void {
    this.router.navigate(['/pacientes']);
  }
}