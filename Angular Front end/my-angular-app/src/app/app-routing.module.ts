import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CarComponent} from "./component/car/car.component";
import {HomeComponent} from "./component/home/home.component";
import {AdminComponent} from "./component/admin/admin.component";
import {UserComponent} from "./component/user/user.component";
import {LoginComponent} from "./component/login/login.component";
import {ForbiddenComponent} from "./component/forbidden/forbidden.component";

const routes: Routes = [
  {path:'cars',component:CarComponent},
  {path:'home',component:HomeComponent},
  {path:'admin',component:AdminComponent},
  {path:'user',component:UserComponent},
  {path:'login',component:LoginComponent},
  {path:'forbidden',component:ForbiddenComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
