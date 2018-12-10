import { CartItem } from "../models/cart-item.model";

export class ShoppingCart {
  public userId: number;
  public items: CartItem[] = new Array<CartItem>();
  public deliveryOptionId: string;
  public deliveryOptionCode: string;
  public grossTotal: number = 0;
  public deliveryTotal: number = 0;
  public itemsTotal: number = 0;

  public updateFrom(src: ShoppingCart) {
    this.userId = src.userId;
    this.items = src.items;
    this.deliveryOptionId = src.deliveryOptionId;
    this.deliveryOptionCode = src.deliveryOptionCode;
    this.grossTotal = src.grossTotal;
    this.deliveryTotal = src.deliveryTotal;
    this.itemsTotal = src.itemsTotal;
  }
}
