import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";


import { StoreFrontComponent } from "./components/store-front/store-front.component";


@NgModule({
    exports: [RouterModule],
    imports: [
        RouterModule.forRoot([
            {

                component: StoreFrontComponent,
                path: "home"
            },
            {
                component: StoreFrontComponent,
                path: "**"
            }])
    ]
})
export class AppRoutingModule { }
