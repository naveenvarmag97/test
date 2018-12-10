import { TestBed, inject, fakeAsync, tick } from '@angular/core/testing';

import { AuthenticationService, Credentials} from './authentication.service';
import { AuthcredentialstoreService } from './authcredentialstore.service';

const credentialsKey = 'credentials';

describe('AuthenticationService', () => {
  let authenticationService: AuthenticationService;
  let authstore: AuthcredentialstoreService;



  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AuthenticationService]
    });
  });

  beforeEach(inject([
    AuthenticationService
  ], (_authenticationService: AuthenticationService, _authstore: AuthcredentialstoreService) => {
    authenticationService = _authenticationService;
    authstore = _authstore;
  }));

  afterEach(() => {
    // Cleanup
    localStorage.removeItem(credentialsKey);
    sessionStorage.removeItem(credentialsKey);
  });

  describe('login', () => {
    it('should return credentials', fakeAsync(() => {
      // Act
      const request = authenticationService.login({
        username: 'toto',
        password: '123'
      });
      tick();

      // Assert
      request.subscribe(credentials => {
        expect(credentials).toBeDefined();
        expect(credentials.token).toBeDefined();
      });
    }));

    it('should authenticate user', fakeAsync(() => {
      expect(authstore.isAuthenticated()).toBe(false);

      // Act
      const request = authenticationService.login({
        username: 'toto',
        password: '123'
      });
      tick();

      // Assert
      request.subscribe(() => {
        expect(authstore.isAuthenticated()).toBe(true);
        expect(authstore.credentials).toBeDefined();
        expect(authstore.credentials).not.toBeNull();
        expect((<Credentials>authstore.credentials).token).toBeDefined();
        expect((<Credentials>authstore.credentials).token).not.toBeNull();
      });
    }));

    it('should persist credentials for the session', fakeAsync(() => {
      // Act
      const request = authenticationService.login({
        username: 'toto',
        password: '123'
      });
      tick();

      // Assert
      request.subscribe(() => {
        expect(sessionStorage.getItem(credentialsKey)).not.toBeNull();
      });
    }));

    it('should persist credentials across sessions', fakeAsync(() => {
      // Act
      const request = authenticationService.login({
        username: 'toto',
        password: '123',
        remember: true
      });
      tick();

      // Assert
      request.subscribe(() => {
        expect(localStorage.getItem(credentialsKey)).not.toBeNull();
      });
    }));
  });

  describe('logout', () => {
    it('should clear user authentication', fakeAsync(() => {
      // Arrange
      const loginRequest = authenticationService.login({
        username: 'toto',
        password: '123'
      });
      tick();

      // Assert
      loginRequest.subscribe(() => {
        expect(authstore.isAuthenticated()).toBe(true);

        const request = authenticationService.logout();
        tick();

        request.subscribe(() => {
          expect(authstore.isAuthenticated()).toBe(false);
          expect(authstore.credentials).toBeNull();
          expect(sessionStorage.getItem(credentialsKey)).toBeNull();
          expect(localStorage.getItem(credentialsKey)).toBeNull();
        });
      });
    }));

    it('should clear persisted user authentication', fakeAsync(() => {
      // Arrange
      const loginRequest = authenticationService.login({
        username: 'toto',
        password: '123',
        remember: true
      });
      tick();

      // Assert
      loginRequest.subscribe(() => {
        expect(authstore.isAuthenticated()).toBe(true);

        const request = authenticationService.logout();
        tick();

        request.subscribe(() => {
          expect(authstore.isAuthenticated()).toBe(false);
          expect(authstore.credentials).toBeNull();
          expect(sessionStorage.getItem(credentialsKey)).toBeNull();
          expect(localStorage.getItem(credentialsKey)).toBeNull();
        });
      });
    }));
  });
});
