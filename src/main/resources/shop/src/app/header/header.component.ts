import { Component, OnInit } from '@angular/core';
import { CloneVisitor } from '@angular/compiler/src/i18n/i18n_ast';
import * as $ from 'jquery';
import { GoodsService } from '../service/goods.service';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private goodService:GoodsService) { }

  ngOnInit(): void {
        // $(".toggle-btn i").show();
    $(window).on("resize",function(e){
      if(window.innerWidth < 480){
      $(e.target).removeClass("icon-remove-sign").addClass("icon-reorder");
        $(".toggle-btn i").show();
      }
    });
  }

  nav(e){
    var _this = this;
    console.log(e,$(e.target).attr("class"));
    if($(e.target).attr("class") == "fa fa-bars"){
      $(e.target).removeClass("fa-bars").addClass("fa-times-circle");
      _this.goodService.navControl = true;
    }else{
      $(e.target).removeClass("fa-times-circle").addClass("fa-bars");
      _this.goodService.navControl = false;
    }
  }

}
