import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';

// import { Logger } from '../logger.service';
import { AuthenticationService } from './authentication.service';
import { AuthcredentialstoreService } from './authcredentialstore.service';

// const log = new Logger('AuthenticationGuard');

@Injectable()
export class AuthenticationGuard implements CanActivate {

  constructor(private router: Router,
              private authStore: AuthcredentialstoreService) { }

  canActivate(): boolean {
    if (this.authStore.isAuthenticated()) {
      return true;
    }

    // log.debug('Not authenticated, redirecting...');
    this.router.navigate(['/login'], { replaceUrl: true });
    return false;
  }

}