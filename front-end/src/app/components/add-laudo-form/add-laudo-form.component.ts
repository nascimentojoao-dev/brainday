import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PacienteService } from 'src/app/services/paciente.service';

@Component({
  selector: 'app-add-laudo-form',
  templateUrl: './add-laudo-form.component.html',
  styleUrls: ['./add-laudo-form.component.css']
})
export class AddLaudoFormComponent implements OnInit {
  pacienteId!: number;
  laudo: { data: string, descricao: string } = { data: '', descricao: '' };

  constructor(
    private pacienteService: PacienteService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.pacienteId = +this.route.snapshot.params['id'];
  }

  adicionarLaudo(): void {
    if (this.laudo.data && this.laudo.descricao) {
      this.pacienteService.addLaudoToPaciente(this.pacienteId, this.laudo).subscribe({
        next: () => this.router.navigate(['/paciente', this.pacienteId]),
        error: (err) => console.error('Erro ao adicionar laudo:', err)
      });
    }
  }
}