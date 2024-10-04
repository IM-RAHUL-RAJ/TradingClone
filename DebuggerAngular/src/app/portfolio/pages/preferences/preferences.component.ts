import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { TradeServiceService } from 'src/app/services/trade-service.service';
import { userDB } from 'src/app/user-db';

@Component({
  selector: 'app-preferences',
  templateUrl: './preferences.component.html',
  styleUrls: ['./preferences.component.css']
})
export class PreferencesComponent {

  constructor(private router:Router, private tradeService:TradeServiceService){}

  preferences:User['preferences']={incomeCategory:'',lengthOfInvestment:'',investmentPurpose:'',riskTolerance:''}

  skipToHome(){
    this.router.navigate(['home']);
  }

  addToUserDB(){
    var loggedInUser=this.tradeService.getUser();
    this.preferences!.incomeCategory=(document.getElementById('incomeCategory') as HTMLSelectElement).value;
    this.preferences!.investmentPurpose=(document.getElementById('investmentPurpose') as HTMLSelectElement).value;
    this.preferences!.lengthOfInvestment=(document.getElementById('lengthOfInvestment') as HTMLSelectElement).value;
    this.preferences!.riskTolerance=(document.getElementById('riskTolerance') as HTMLSelectElement).value;
    var currentUser=userDB.findIndex((DBuser)=>(DBuser===loggedInUser));
    userDB[currentUser].preferences=this.preferences;
    console.log(userDB[currentUser]);
    this.skipToHome();
  }

}
