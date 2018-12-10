import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { Http } from '@angular/http';
import { environment } from '../../../environments/environment';
import { AuthcredentialstoreService } from './authcredentialstore.service';
import * as decode from 'jwt-decode';

export interface Credentials {
  // Customize received credentials here
  username: string;
  token: string;
}

export interface LoginContext {
  username: string;
  password: string;
  remember?: boolean;
}


// const credentialsKey = 'credentials';

/**
 * Provides a base for authentication workflow.
 * The Credentials interface as well as login/logout methods should be replaced with proper implementation.
 */
@Injectable()
export class AuthenticationService {

  // private _credentials: Credentials | null;

  constructor(private http: Http, private authstore: AuthcredentialstoreService) {
    // const savedCredentials = sessionStorage.getItem(credentialsKey) || localStorage.getItem(credentialsKey);
    // if (savedCredentials) {
    //   this._credentials = JSON.parse(savedCredentials);
    // }
  }

  /**
   * Authenticates the user.
   * @param {LoginContext} context The login parameters.
   * @return {Observable<Credentials>} The user credentials.
   */
  login(context: LoginContext): Observable<Credentials> {

    const postData = 'userName=' + encodeURIComponent(context.username)
      + '&password=' + encodeURIComponent(context.password)
      + '&grant_type=password';

    const data = {
      username: context.username,
      token: '',
      userid: '',
      role: 0,
      empid: '',
      email: '',
      name: ''
    };

    console.log(postData);
    return this.http.post('oauth/token', postData).map((response) => {
      const responseData = response.json();
      data.token = responseData.access_token;
      const decodedtoken = decode(responseData.access_token);
      Object.assign(data, decodedtoken);
      this.authstore.setCredentials(data, context.remember);
      return responseData;
    });
  }

  /**
   * Logs out the user and clear credentials.
   * @return {Observable<boolean>} True if the user was logged out successfully.
   */
  logout(): Observable<boolean> {
    // Customize credentials invalidation here
    this.authstore.setCredentials();
    return of(true);
  }

  // /**
  //  * Checks is the user is authenticated.
  //  * @return {boolean} True if the user is authenticated.
  //  */
  // isAuthenticated(): boolean {
  //   return !!this.credentials;
  // }

  // /**
  //  * Gets the user credentials.
  //  * @return {Credentials} The user credentials or null if the user is not authenticated.
  //  */
  // get credentials(): Credentials | null {
  //   return this._credentials;
  // }

  // /**
  //  * Sets the user credentials.
  //  * The credentials may be persisted across sessions by setting the `remember` parameter to true.
  //  * Otherwise, the credentials are only persisted for the current session.
  //  * @param {Credentials=} credentials The user credentials.
  //  * @param {boolean=} remember True to remember credentials across sessions.
  //  */
  // private setCredentials(credentials?: Credentials, remember?: boolean) {
  //   this._credentials = credentials || null;

  //   if (credentials) {
  //     const storage = remember ? localStorage : sessionStorage;
  //     storage.setItem(credentialsKey, JSON.stringify(credentials));
  //   } else {
  //     sessionStorage.removeItem(credentialsKey);
  //     localStorage.removeItem(credentialsKey);
  //   }
  // }

}
