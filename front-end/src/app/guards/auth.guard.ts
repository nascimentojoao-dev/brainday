import { ActivatedRouteSnapshot, CanActivateFn, Router, RouterStateSnapshot } from '@angular/router';
import { inject } from '@angular/core';
import { AuthService } from '../services/auth.service';

export const authGuard: CanActivateFn = (route: ActivatedRouteSnapshot, state: RouterStateSnapshot) => {

  const authService: AuthService = inject(AuthService)
  const router: Router = inject(Router)

  if (authService.isAuthenticated()) {
    return true;
  } else {
    return router.navigate(["/login"])
  }
};