import { Injectable } from '@angular/core';


export interface Credentials {
  // Customize received credentials here
  username: string;
  token: string;
  userid: string;
  role: number;
  empid: string;
  email: string;
  name: string;
}

export enum UserType {
  FacilityManager= 1,
  Employee
}
const credentialsKey = 'credentials';

@Injectable()
export class AuthcredentialstoreService {

  private _credentials: Credentials | null;

  constructor() {
    const savedCredentials = sessionStorage.getItem(credentialsKey) || localStorage.getItem(credentialsKey);
    if (savedCredentials) {
      this._credentials = JSON.parse(savedCredentials);
    }

  }
  /**
     * Checks is the user is authenticated.
     * @return {boolean} True if the user is authenticated.
     */
  isAuthenticated(): boolean {
    return !!this.credentials;
  }

  isFacultyManager(): boolean {
    return this._credentials.role.toString() === UserType.FacilityManager.toString();
  }
  /**
   * Gets the user credentials.
   * @return {Credentials} The user credentials or null if the user is not authenticated.
   */
  get credentials(): Credentials | null {
    return this._credentials;
  }

  /**
   * Sets the user credentials.
   * The credentials may be persisted across sessions by setting the `remember` parameter to true.
   * Otherwise, the credentials are only persisted for the current session.
   * @param {Credentials=} credentials The user credentials.
   * @param {boolean=} remember True to remember credentials across sessions.
   */
  setCredentials(credentials?: Credentials, remember?: boolean) {
    this._credentials = credentials || null;

    if (credentials) {
      const storage = remember ? localStorage : sessionStorage;
      storage.setItem(credentialsKey, JSON.stringify(credentials));
    } else {
      sessionStorage.removeItem(credentialsKey);
      localStorage.removeItem(credentialsKey);
    }
  }
}

