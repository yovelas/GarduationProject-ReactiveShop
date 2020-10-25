import { Component, OnInit } from '@angular/core';
import { GoodsService } from '../service/goods.service';
import * as $ from 'jquery';
import { ActivatedRoute, Router } from '@angular/router'

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  constructor(
    private goodService:GoodsService,
    private Router: Router
  ) { }

  searchText:String;

  ngOnInit(): void {
    var _this = this;
    $(document).on("click","li a",function(e){
      _this.goodService.navControl = false;
      $(".toggle-btn i").removeClass("fa-times-circle").addClass("fa-bars");
    });
    $(window).on("resize",function(e){
      if(window.innerWidth < 480){
        $("#nav ul").css("display","none");
      }else{
        $("#nav ul").css("display","inline-block");
      }
    });
  }
  ngDoCheck(){
    if(window.innerWidth < 480){
      if(this.goodService.navControl){
        $("#nav ul").css("display","block");
        $("#nav li").css("display","block");
        $("#nav a").css("display","block");
      }else{
        $("#nav ul").css("display","none");
        $("#nav li").css("display","inline-block");
        $("#nav a").css("display","inline-block");
      }
    }
  }

  search(){
    console.log("Search:",this.searchText);
    this.Router.navigate(['lists/'+this.searchText]);
    this.searchText = "";
  }

}
