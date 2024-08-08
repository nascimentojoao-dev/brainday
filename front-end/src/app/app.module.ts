import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar/navbar.component';
import { PacientesListComponent } from './components/pacientes-list/pacientes-list.component';
import { PacienteDetailsComponent } from './components/paciente-details/paciente-details.component';
import { AddPacienteFormComponent } from './components/add-paciente-form/add-paciente-form.component';
import { UpdatePacienteFormComponent } from './components/update-paciente-form/update-paciente-form.component';
import { LoginComponent } from './pages/login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    PacientesListComponent,
    PacienteDetailsComponent,
    AddPacienteFormComponent,
    UpdatePacienteFormComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
