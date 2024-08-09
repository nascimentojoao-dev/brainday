import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor() { }

  intercept(req: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    const token = localStorage.getItem('authToken');
    
    if (token) {
      const authReq = req.clone({
        headers: req.headers.set('Authorization', 'Basic ' + token)
      });
      return next.handle(authReq);
    } else {
      return next.handle(req);
    }
  }
}
