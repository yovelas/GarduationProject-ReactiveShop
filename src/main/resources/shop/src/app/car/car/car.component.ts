import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';
import { ActivatedRoute, Router } from '@angular/router'
import { GoodsService } from '../../service/goods.service';
import { UserService } from '../../service/user.service';

@Component({
  selector: 'app-car',
  templateUrl: './car.component.html',
  styleUrls: ['./car.component.css']
})
export class CarComponent implements OnInit {

  constructor(
    private goodService:GoodsService,
    private userService:UserService,
    private Route: ActivatedRoute,
    private Router: Router
  ) { }

  ngOnInit(): void {
    var _this = this;
    $.ajax({
      type: "GET",
      url: _this.goodService.domain+"/shopping",
      async: false,
      contentType: "application/json",
      dataType: "json",
      crossDomain: true,
      success: function (data) {
        console.log(data);
        
        var section = document.querySelector("section");  // 查找父元素
        var article =  section.querySelector("article");  // 查找子元素

        var cloneArticle = article.cloneNode(true);     // Clone a node

        for(var j = section.childElementCount; j > 0; j--) {  // 清空已有的子节点
          section.removeChild(section.childNodes[j-1]);
        }
  
        for(var i = 0; i < data.length; i++){   // Fill data and append to parent node
          var df = new DocumentFragment();      // Create a DocumentFragment
          df.appendChild(cloneArticle.cloneNode(true));   // Append a node of cloned node above
          df.querySelector(".calc").setAttribute("goodsIndex",i.toString());

          df.childNodes[0].childNodes[1].childNodes[0].textContent = data[i].goodsSubName;         // File goodsSubName
          if(data[i].goodsConfiguration[0] != null)
          df.childNodes[0].childNodes[1].childNodes[1].textContent = data[i].goodsConfiguration[0].goodsParameter[0].goodsParameter +": "+ data[i].goodsConfiguration[0].goodsParameterOption[0].goodsOption;         // File goodsSubName
          else df.childNodes[0].childNodes[1].childNodes[1].textContent = "...";
          if(data[i].goodsConfiguration[1] != null)
          df.childNodes[0].childNodes[1].childNodes[2].textContent = data[i].goodsConfiguration[1].goodsParameter[0].goodsParameter +": "+ data[i].goodsConfiguration[1].goodsParameterOption[0].goodsOption;         // File goodsSubName
          else df.childNodes[0].childNodes[1].childNodes[3].textContent = "...";
          if(data[i].goodsConfiguration[2] != null)
          df.childNodes[0].childNodes[1].childNodes[3].textContent = data[i].goodsConfiguration[1].goodsParameter[0].goodsParameter +": "+ data[i].goodsConfiguration[2].goodsParameterOption[0].goodsOption;         // File goodsSubName
          else df.childNodes[0].childNodes[1].childNodes[3].textContent = "...";
          df.childNodes[0].childNodes[1].childNodes[4].childNodes[2].textContent = data[i].shoppingNum;         // File goodsSubName
          df.childNodes[0].childNodes[1].childNodes[5].textContent = "¥" + data[i].goodsPrice;         // File goodsSubName
          df.childNodes[0].childNodes[1].childNodes[6].textContent = "结算";         // File goodsSubName
          df.childNodes[0].childNodes[1].childNodes[7].textContent = "删除";         // File goodsSubName
          df.querySelector("img").src = _this.goodService.domain + "file/download/" + data[i].goodsPicture[0]+"/";  // File picture
          section.appendChild(df);
        }  // Handler ending

        document.querySelectorAll("span.calc").forEach(function(item){
          console.log(item);
          item.addEventListener("click",function(){
            console.log("sss",this,data[item.getAttribute("goodsIndex")]);

            // 检查是否登录
            if(!_this.userService.user){
              console.log("未登录");
              -this.Router.navigate(['login'])
            }
            data[item.getAttribute("goodsIndex")].goodsParameter= data[item.getAttribute("goodsIndex")]
            var goodsId = 
            // 订单数据
            _this.goodService.order = { 
              userId: _this.userService.user.userId,
              goodsId: data[item.getAttribute("goodsIndex")],
              goodsDataId: data[item.getAttribute("goodsIndex")].goodsData,
              userContactId: null,
              shoppingNum: this.amount};

            // 跳转到订单
            _this.Router.navigate(['order'])         
            



          })
        })


      },error: function(){}
    });
  }

}
