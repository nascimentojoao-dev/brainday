import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PacienteService } from 'src/app/services/paciente.service';

@Component({
  selector: 'app-paciente-details',
  templateUrl: './paciente-details.component.html',
  styleUrls: ['./paciente-details.component.css']
})
export class PacienteDetailsComponent implements OnInit {
  paciente: any = {};
  id: number | null = null;

  constructor(
    private route: ActivatedRoute,
    private pacienteService: PacienteService,
    private router: Router
  ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.params['id']

    if (id) {
      this.id = +id;
      this.loadPacienteDetails(this.id);
    }
  }

  loadPacienteDetails(id: number): void {
    this.pacienteService.getPacienteById(id).subscribe({
      next: (res) => {
        this.paciente = res;
      },
      error: (error) => {
        console.error('Erro ao carregar paciente:', error)
      }
    })
  }

  deleteLaudo(id: number): void {
    this.pacienteService.deleteLaudoByLaudoId(id)
      .subscribe({
        next: () => {
          this.loadPacienteDetails(this.paciente.id)
        }
      })
  }

  navigateToAddLaudo() {
    const pacienteId = this.paciente.id
    this.router.navigate(['/add-laudo', pacienteId])
  }
}
