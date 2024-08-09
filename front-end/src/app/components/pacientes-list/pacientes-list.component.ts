import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PacienteService } from 'src/app/services/paciente.service';

@Component({
  selector: 'app-pacientes-list',
  templateUrl: './pacientes-list.component.html',
  styleUrls: ['./pacientes-list.component.css']
})
export class PacientesListComponent implements OnInit {
  pacientes: any[] = [];
  searchId: string = '';

  constructor(private pacienteService: PacienteService, private router: Router) { }

  ngOnInit(): void {
    this.loadPacientes();
  }

  loadPacientes(): void {
    this.pacienteService.getPacientes().subscribe(data => {
      this.pacientes = data;
    });
  }

  navigateToAdd(): void {
    this.router.navigate(['/add-paciente']);
  }

  editPaciente(id: number): void {
    this.router.navigate(['/edit-paciente', id]);
  }

  deletePaciente(id: number): void {
    if (confirm('Tem certeza que deseja excluir este paciente?')) {
      this.pacienteService.deletePaciente(id).subscribe(() => {
        this.loadPacientes();
      });
    }
  }

  searchPaciente(): void {
    if (this.searchId) {
      this.router.navigate(['/paciente', this.searchId]);
    }
  }

  viewDetails(id: number): void{
    this.router.navigate(['/paciente', id])
  }
}
