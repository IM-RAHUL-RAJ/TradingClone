import { Component } from '@angular/core';
import { RoboAdvisorServiceService } from '../../../services/robo-advisor-service.service'
import { ActivatedRoute } from '@angular/router';
import { TradeServiceService } from 'src/app/services/trade-service.service';

@Component({
  selector: 'app-robo-advisor',
  templateUrl: './robo-advisor.component.html',
  styleUrls: ['./robo-advisor.component.css']
})
export class RoboAdvisorComponent {
  riskValue : string = '';
  email: any;

  constructor(private roboAdvisorService : RoboAdvisorServiceService, private route : ActivatedRoute, private tradeService:TradeServiceService){ }

  user = this.tradeService.getUser()

  roboAdvisorData : any;
  ngOnInit(){
    // this.email = this.route.snapshot.paramMap.get('email');
    this.roboAdvisorService.getRiskValue().subscribe({
      next:(x:any)=>{
        this.riskValue = x;
        console.log("Risk Value", this.riskValue)
      }
    })
    this.getRoboAdvisorData(this.riskValue)

    console.log("Email,", this.email+"the risk value", this.riskValue )
  }

  getRoboAdvisorData(riskValue:string){
    this.roboAdvisorService.getRoboAdvisorData(riskValue).subscribe((data:any)=>{
      this.roboAdvisorData = data;
    })
    console.log("Data in RA", this.roboAdvisorData)
  }
}
