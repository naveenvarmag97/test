import { ChangeDetectionStrategy, Component, OnInit, ElementRef } from "@angular/core";
import { Product } from "app/models/product.model";
import { ShoppingCart } from "app/models/shopping-cart.model";
import { ProductsDataService } from "app/services/products.service";
import { ShoppingCartService } from "app/services/shopping-cart.service";
import { Observable } from "rxjs/Observable";
import { Observer } from "rxjs/Observer";
import { TemplateRef } from "@angular/core/src/linker/template_ref";


@Component({
  changeDetection: ChangeDetectionStrategy.OnPush,
  selector: "app-store-front",
  styleUrls: ["./store-front.component.scss"],
  templateUrl: "./store-front.component.html"
})
export class StoreFrontComponent implements OnInit {
  public products: Observable<Product[]>;
  
  
  public constructor(private productsService: ProductsDataService,
                     private shoppingCartService: ShoppingCartService,
                    private elr:ElementRef) {
  }

  public addProductToCart(product: Product): void {
    this.shoppingCartService.addItem(product, 1);
    this.calculateTotalProductFromCart(product);
  }

  public removeProductFromCart(product: Product): void {
    this.shoppingCartService.addItem(product, -1);
    this.calculateTotalProductFromCart(product);
  }

  public calculateTotalProductFromCart(product: Product): void {
    let itemName = "product"+product.id+"";
    let elh:HTMLElement = document.getElementById(itemName);
    elh.innerText = this.shoppingCartService.getItemCount(product)+"";
  }

  public productInCart(product: Product): boolean {
    return Observable.create((obs: Observer<boolean>) => {
      const sub = this.shoppingCartService
                      .get()
                      .subscribe((cart) => {
                        obs.next(cart.items.some((i) => i.productId === product.id));
                        obs.complete();
                      });
      sub.unsubscribe();
    });
  }

  public ngOnInit(): void {
    this.products = this.productsService.all();
  }
}
