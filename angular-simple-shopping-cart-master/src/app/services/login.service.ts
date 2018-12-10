import { Injectable } from "@angular/core";
import { HttpHeaders, HttpClient, HttpRequest, HttpResponse } from "@angular/common/http";
import { User } from "app/models/user";
import "rxjs/add/operator/map";
import "rxjs/add/operator/toPromise";

@Injectable()
export class LoginService {
  private BASE_URL: string = '/shopec';//"http://localhost:9090";
  // private headers: Headers = new Headers({'Content-Type': 'application/json'});

  constructor(private http: HttpClient){

  }
  public login(user: User){
    let headers = new HttpHeaders();
    headers = headers.set("Accept", "application/json");

    let url: string = `${this.BASE_URL}/account/login`;

    let base64Credential: string = btoa( user.username + ":" + user.password);
    headers = headers.set("Authorization", "Basic " + base64Credential);

    return this.http.get(url , {headers})
    .map((response) => {

    // login successful if there's a jwt token in the response
    let cuser  = response["principal"]; // the returned user object is a principal object
    
    if (cuser) {
      // store user details  in local storage to keep user logged in between page refreshes
      localStorage.setItem("currentUser", JSON.stringify(cuser));
    }
    return cuser;
  });

    // return this.http.post(url, user, {headers: this.headers}).toPromise();
  }

}
