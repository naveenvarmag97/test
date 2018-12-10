import { inject, TestBed } from "@angular/core/testing";

import { LoginService } from "../login.service";
import { User } from "app/models/user";
import { HttpClientModule } from "@angular/common/http";

let loginService:LoginService;
let mockUser ;
//let user;
let responsePropertyNames, expectedPropertyNames;
describe("LoginService", () => {
  
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LoginService],
      imports: [HttpClientModule]
    });
  });


      it("should return a User model instance when the observable is subscribed to",
              inject([LoginService], (service: LoginService) => {
                let cuser ={ "username":"User1@g.com",
                "password":"password"};
             const obs = service.login(cuser);
             obs.subscribe((user) => {
               expect(user).toEqual(jasmine.any(User));
               expect(user.password).toEqual("password");
               expect(user.firstName).toEqual("Jack");
               
             });
           }));
  

});
