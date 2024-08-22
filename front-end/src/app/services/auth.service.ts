import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private authUrl = `${environment.apiUrl}/admin`;


  constructor(private router: Router, private http: HttpClient) { }

  login(username: string, password: string): Observable<string> {
    const headers = new HttpHeaders({
      'Authorization': 'Basic ' + btoa(username + ':' + password)
    });

    return this.http.get(this.authUrl, { headers, responseType: 'text' });
  }

  logout() {
    localStorage.removeItem('authToken');
    this.router.navigate(['/login']).then(() => {
      window.location.reload();
    });
  }

  isAuthenticated() {
    if (localStorage.getItem('authToken')) {
      return true
    } else {
      return false
    }
  }
}
