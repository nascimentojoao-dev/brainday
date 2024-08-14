import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PacienteService {

  private apiUrl = 'http://localhost:8080/admin';

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
