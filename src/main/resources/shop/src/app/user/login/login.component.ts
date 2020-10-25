import { Component, OnInit } from '@angular/core';
import { UserService } from '../../service/user.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common'


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(
    private location: Location,
    private userService: UserService
  ) { }

  username:String = null;
  password:String;
  keepClass:String = "fa fa-square-o fa-lg";
  keepIn:Boolean = false;

  heightIncrease:number = 0;
  transition500:boolean = false;

  ngOnInit(): void {
    var _this = this;
    // 按压清理高度增加
    document.querySelectorAll("input.infoInput").forEach(function(item){
      item.addEventListener("keyup",function(){
        var loginContent = document.querySelector("#login_content");
        var passwordContent = document.querySelector("#password_content");
        if(window.getComputedStyle(loginContent, null).display == "block"){
          _this.clearError("login");
        }
        if(window.getComputedStyle(passwordContent, null).display == "block"){
          _this.clearError("password");
        }
      });
    })
    // 窗口改变
    window.addEventListener("resize",function(){
      // 登录框高度变化
      var mainBox = <HTMLElement>document.querySelector("#main_bg>div");
      if(window.innerWidth < 500){
        mainBox.style.height = "100%";
        if(!_this.transition500){
          mainBox.style.height = parseInt(window.getComputedStyle(mainBox, null).height.replace("px",""))- _this.heightIncrease + "px";
          _this.transition500 = true;
        }
      }else{
          mainBox.style.height = 380 + _this.heightIncrease + "px";
          if(window.getComputedStyle(document.querySelector("#password_content"), null).display == "block") mainBox.style.height = 420 + _this.heightIncrease + "px";
          else mainBox.style.height = 380 + _this.heightIncrease + "px";
        if(_this.transition500){
          mainBox.style.height = parseInt(window.getComputedStyle(mainBox, null).height.replace("px",""))+ _this.heightIncrease + "px";
          _this.transition500 = false;
        }
      }
    })
    // 回车键登录
    window.addEventListener("keyup",function(e){
      var loginContent = document.querySelector("#login_content");
      var passwordContent = document.querySelector("#password_content");
      if(window.getComputedStyle(loginContent, null).display == "block" && e.code == "Enter"){
        _this.verifyUsername();
      }else if(window.getComputedStyle(passwordContent, null).display == "block" && e.code == "Enter"){
        _this.verifyPassword();
      }

    })
  }

  // 验证用户名
  verifyUsername(){
    if(!this.username)
    this.addError("Account cannot be null","login",24);
    else if(!this.userService.isExist(this.username))
    this.addError("Account is not exist","login",24);
    else{
      // 跳转到密码界面，并清理高度增加
      var loginContent = <HTMLElement>document.querySelector("#login_content");
      var passwordContent = <HTMLElement>document.querySelector("#password_content");
      loginContent.style.display = "none";
      passwordContent.style.display = "block";
      this.clearError("login");
    }
  }

  // 验证密码
  verifyPassword(){
    if(!this.password)
    this.addError("Password cannot be null","password",24);
    else if(!this.userService.login(this.username,this.password,this.keepIn))
    this.addError("Account or password was worry","password",24);
    else{
      // 跳转到进入登录页面之前
      // this.router.navigate(['person']);
      this.location.back();
    }
  }

  // 返回到帐户验证
  back(){
      var loginContent = <HTMLElement>document.querySelector("#login_content");
      var passwordContent = <HTMLElement>document.querySelector("#password_content");
      loginContent.style.display = "block";
      passwordContent.style.display = "none";
      this.clearError("password");
  }

  // 验证密码时的Keep选框
  keep(){
    if(this.keepClass == "fa fa-square-o fa-lg") {
      this.keepClass = "fa fa-check-square fa-lg";
      this.keepIn = true;
    } else {
      this.keepClass = "fa fa-square-o fa-lg";
      this.keepIn = false;
    }
  }

  addError(message,location,increase):void {
    // 添加错误信息，并增加高度
    var error = document.querySelector("div."+location+"Msg");
    var mainBox = <HTMLElement>document.querySelector("#main_bg>div#"+location+"_content");
    // 小于500宽度只做变量修改，不改窗口
    if(window.innerWidth > 500){
      mainBox.style.height = parseInt(window.getComputedStyle(mainBox, null).height.replace("px",""))+increase + "px";
    }
    this.heightIncrease = increase;
    error.innerHTML = message;
  }

  clearError(location):void {
    var error = document.querySelector("div."+location+"Msg");
    var mainBox = <HTMLElement>document.querySelector("#main_bg>div#"+location+"_content");
    // 小于500宽度只做变量修改，不改窗口
    if(window.innerWidth > 500)
    mainBox.style.height = parseInt(window.getComputedStyle(mainBox, null).height.replace("px",""))- this.heightIncrease + "px";
    this.heightIncrease = 0;
    error.innerHTML = "";
  }
}
