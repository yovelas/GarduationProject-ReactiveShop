import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, NavigationStart} from '@angular/router'
import * as $ from 'jquery';
import { GoodsService } from '../service/goods.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-goods-list',
  templateUrl: './goods-list.component.html',
  styleUrls: ['./goods-list.component.css',
    './goods-list.component.list.css',
    './goods-list.component.large.css']
})
export class GoodsListComponent implements OnInit {

  constructor(
    private Route: ActivatedRoute,
    private Router: Router,
    private goodService:GoodsService,
    private userService:UserService,
  ) {
    // 默认禁用 list 样式规则
    var listStyle = <CSSStyleSheet>document.styleSheets[8];
    listStyle.disabled = true;
  }

  ngOnInit(): void {
    var _this = this;
    var key = _this.Route.snapshot.params.key;
    var url = "goods/list/" + key;
    if(/type\=\w*/.test(key))
    url = "goods/type/" + key.replace("type=","");

    $.ajax({
      type: "GET",
      url: _this.goodService.domain+url,
      async: false,
      contentType: "application/json",
      dataType: "json",
      crossDomain: true,
      success: function (data) {
        console.log("goodslist:",data);

        var section = document.querySelector("section");  // 查找父元素
        var article =  section.querySelector("article");  // 查找子元素

        // Clone a node and clone all child node of cloned node
        var cloneArticle = article.cloneNode(true);     

        console.log(cloneArticle);

        for(var j = section.childElementCount; j > 0; j--) {  // 清空已有的子节点
          section.removeChild(section.childNodes[j-1]);
        }

        for(var i = 0; i < data.length; i++){   // Fill data and append to parent node
          var df = new DocumentFragment();      // Create a DocumentFragment
          // Append a node of cloned node above and clone all child node of cloned node
          df.appendChild(cloneArticle.cloneNode(true));   
          df.querySelector("article").setAttribute("goods",data[i].goodsId);
          df.querySelector("img").src = _this.goodService.domain + "file/download/" + data[i].goodsPicture[0]+"/";  // File picture
          var Ps = df.querySelectorAll("p");
          Ps[0].innerHTML = "¥ "+ data[i].goodsPrice;  // Fill price
          Ps[1].innerHTML = data[i].goodsName;         // File goodsName
          Ps[2].innerHTML = data[i].goodsSubName;      // File goodsSubName
          section.appendChild(df);
        } 
        // 商品点击事件
        document.querySelectorAll("article").forEach(function(e){
          e.addEventListener("click",function(){
            console.log(this.getAttribute("goods"));
            _this.Router.navigate(['goods/'+this.getAttribute("goods")]);
          })
        }) // Handler ending

      }, error: function () {
        console.log("error")
      }
    })
  }

  list(){   // 列表显示
    console.log("列表显示");
    var listStyle = <CSSStyleSheet>document.styleSheets[8];
    var largeStyle = <CSSStyleSheet>document.styleSheets[9];
    listStyle.disabled = false;
    largeStyle.disabled = true;
  }

  large(){  // 方格显示
    console.log("方格显示");
    var listStyle = <CSSStyleSheet>document.styleSheets[8];
    var largeStyle = <CSSStyleSheet>document.styleSheets[9];
    largeStyle.disabled = false;
    listStyle.disabled = true;
  }
}
