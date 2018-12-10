import { Injectable } from "@angular/core";
import { HttpHeaders, HttpClient , HttpParams, HttpRequest, HttpResponse } from "@angular/common/http";
import { StorageService } from "app/services/storage.service";
import "rxjs/add/observable/throw";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import "rxjs/add/operator/toPromise";
import { Observable } from "rxjs/Observable";
import { Observer } from "rxjs/Observer";
import { CartItem } from "../models/cart-item.model";
import { DeliveryOption } from "../models/delivery-option.model";
import { Product } from "../models/product.model";
import { ShoppingCart } from "../models/shopping-cart.model";
import { User } from "../models/user";
import { DeliveryOptionsDataService } from "../services/delivery-options.service";
import { ProductsDataService } from "../services/products.service";


const CART_KEY = "cart";
const BASE_URL = "/shopec";//"http://localhost:9090";

@Injectable()
export class ShoppingCartService {

  private storage: Storage;
  private subscriptionObservable: Observable<ShoppingCart>;
  private subscribers: Array<Observer<ShoppingCart>> = new Array<Observer<ShoppingCart>>();
  private products: Product[];
  private deliveryOptions: DeliveryOption[];
  private currentuser : User;

  public constructor(private storageService: StorageService,
                     private productService: ProductsDataService,
                     private deliveryOptionsService: DeliveryOptionsDataService,
                     private http: HttpClient
                     ) {

    this.storage = this.storageService.get();
    this.productService.all().subscribe((products) => this.products = products);
    this.deliveryOptionsService.all().subscribe((options) => this.deliveryOptions = options);

    this.subscriptionObservable = new Observable<ShoppingCart>((observer: Observer<ShoppingCart>) => {
      this.subscribers.push(observer);
      observer.next(this.retrieve());
      return () => {
        this.subscribers = this.subscribers.filter((obs) => obs !== observer);
      };
    });
  }

  public get(): Observable<ShoppingCart> {

    return this.subscriptionObservable;
  }

  public getItemCount(product: Product): number{
    const cart = this.retrieve();
    let item = cart.items.find((p) => p.productId === product.id);
    if( item !== undefined)
      return item.quantity;

    return 0;
  }
  public addItem(product: Product, quantity: number): void {
    const cart = this.retrieve();
    let item = cart.items.find((p) => p.productId === product.id);
    if (item === undefined) {
      item = new CartItem();
      item.productId = product.id;
      cart.items.push(item);
    }

    item.quantity += quantity;
    
    cart.items = cart.items.filter((cartItem) => cartItem.quantity > 0);
    if (cart.items.length === 0) {
      cart.deliveryOptionId = undefined;
    }
    
   

    this.calculateCart(cart);
    this.save(cart);
    this.dispatch(cart);
  }



  public empty(): void {
    const cart = this.retrieve();
    const newCart = new ShoppingCart();
    this.save(newCart);
    this.dispatch(newCart);
  }

  public setDeliveryOption(deliveryOption: DeliveryOption): void {
    const cart = this.retrieve();
    cart.deliveryOptionId = deliveryOption.id;
    cart.deliveryOptionCode = deliveryOption.code;
    this.calculateCart(cart);
    this.save(cart);
    this.dispatch(cart);
  }

  public placeOrder() {
    this.currentuser = JSON.parse(localStorage.getItem("currentUser"));

    const cart = this.retrieve();

    cart.userId =  this.currentuser.id;

    let headers:HttpHeaders = new HttpHeaders();
    headers = headers.set("Accept", "application/json");

    let url: string = `${BASE_URL}/order/create`;

    let base64Credential: string = btoa( this.currentuser.username + ":" + this.currentuser.password);
    headers = headers.set("Authorization", "Basic " + base64Credential);

    // let options = {
    //   params: new HttpParams()
    // };
    // options.headers = headers;

    return this.http.post(url, cart, {headers})
              .map(this.extractData)
              .catch(this.handleErrorObservable);
      /*        alert(this.http);
              return this.http.get(BASE_URL+'products/list')//.post(BASE_URL +"order/create", JSON.stringify(cart), options)
              .map((res: Response) => res.json()).catch(err => Observable.throw(err));
                         //.map(this.extractData);
                         //.catch(this.handleErrorObservable);   */
 }

  private extractData(res: Response) {
    let body = res;
    return body || {};
  }

  private handleErrorObservable (error: Response | any) {
    console.error(error.message || error);
    return Observable.throw(error.message || error);
  }

  private calculateCart(cart: ShoppingCart): void {
    cart.itemsTotal = cart.items
                          .map((item) => item.quantity * this.products.find((p) => p.id === item.productId).price)
                          .reduce((previous, current) => previous + current, 0);
    cart.deliveryTotal = cart.deliveryOptionId ?
                          this.deliveryOptions.find((x) => x.id === cart.deliveryOptionId).price :
                          0;
    cart.grossTotal = cart.itemsTotal + cart.deliveryTotal;
  }

  public retrieve(): ShoppingCart {
    const cart = new ShoppingCart();
    const storedCart = this.storage.getItem(CART_KEY);
    if (storedCart) {
      cart.updateFrom(JSON.parse(storedCart));
    }

    return cart;
  }

  private save(cart: ShoppingCart): void {
    this.storage.setItem(CART_KEY, JSON.stringify(cart));
  }

  private dispatch(cart: ShoppingCart): void {
    this.subscribers
        .forEach((sub) => {
          try {
            sub.next(cart);
          } catch (e) {
            // we want all subscribers to get the update even if one errors.
          }
        });
  }
}
