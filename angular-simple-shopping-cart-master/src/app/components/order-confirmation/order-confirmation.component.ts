import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { ShoppingCartService } from "../../services/shopping-cart.service";

@Component({
  selector: "app-order-confirmation",
  templateUrl: "./order-confirmation.component.html"
})
export class OrderConfirmationComponent implements OnInit {
  private orderNo;
  public constructor(private shoppingCartService: ShoppingCartService,
                     private actRoute: ActivatedRoute) {}

  public ngOnInit(): void {
    this.orderNo = this.actRoute.snapshot.params.orderNo;
    this.shoppingCartService.empty();

  }
}
