import { Injectable } from '@angular/core';
import { User } from '../class/user';
import { GoodsService } from './goods.service';
import * as $ from 'jquery';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(
    private goods:GoodsService
  ) {
    this.isConnected();
   }
  
  domain = this.goods.domain;
  user = null;
  // user:User;
  // username = "";
  // writeDisplay:boolean = false;
  // addAlbumDisplay:boolean = false;
  // isLogin:boolean = false;
  
  login(username,password,status){
    var success = false;
    var _this = this;
    $.ajax({
      type: "POST",
      url: this.domain+"/user/login/ia",
      async: false,
      contentType: "application/json",
      dataType: "json",
      data: '{"username":"'+username+'", "password":"'+password+'","status":"'+status+'"}',
      xhrFields: { withCredentials: true },
      crossDomain: true,
      success: function (data) {
        console.log(data);
        // _this.isLogin = true;
        if(data.status == 0){
          success = true;
          // _this.isLogin = true;
          // _this.user = data.data;
          // _this.username = data.data.username;
          // console.log(this.user);
          _this.isConnected();
        }
      },
      error: function () {
        console.log("error")
      }
    })
    return success;
  }

  isExist(username){
    var _this = this;
    var result = false;
    $.ajax({
      type: "GET",
      url: this.domain+"/user/isexist",
      async: false,
      contentType: "application/json",
      dataType: "json",
      data: 'username='+username,
      xhrFields: { withCredentials: true },
      crossDomain: true,
      success: function (data) {
        console.log(data);
        if(data.status == 0){
          result = true;
        }
      },
      error: function () {
        console.log("error")
      }
    })
    return result;
  }

  autoLogin(){
    console.log("auto");
    var _this = this;
    $.ajax({
      type: "GET",
      url: this.domain+"/user/login",
      async: false,
      contentType: "application/json",
      dataType: "json",
      xhrFields: { withCredentials: true },
      crossDomain: true,
      success: function (data) {
        console.log(data);
        if(data.status == 0){
          _this.user = data.data;
          // _this.username = data.data.username;
          console.log(this.user);
        }
      },
      error: function () {
        console.log("error")
      }
    })
  }
  
  selfInfo(){
    var _this = this;
    var result = null;
    $.ajax({
      type: "GET",
      url: this.domain+"/user/",
      async: false,
      contentType: "application/json",
      dataType: "json",
      xhrFields: { withCredentials: true },
      crossDomain: true,
      success: function (data) {
        console.log(data);
        result = data.data;
      },
      error: function () {
        console.log("error")
      }
    })
    return result;
  }
  userInfo(id){
    var _this = this;
    var result = null;
    $.ajax({
      type: "POST",
      url: this.domain+"/user/userinfobyid",
      async: false,
      contentType: "application/json",
      dataType: "json",
      data: '{"id":'+id+'}',
      xhrFields: { withCredentials: true },
      crossDomain: true,
      success: function (data) {
        console.log(data);
        result = data.data;
      },
      error: function () {
        console.log("error")
      }
    })
    return result;
  }

  // 判断是否存在cookie
  isLogined(){
    var _this = this;
    $.ajax({
      type: "GET",
      url: this.domain+"/user/islogined",
      async: false,
      contentType: "application/json",
      dataType: "json",
      xhrFields: { withCredentials: true },
      crossDomain: true,
      success: function (data) {
        console.log(data);
        if(data.status = 0)
        _this.isConnected();
      },
      error: function () {
        console.log("error")
      }
    })
  }

  // 判断当前是否连接
  isConnected(){
    var _this = this;
    $.ajax({
      type: "GET",
      url: this.domain+"/user/isconnected",
      async: false,
      contentType: "application/json",
      dataType: "json",
      xhrFields: { withCredentials: true },
      crossDomain: true,
      success: function (data) {
        console.log(data);
        _this.user = data.data;
        if(data.status != 0){
          _this.isLogined()
        }
      },
      error: function () {
        console.log("error")
      }
    })
  }
  register(newUsername, newPassword){
    var _this = this;
    var result = null;
    $.ajax({
      type: "POST",
      url: this.domain+"/user/register",
      async: false,
      contentType: "application/json",
      dataType: "json",
      data: '{"username":"'+newUsername+'","password":"'+newPassword+'"}',
      xhrFields: { withCredentials: true },
      crossDomain: true,
      success: function (data) {
        console.log(data);
        result = data.data;
      },
      error: function () {
        console.log("error")
      }
    })
    return result;
  }
}
