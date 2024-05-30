import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Product } from '../models/product';

const base_url = environment.base_url;

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  constructor(private http: HttpClient) {}

  getProducts() {
    const endpoint = `${base_url}/products`;
    return this.http.get<Product[]>(endpoint);
  }

  saveProduct(product: any) {
    const endpoint = `${base_url}/products`;
    return this.http.post<Product[]>(endpoint, product);
  }

  getProductByName(name: any) {
    const endpoint = `${base_url}/products/filter/${name}`;
    return this.http.get<Product>(endpoint);
  }

  exportProduct() {
    const endpoint = `${base_url}/products/export/excel`;
    return this.http.get(endpoint, {
      responseType: 'blob',
    });
  }
}
