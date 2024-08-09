import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string = '';
  password: string = '';
  errorMessage: string | null = null;

  constructor(private authService: AuthService, private router: Router) { }

  onLogin() {
    this.authService.login(this.username, this.password).subscribe({
      next: (res) => {
        if (res === 'Bem vindo ao painel de Doutor!'){
          this.errorMessage = null;
          localStorage.setItem('authToken', btoa(this.username + ':' + this.password));
          this.router.navigate(['/pacientes']);
        } else {
          this.errorMessage = 'Username ou senha inválidos. Tente novamente.';
        }
      },
      error: (err) => {
        this.errorMessage = 'Erro de comunicação com o servidor. Tente novamente.';
        console.error('Erro de login:', err);
      }
    });
  }
}
