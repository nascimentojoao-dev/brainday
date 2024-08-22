import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class PacienteService {

  private apiUrl = `${environment.apiUrl}/admin`;

  constructor(private http: HttpClient) { }

  getPacientes(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/pacientes`);
  }

  deletePaciente(id: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/pacientes/${id}`)
  }

  addPaciente(paciente: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/pacientes`, paciente);
  }

  getPacienteById(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/pacientes/${id}`);
  }

  addLaudoToPaciente(pacienteId: number, laudo: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/laudos/${pacienteId}`, laudo);
  }

  updatePaciente(pacienteId: number, paciente: any): Observable<any>{
    return this.http.put(`${this.apiUrl}/pacientes/${pacienteId}`, paciente)
  }
}
