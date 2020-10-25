import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';
import { GoodsService } from '../../service/goods.service';
import { UserService } from '../../service/user.service';
import { ActivatedRoute, Router} from '@angular/router'

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css']
})
export class PersonComponent implements OnInit {

  constructor(
    private goodService:GoodsService,
    private userService:UserService,
    private Route: ActivatedRoute,
    private Router: Router
  ) { }

  ngOnInit(): void {
    var _this = this;
    var data = _this.userService.user;
    document.querySelector("img").src = _this.goodService.domain+"/file/download/"+data.userPicture+"/";
    document.querySelector("#top span").innerHTML = data.userNickName;
    document.querySelector("#list ul li:nth-of-type(1)").innerHTML = data.userTrack.length;
    var day = (new Date().getTime() / 1000 - new Date(data.createTime).getTime() / 1000 ) / 60 /60 / 24;
    document.querySelector("#list ul:nth-of-type(2) li:nth-of-type(1)").innerHTML = Math.abs(parseInt(day.toFixed(1))).toString() + "天";
    var sum = 0,payment = [],deliver = [],receive = [],after = [];
    data.userOrders.forEach(function(order){
      if(order.orderStatus>1) sum += order.goodsConfiguration.goodsPrice;
      if(order.orderStatus ==1) payment.push(order);
      if(order.orderStatus ==2) deliver.push(order);
      if(order.orderStatus ==3) receive.push(order);
      if(order.orderStatus ==4) after.push(order);
    });
    document.querySelector("#list ul:nth-of-type(3) li:nth-of-type(1)").innerHTML = "¥ "+sum;
    
    var paymentSection =  document.querySelector("#payment section");
    var deliverSection =  document.querySelector("#deliver section");
    var receiveSection =  document.querySelector("#receive section");
    var afterSection =  document.querySelector("#after section");
    var paymentClone = paymentSection.childNodes[0].cloneNode(true);
    var deliverClone = deliverSection.childNodes[0].cloneNode(true);
    var receiveClone = receiveSection.childNodes[0].cloneNode(true);
    var afterClone = afterSection.childNodes[0].cloneNode(true);
    for(var j = paymentSection.childElementCount; j > 0; j--) {  // 清空已有的子节点
      paymentSection.removeChild(paymentSection.childNodes[j-1]);
    }
    for(var j = deliverSection.childElementCount; j > 0; j--) {  // 清空已有的子节点
      deliverSection.removeChild(deliverSection.childNodes[j-1]);
    }
    for(var j = receiveSection.childElementCount; j > 0; j--) {  // 清空已有的子节点
      receiveSection.removeChild(receiveSection.childNodes[j-1]);
    }
    for(var j = afterSection.childElementCount; j > 0; j--) {  // 清空已有的子节点
      afterSection.removeChild(afterSection.childNodes[j-1]);
    }

    payment.forEach(function(order){
      var paymentDf = new DocumentFragment();
      paymentDf.appendChild(paymentClone.cloneNode(true));
      paymentDf.querySelector("img").src = _this.goodService.domain + "file/download/" + order.goods.goodsPicture[0] + "/";
      paymentDf.querySelector("span").innerHTML = order.goods.goodsSubName;
      paymentSection.appendChild(paymentDf);
    })
    deliver.forEach(function(order){
      var deliverDf = new DocumentFragment();
      deliverDf.appendChild(deliverClone.cloneNode(true));
      deliverDf.querySelector("img").src = _this.goodService.domain + "file/download/" + order.goods.goodsPicture[0] + "/";
      deliverDf.querySelector("span").innerHTML = order.goods.goodsSubName;
      deliverSection.appendChild(deliverDf);
    })
    receive.forEach(function(order){
      var receiveDf = new DocumentFragment();
      receiveDf.appendChild(receiveClone.cloneNode(true));
      receiveDf.querySelector("img").src = _this.goodService.domain + "file/download/" + order.goods.goodsPicture[0] + "/";
      receiveDf.querySelector("span").innerHTML = order.goods.goodsSubName;
      receiveSection.appendChild(receiveDf);
    })
    after.forEach(function(order){
      var df = new DocumentFragment();
      df.appendChild(afterClone.cloneNode(true));
      df.querySelector("img").src = _this.goodService.domain + "file/download/" + order.goods.goodsPicture[0] + "/";
      df.querySelector("span").innerHTML = order.goods.goodsSubName;
      afterSection.appendChild(df);
    })
  }
}
