import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './component/header/header.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatSlideToggleModule} from "@angular/material/slide-toggle";
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from "@angular/material/icon";
import { ContentComponent } from './component/content/content.component';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatListModule} from "@angular/material/list";
import { CarComponent } from './component/car/car.component';
import { HomeComponent } from './component/home/home.component';
import { AdminComponent } from './component/admin/admin.component';
import { UserComponent } from './component/user/user.component';
import { LoginComponent } from './component/login/login.component';
import { ForbiddenComponent } from './component/forbidden/forbidden.component';
import {FormsModule} from "@angular/forms";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {RouterModule} from "@angular/router";
import {AuthGuard} from "./component/auth/auth.guard";
import {AuthInterceptor} from "./component/auth/auth.interceptor";
import { SignupComponent } from './component/signup/signup.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ContentComponent,
    CarComponent,
    HomeComponent,
    AdminComponent,
    UserComponent,
    LoginComponent,
    ForbiddenComponent,
    SignupComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSlideToggleModule,
    MatButtonModule,
    MatToolbarModule,
    MatIconModule,
    MatSidenavModule,
    MatListModule,
    FormsModule,
    HttpClientModule,
    RouterModule
  ],
  providers: [
    AuthGuard,
    {
      provide:HTTP_INTERCEPTORS,
      useClass:AuthInterceptor,
      multi:true

    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
