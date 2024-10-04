import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './portfolio/auth/login/login.component';
import { SignupComponent } from './portfolio/auth/signup/signup.component';
import { HomePageComponent } from './portfolio/pages/home-page/home-page.component';
import { AboutUsComponent } from './portfolio/pages/about-us/about-us.component';
import { TradeComponent } from './portfolio/pages/trade/trade.component';
import { PreferencesComponent } from './portfolio/pages/preferences/preferences.component';
import { HistoryComponent } from './portfolio/pages/history/history.component';
import { RoboAdvisorComponent } from './portfolio/pages/robo-advisor/robo-advisor.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'home', component: HomePageComponent },
  { path: 'about', component: AboutUsComponent }, 
  { path: '', redirectTo: '/signup', pathMatch: 'full' },
  { path: 'trade', component:TradeComponent},
  { path:'preferences', component:PreferencesComponent},
  { path:'history', component:HistoryComponent},
  {path: 'roboAdvisor', component:RoboAdvisorComponent},
  {path: 'updatePreference', component: PreferencesComponent},
  {path:'**', redirectTo:'/home'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
