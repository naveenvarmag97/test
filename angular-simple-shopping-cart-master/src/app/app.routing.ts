import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";

import { CheckoutComponent } from "./components/checkout/checkout.component";
import { LoginComponent } from "./components/login/login.component";
import { OrderConfirmationComponent } from "./components/order-confirmation/order-confirmation.component";
import { StoreFrontComponent } from "./components/store-front/store-front.component";
import { PopulatedCartRouteGuard } from "./route-gaurds/populated-cart.route-gaurd";

@NgModule({
    exports: [RouterModule],
    imports: [
        RouterModule.forRoot([
            {

                component: StoreFrontComponent,
                path: "home"
            },
            {

                component: LoginComponent,
                path: "login"
            },
            {
                component: OrderConfirmationComponent,
                path: "orderconfirm/:orderNo"

            },
            {
                canActivate: [PopulatedCartRouteGuard],
                component: CheckoutComponent,
                path: "checkout"
            },
            {
                canActivate: [PopulatedCartRouteGuard],
                component: OrderConfirmationComponent,
                path: "confirmed"
            },
            {
                component: StoreFrontComponent,
                path: "**"
            }])
    ]
})
export class AppRoutingModule { }
