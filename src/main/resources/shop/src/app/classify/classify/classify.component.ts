import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';
import { GoodsService } from '../../service/goods.service';
import { ActivatedRoute, Router } from '@angular/router'

@Component({
  selector: 'app-classify',
  templateUrl: './classify.component.html',
  styleUrls: ['./classify.component.css']
})
export class ClassifyComponent implements OnInit {

  constructor(
    private goodService:GoodsService,
    private Route: ActivatedRoute,
    private Router: Router
  ) { }


  ngOnInit(): void {
    var _this = this;
    $.ajax({
      type: "GET",
      url: this.goodService.domain+"goods/type",
      async: false,
      contentType: "application/json",
      dataType: "json",
      crossDomain: true,
      success: function (data) {
        console.log(data);
        // 清空静态按扭
        $(".list-group").html("");
        // 填充动态按扭
        for(var i = 0;i<data.length;i++){
          var button = <HTMLButtonElement>document.createElement("button");
          button.innerHTML = data[i].goodsMainTypeName;
          button.setAttribute("paTypeId",data[i].goodsMainTypeId)
          $(button).addClass("list-group-item list-group-item-action");
          $(button).attr("id",i);
          $(button).css("background-color","#f8f8f8");
          $(button).css("border","none");
          if(window.innerWidth < 590){
            $(button).css("padding-left","5px");
            $(button).css("padding-right","5px");
            $(button).css("text-align","center");
          }

          $(".list-group").append($(button));
        }
        $(".list-group").on("mouseover", "button", function(){
          $(this).css("background","white");
        })
        $(".list-group").on("mouseout", "button", function(){
          // $(this).css("color","#495057");
          $(this).css("background","#f8f8f8");
        })

        // 清空静态列表
        $("#rightContent").html("");
        // 第一次进入页面强制填充第一项动态列表
        $($(".list-group-item")[0]).css("color","red");
        for(var j = 0; j<data[0].goodsSubTypes.length; j++){
          data[0].goodsSubTypes[j];
          var article = <HTMLElement>document.createElement("article");
          article.setAttribute("chTypeId",data[0].goodsSubTypes[j].goodsSubTypeId);
          $(article).css("text-align","center");
          if(window.innerWidth<450){
            article.innerHTML = "<img width=80 height=80 src='"+_this.goodService.domain+"file/download/"+data[0].goodsSubTypes[j].goodsSubTypePicture+"/'><p style='text-align:center'>" + data[0].goodsSubTypes[j].goodsSubTypeName + "</p>";
          }else{
            article.innerHTML = "<img src='"+_this.goodService.domain+"file/download/"+data[0].goodsSubTypes[j].goodsSubTypePicture+"/'><p style='text-align:center'>" + data[0].goodsSubTypes[j].goodsSubTypeName + "</p>";
          }
          $("#rightContent").find("article");
          $("#rightContent").append(article);
        }
        document.querySelectorAll("article").forEach(function(e){
          e.addEventListener("click",function(){
            console.log(this.getAttribute("chTypeId"));
            _this.Router.navigate(['lists/type='+this.getAttribute("chTypeId")]);
          })
        }) // Handler Enging

        // 窗口改变事件
        $(window).on("resize",function(){
          if(window.innerWidth<450){
            $("#rightContent img").css("width","80px").css("height","80px")
          }
        });
       
        // 按扭点击事件处理
        $(".list-group").on("click","button",function(e){
          var list = data[e.target.id].goodsSubTypes;
          $(".list-group button").css("color","#495057");
          e.target.style.color = "red";
          $("#rightContent").html("");
          for(var i = 0; i<list.length; i++){
            var article = <HTMLElement>document.createElement("article");
            article.setAttribute("chTypeId",list[i].goodsSubTypeId);
            $(article).css("text-align","center");
            if(window.innerWidth<450){
              article.innerHTML = "<img width=80 height=80 src='"+_this.goodService.domain+"file/download/"+list[i].goodsSubTypePicture+"/'><p style='text-align:center'>" + list[i].goodsSubTypeName + "</p>";
            }else{
              article.innerHTML = "<img src='"+_this.goodService.domain+"file/download/"+list[i].goodsSubTypePicture+"/'><p style='text-align:center'>" + list[i].goodsSubTypeName + "</p>";
            }
            $("#rightContent").find("article");
            $("#rightContent").append(article);
          }
          document.querySelectorAll("article").forEach(function(e){
            e.addEventListener("click",function(){
              console.log(this.getAttribute("chTypeId"));
              _this.Router.navigate(['lists/type='+this.getAttribute("chTypeId")]);
            })
          }) // Handler Enging
        });

      },
      error: function () {
        console.log("error")
      }
    })
  }

}
