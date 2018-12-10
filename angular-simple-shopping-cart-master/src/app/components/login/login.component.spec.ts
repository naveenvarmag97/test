import { async, ComponentFixture, TestBed } from "@angular/core/testing";
import { FormsModule }   from '@angular/forms';
import { LoginComponent } from "./login.component";
import { LoginService } from "app/services/login.service";
import { HttpClientModule } from "@angular/common/http";
import { RouterTestingModule } from '@angular/router/testing';
import { ShoppingCartService } from "app/services/shopping-cart.service";
describe("LoginComponent", () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginComponent ],
      providers: [LoginService,ShoppingCartService],
      imports: [ FormsModule, HttpClientModule,RouterTestingModule ],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });
});
