

export class Product {
  public id: number;
  public code: string;
  public name: string;
  public description: string;
  public price: number;
  public quantity: number;
 // public ingredients: Ingredient[];

  public updateFrom(src: Product): void {
    this.id = src.id;
    this.code = src.code;
    this.name = src.name;
    this.description = src.description;
    this.price = src.price;
    this.quantity = src.quantity;
    /*this.ingredients = src.ingredients.map((i) => {
      let ingredient = new Ingredient();
      ingredient.updateFrom(i);
      return ingredient;
    });*/
  }
}
