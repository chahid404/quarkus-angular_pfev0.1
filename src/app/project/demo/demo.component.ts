import { Component, OnInit } from '@angular/core';
import { Product } from './demo';
import { ProductService } from '../../services/product.service';

@Component({
  selector: 'app-demo',
  templateUrl: './demo.component.html',
  styleUrls: ['./demo.component.css']
})
export class DemoComponent implements OnInit {
  products: Product[];

  constructor(private productService: ProductService) { }
  ngOnInit(): void {
    this.productService.getProductsWithOrdersSmall().then(data => this.products = data);
  }
}
