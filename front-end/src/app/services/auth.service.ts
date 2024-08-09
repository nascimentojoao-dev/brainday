import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private authUrl = 'http://localhost:8080/admin';

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
