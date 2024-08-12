import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { PacientesListComponent } from './components/pacientes-list/pacientes-list.component';
import { authGuard } from './guards/auth.guard';
import { AddPacienteFormComponent } from './components/add-paciente-form/add-paciente-form.component';
import { UpdatePacienteFormComponent } from './components/update-paciente-form/update-paciente-form.component';
import { PacienteDetailsComponent } from './components/paciente-details/paciente-details.component';
import { AddLaudoFormComponent } from './components/add-laudo-form/add-laudo-form.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'pacientes', component: PacientesListComponent, canActivate: [authGuard] },
  { path: 'add-paciente', component: AddPacienteFormComponent, canActivate: [authGuard] },
  { path: 'edit-paciente', component: UpdatePacienteFormComponent, canActivate: [authGuard] },
  { path: 'paciente/:id', component: PacienteDetailsComponent, canActivate: [authGuard] },
  { path: 'add-laudo/:id', component: AddLaudoFormComponent, canActivate: [authGuard] },
  { path: '**', redirectTo: '/login' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
