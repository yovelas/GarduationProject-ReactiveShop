import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home/home.component';
import { ClassifyComponent } from './classify/classify/classify.component';
import { GoodsComponent } from './goods/goods.component';
import { GoodsListComponent } from './goods-list/goods-list.component';
import { PersonComponent } from './person/person/person.component';
import { CarComponent } from './car/car/car.component';
import { LoginComponent } from './user/login/login.component';
import { OrderComponent } from './order/order.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';


const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'classify', component: ClassifyComponent },
  { path: 'goods/:id', component: GoodsComponent },
  { path: 'lists/:key', component: GoodsListComponent },
  { path: 'car', component: CarComponent },
  { path: 'person', component: PersonComponent },
  { path: 'login', component: LoginComponent },
  { path: 'order', component: OrderComponent },
  { path: '**', component: PageNotFoundComponent }
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
