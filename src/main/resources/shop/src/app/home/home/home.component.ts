import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';
import { GoodsService } from '../../service/goods.service';
import { ActivatedRoute, Router, NavigationStart} from '@angular/router'

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(
    private Router: Router,
    private goodService:GoodsService
  ) { }

  ngOnInit(): void {
    var _this = this;
    $.ajax({
      type: "GET",
      url: _this.goodService.domain+"goods",
      async: false,
      contentType: "application/json",
      dataType: "json",
      crossDomain: true,
      success: function (data) {
        console.log(data);
        var article = $("article");
        for(var i = 0;i<article.length;i++){
          article[i].setAttribute("goods",data[i].goodsId);
          $($($(article)[i]).children("p")[0]).html(data[i].goodsName);
          $($($(article)[i]).children("p")[1]).html(data[i].goodsSubName);
          $($($(article)[i]).children("img")[0]).attr("src",_this.goodService.domain+"file/download/"+data[i].goodsPicture[0]+"/");
        }
        // 商品点击事件
        document.querySelectorAll("article").forEach(function(e){
          e.addEventListener("click",function(){
            console.log(this.getAttribute("goods"));
            _this.Router.navigate(['goods/'+this.getAttribute("goods")]);
          })
        }) // Handler ending
      },
      error: function () {
        console.log("error")
      }
    })

  }

}
