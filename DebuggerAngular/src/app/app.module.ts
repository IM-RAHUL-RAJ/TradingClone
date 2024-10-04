import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './portfolio/auth/login/login.component';
import { SignupComponent } from './portfolio/auth/signup/signup.component';
import { NavBarComponent } from './portfolio/template/nav-bar/nav-bar.component';
import { FooterComponent } from './portfolio/template/footer/footer.component';
import { HomePageComponent } from './portfolio/pages/home-page/home-page.component';
import { AboutUsComponent } from './portfolio/pages/about-us/about-us.component';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { TradeComponent } from './portfolio/pages/trade/trade.component';
import { AgGridModule } from 'ag-grid-angular';
import { HistoryComponent } from './portfolio/pages/history/history.component';
import { RoboAdvisorComponent } from './portfolio/pages/robo-advisor/robo-advisor.component';
import { ClientReportComponent } from './portfolio/pages/client-report/client-report.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    NavBarComponent,
    FooterComponent,
    HomePageComponent,
    AboutUsComponent,
    TradeComponent,
    HistoryComponent,
    RoboAdvisorComponent,
    ClientReportComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    RouterModule,
    HttpClientModule,
    AgGridModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
