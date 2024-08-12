import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PacientesListComponent } from './components/pacientes-list/pacientes-list.component';
import { PacienteDetailsComponent } from './components/paciente-details/paciente-details.component';
import { AddPacienteFormComponent } from './components/add-paciente-form/add-paciente-form.component';
import { UpdatePacienteFormComponent } from './components/update-paciente-form/update-paciente-form.component';
import { LoginComponent } from './pages/login/login.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http"
import { AuthInterceptor } from './auth.interceptor';
import { AddLaudoFormComponent } from './components/add-laudo-form/add-laudo-form.component';

@NgModule({
  declarations: [
    AppComponent,
    PacientesListComponent,
    PacienteDetailsComponent,
    AddPacienteFormComponent,
    UpdatePacienteFormComponent,
    AddLaudoFormComponent,
    LoginComponent,
    NavbarComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
