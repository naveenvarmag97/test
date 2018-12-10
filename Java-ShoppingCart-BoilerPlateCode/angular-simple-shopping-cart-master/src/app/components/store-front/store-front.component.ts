import { ChangeDetectionStrategy, Component, OnInit, ElementRef } from "@angular/core";
import { Product } from "app/models/product.model";

import { ProductsDataService } from "app/services/products.service";

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
                     
                    private elr:ElementRef) {
  }







  public ngOnInit(): void {
    this.products = this.productsService.all();
  }
}
