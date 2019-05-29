export class Product {
  id: number;
  sku: string;
  name: string;
  price: number;

  constructor(id: number, sku: string, name: string, price: number) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.sku = sku;
  }
}
