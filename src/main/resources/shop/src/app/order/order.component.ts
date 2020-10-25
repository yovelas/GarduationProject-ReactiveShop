import { Component, OnInit } from '@angular/core';
import { GoodsService } from '../service/goods.service';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';
import { Location } from '@angular/common'
import * as $ from 'jquery';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  constructor(
    private Router: Router,
    private location: Location,
    private goodsService: GoodsService,
    private userService: UserService
  ) { }

  ngOnInit(): void {
    var _this = this;
    console.log(this.goodsService.order);
    // 若没有订单数据则返回上一个路由
    if(!this.goodsService.order){
      this.location.back();
    }

    var infoSection = document.querySelector("section#info");
    var infoArtilce = infoSection.querySelector("article");
    var cloneInfoSection = infoArtilce.cloneNode(true);

    for(var j = infoSection.childElementCount; j > 0; j--) {  // 清空已有的子节点
      infoSection.removeChild(infoSection.childNodes[j-1]);
    }

    this.userService.user.userContact.forEach(function(contact,index){
      var df = new DocumentFragment();
      df.appendChild(cloneInfoSection.cloneNode(true));
      var Ps = df.querySelectorAll("p");
      Ps[0].innerHTML = contact.userActualName;
      Ps[1].innerHTML = contact.userPhone;
      Ps[2].innerHTML = contact.userAddress;
      console.log(contact);
      if(index != 0){
        console.log(df.querySelector("i").remove());
      }else{
        document.querySelector("#address").innerHTML = contact.userAddress;
        document.querySelector("#phone").innerHTML = contact.userActualName +"  "+ contact.userPhone;
        _this.goodsService.order.userContactId = contact.userContactId;

      }
      infoSection.appendChild(df);
    })

    // 填充商品信息
    var goods = document.querySelector("#goods");
    goods.querySelector("img").src = this.goodsService.domain + "file/download/" + this.goodsService.order.goodsId.goodsPicture[0] + "/";
    goods.querySelectorAll("span")[0].innerHTML = this.goodsService.order.goodsId.goodsName;


    var infoDiv = goods.querySelector(".info");
    var param = infoDiv.querySelectorAll("span.param");
    var cloneParam = param[0].cloneNode(true);
    param.forEach(function(value){
      infoDiv.removeChild(value);
    });
    var parObj =JSON.parse(this.goodsService.order.goodsDataId.goodsConfiguration
      .replace(/\{/,"{\"")
      .replace(/\:/g,"\"\:\"")
      .replace(/\,/,"\"\,\"")
      .replace(/\}/,"\"}"));
      console.log(parObj);
    this.goodsService.order.goodsId.goodsParameter.forEach(function(parameter){
      console.log(parameter);
      var df = new DocumentFragment();
      df.appendChild(cloneParam.cloneNode(true));
      console.log(parObj[parameter.id]);
      parameter.goodsParameterOption.forEach(function(item){
        if(item.id == parObj[parameter.id])
        df.querySelector("span").innerHTML = parameter.goodsParameter + ": " + item.goodsOption;
        console.log(item.goodsOption);
      })
      infoDiv.insertBefore(df,infoDiv.querySelectorAll("span")[1])
    });

    infoDiv.querySelector(".price").innerHTML = "¥ "+ this.goodsService.order.goodsDataId.goodsPrice
    
    document.querySelector("#price").innerHTML = "¥ "+ this.goodsService.order.goodsDataId.goodsPrice

    infoDiv.querySelector("#amount").innerHTML = this.goodsService.order.shoppingNum;
    
  }

  submit(){
    var _this = this;
    console.log("aaaaaaa");
    this.goodsService.order.goodsDataId = this.goodsService.order.goodsDataId.id;
    this.goodsService.order.goodsId = this.goodsService.order.goodsId.goodsId;
    console.log(this.goodsService.order);
    $.ajax({
      type: "POST",
      url: _this.goodsService.domain+"order/",
      async: false,
      contentType: "application/json",
      dataType: "json",
      data: JSON.stringify(_this.goodsService.order),
      crossDomain: true,
      success: function (data) {
        console.log(data);
      },
      error: function () {}
    });


  }

}
