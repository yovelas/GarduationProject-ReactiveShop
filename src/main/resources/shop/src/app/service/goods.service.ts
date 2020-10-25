import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class GoodsService {

  constructor() { }
  domain = "http://localhost:8080/";
  navControl:boolean = false;
  goodsListReload:boolean = true;
  order;


}
