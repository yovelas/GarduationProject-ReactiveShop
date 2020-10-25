import { Component, OnInit, ɵ_sanitizeHtml } from '@angular/core';
import * as $ from 'jquery';
import { GoodsService } from '../service/goods.service';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-goods',
  templateUrl: './goods.component.html',
  styleUrls: ['./goods.component.css']
})
export class GoodsComponent implements OnInit {

  constructor(
    private goodService:GoodsService,
    private userService:UserService,
    private Route: ActivatedRoute,
    private Router: Router
  ) { }

  parameter = new Object();
  data;
  goodsData;
  amount = 1;

  ngOnInit(): void {
    var _this = this;
    $.ajax({
      type: "GET",
      url: _this.goodService.domain+"goods/"+_this.Route.snapshot.params.id,
      async: false,
      contentType: "application/json",
      dataType: "json",
      crossDomain: true,
      success: function (data) {
        console.log("goods:",data);
        _this.data = data;
      
        // 图片填充
        $("#mainBox img").attr("src",_this.goodService.domain+"file/download/"+data.goodsPicture[0]+"/")
        for(var k = 0; k < data.goodsPicture.length; k++){
          console.log($("#picList img")[k].src = _this.goodService.domain+"file/download/"+data.goodsPicture[k]+"/");
        }
       
        // 缩略图按扭
        $("#picList img").on("click",function(){
          console.log($("#mainBox img").attr("src",this.src));
        });

        // 绑定移动端滑动事件
        var startX,startY,moveEndX,moveEndY,X,Y;
        $("#mainBox img").on("touchstart", function(e) {
          startX = e.originalEvent.changedTouches[0].pageX,
          startY = e.originalEvent.changedTouches[0].pageY;
        });

        $("#mainBox img").on("touchend", function(e) {			
          moveEndX = e.originalEvent.changedTouches[0].pageX,
          moveEndY = e.originalEvent.changedTouches[0].pageY,
          X = moveEndX - startX,
          Y = moveEndY - startY;

          // 获取当前主图的路径
          var src = $("#mainBox img").attr("src").match(/\/\w*\.\w*\//)[0];
          for(var l = 0; l < data.goodsPicture.length; l++){

            // 定位当前图片与图片列表
            if(data.goodsPicture[l] == src.slice(1,src.length-1)){
              if ( X > 0 ) {        // 右滑
                if(l == data.goodsPicture.length-1)     // 若当前是最后一张时
                  src = data.goodsPicture[0]            // 跳转到第一张
                else src = data.goodsPicture[l+1]       // 若不是最后一张，则下一张
              } else if ( X < 0 ) { // 左滑
                if(l == 0) src = data.goodsPicture[data.goodsPicture.length-1] // 若当前是第一张，跳转到最后一张
                else src = data.goodsPicture[l-1]                              // 若不是第一张，则上一张
              }
              // 更新图片
              $("#mainBox img").attr("src",_this.goodService.domain+"file/download/"+src+"/");
            }
          }
        }); // 移动端滑动事件结束


        // 商品参数
        $("#right h3").html(data.goodsSubName);
        $("#right>p:nth-of-type(1) span").html("¥"+data.goodsPrice);
        $("#right>p:nth-of-type(2) span").html(data.goodsSource);
        $("#right>p:nth-of-type(4) span span").html(data.goodsInventory);

        // 商品选项
        var str = "";
        $("#parameter").html("");
        for(var i = 0;i< data.goodsParameter.length; i++){
          console.log(data.goodsParameter[i].goodsParameter);
          str += "<p style='font-size: 12px; height: 40px; color: gray;'>"+data.goodsParameter[i].goodsParameter+"<span style='  font-size: 15px; margin-left: 30px; color: black;'>";
          
          for(var j = 0; j< data.goodsParameter[i].goodsParameterOption.length; j++){
            if(data.goodsParameter[i].goodsParameterOption[j].goodsPicture){
              str += "<img class='param' style='width:40px; margin-right: 10px' title=\""+data.goodsParameter[i].goodsParameterOption[j].goodsOption+"\" src='"+_this.goodService.domain+"file/download/"+data.goodsParameter[i].goodsParameterOption[j].goodsPicture+"/' param='"+data.goodsParameter[i].id+"' option='"+data.goodsParameter[i].goodsParameterOption[j].id+"'>";
            }else
              str += "<button class='param' style='border: #eee solid 1px; border-radius: 5px; margin-right: 5px; outline: none; background: white;' param='"+data.goodsParameter[i].id+"' option='"+data.goodsParameter[i].goodsParameterOption[j].id+"'>"+data.goodsParameter[i].goodsParameterOption[j].goodsOption+"</button>"
          }
          str += "</span></p>";
        }

        // 窗口改变事件
        $("#parameter").html(str);
        function resize(){
          if(innerWidth > 840){
            $("#parameter p").css("font-size","12px").css("height","40px");
            $("#parameter span").css("font-size","15px").css("margin-left","30px");
            $("#right>p:nth-of-type(1) span").css("font-size","26px").css("margin-left","30px");
            $("#right p:nth-of-type(1)").css("margin-top","30px");
            $("#parameter button").css("font-size","16px");

          }else if(innerWidth < 840 && innerWidth > 580){
            $("#parameter p").css("font-size","10px").css("height","25px");
            $("#parameter span").css("margin-left","8px");
            $("#right>p:nth-of-type(1) span").css("font-size","20px").css("margin-left","8px");
            $("#right p:nth-of-type(1)").css("margin-top","10px");
            $("#parameter button").css("font-size","12px");
          }else if(innerWidth < 580){
            console.log("sdfsdf");
            $("#parameter p").css("font-size","14px").css("height","35px").css("font-weight","500");
            $("#parameter span").css("margin-left","8px");
            $("#right p:nth-of-type(1) span").css("margin-left","8px").css("margin-top","20px").css("font-size","20px");
            $("#parameter button").css("font-size","16px").css("font-weight","600");
          }
        }
        resize();
        $(window).on("resize",resize);

        // 格式化商品详情文本
        var result, pattern = /\(\w*\,(\#)?\w*,\w*,\w*\)\:\:/g,text = data.goodsDescribe;
        while((result = pattern.exec(text)) != null) {  // 转样式表记为CSS样式格式
          var itmes = result[0].match(/\w*\,(\#)?\w*,\w*,\w*/)[0].split(",");
          console.log(itmes);
          itmes[0] = "text-align:" + itmes[0];
          itmes[1] = "color:" + itmes[1];
          itmes[2] = "display:" + itmes[2];
          itmes[3] = "font-size:" + itmes[3] + "px";
          var style = " style=\""+itmes.join(";")+"\"";
          text = text.slice(0,result.index)+"<p"+style+">"+text.slice(pattern.lastIndex,text.length-1)
        }
        // 转换结束标记，图片标记
        text = text.replace(/%%%/g,"</p>").replace(/\!\[\]\(/g,"<img style='width:100%' src='"+_this.goodService.domain+"/file/download/").replace(/\)/g,"/' />");
        console.log("a",text);
        $("#details").html(text);

        // 参数按扭鼠标悬浮事件
        document.querySelectorAll("img.param,button.param").forEach(function(e){
          e.addEventListener('mouseout', function(){
            $(e).css("border","#eee solid 1px");
          })
        });
        // 参数按扭点击事件
        document.querySelectorAll("img.param,button.param").forEach(function(e){
          e.addEventListener('click', function(){
            $(e).css("border","red solid 1px");
            var p = e.getAttribute('param'), o = e.getAttribute('option');
            _this.parameter[p] = o;
            data.goodsData.forEach(function(value, index){
              var flag = true;
              var item =  JSON.parse(
                value.goodsConfiguration
                  .replace(/\{/,"{\"")
                  .replace(/\:/g,"\"\:\"")
                  .replace(/\,/,"\"\,\"")
                  .replace(/\}/,"\"}"))
              for(let compartItem in item){
                if(item[compartItem] != _this.parameter[compartItem]) flag = false;
              }
              if(flag){
                console.log(flag,item,_this.parameter,data.goodsData[index]);
                _this.goodsData = data.goodsData[index];
                $("#right>p:nth-of-type(1) span").html("¥"+data.goodsData[index].goodsPrice);
              }
            })
          });
        });  // handler ending

      },
      error: function () {
        console.log("error")
      }
    })
  }// OnInit Ending

  buy(){
    console.log("buy");
    // 检查是否登录
    if(!this.userService.user){
      console.log("未登录");
      this.Router.navigate(['login'])
    }
    // 检查参数是否选择完整
    if(!this.goodsData){
      console.log("参数未选择完整");
      alert("请选择参数");
    }
    // 订单数据
    this.goodService.order = { 
      userId: this.userService.user.userId,
      goodsId: this.data,
      goodsDataId: this.goodsData,
      userContactId: null,
      shoppingNum: this.amount};
    
    // 跳转到订单
    this.Router.navigate(['order'])

  }

  car(){
    console.log("car");
    var _this = this;
    
    // 检查是否登录
    if(!this.userService.user){
      console.log("未登录");
      this.Router.navigate(['login'])
      return
    }
    // 检查参数是否选择完整
    if(!this.goodsData){
      console.log("参数未选择完整");
      alert("请选择参数");
    }
    // 订单数据
    var shopping = { 
      usersId: this.userService.user.userId,
      goodsId: this.data.goodsId,
      goodsDataId: this.goodsData.id,
      shoppingNum: this.amount,
    };
    console.log(shopping);

    $.ajax({
      type: "POST",
      url: this.goodService.domain+"shopping",
      async: false,
      contentType: "application/json",
      dataType: "json",
      data: JSON.stringify(shopping),
      crossDomain: true,
      success: function (data) {
        console.log(data);
      },
      error: function () {}
    });

  }

}
