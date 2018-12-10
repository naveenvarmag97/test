export class DeliveryOption {
  public id: string;
  public name: string;
  public code: string;
  public description: string;
  public price: number;

  public updateFrom(src: DeliveryOption): void {
    this.id = src.id;
    this.name = src.name;
    this.code = src.code;
    this.description = src.description;
    this.price = src.price;
  }
}
