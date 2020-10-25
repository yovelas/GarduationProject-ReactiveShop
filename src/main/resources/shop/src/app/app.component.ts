import { Component } from '@angular/core';
import { ActivatedRoute, Router, NavigationStart} from '@angular/router'
import { UserService } from './service/user.service';
import { GoodsService } from './service/goods.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'web';
  constructor(
    private Route: ActivatedRoute,
    private userService:UserService,
    private goodsService:GoodsService,
    private Router: Router
  ){ 
    this.Router.events.pipe().subscribe(route => {
      if(route instanceof NavigationStart){
        if((route.url == "/person" || route.url == "/message" || route.url == "/car") && !userService.user){
          this.Router.navigate(['login'])
        }
      }
    })
  }
}
