import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { TradeServiceService } from 'src/app/services/trade-service.service';
import { userDB } from 'src/app/user-db';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent {

  public loggedIn:boolean=false;

  constructor(private tradeService:TradeServiceService, private router:Router){}

  checkLoggedIn(){
    console.log('BUTTON CLICKED');
    console.log(this.loggedIn);
    
    if(this.loggedIn===true){
      if(document.getElementById('nav-home')!.innerText==='Home'){
        this.router.navigate(['home'])
      } else if(document.getElementById('nav-portfolio')!.innerText==='Portfolio'){
        this.router.navigate(['home'])
      }else if(document.getElementById('nav-trade')!.innerText==='Buy/Sell'){
        this.router.navigate(['trade'])
      }else if(document.getElementById('nav-roboAdvisor')!.innerText==='RoboAdvisor'){
        this.router.navigate(['roboAdvisor'])
      }
    }
    else{
      this.router.navigate(['login'])
    }
  }

  ngOnInit(){
    if(this.tradeService.getUser()!.firstName!==''){
      this.loggedIn=true;      
    }
  }

}
