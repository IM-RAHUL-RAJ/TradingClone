import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { history } from '../models/history';

@Injectable({
  providedIn:'root'
})

export class TradeServiceService {
  public user : User|undefined={
    firstName:'',
    lastName:'',
    emailId:'',
    username:'',
    country:'',
    dateOfBirth:new Date(),
    postalCode:'',
    panCardIdentification:'',
    password:'',
    phoneNumber:'',
    preferences:{
      investmentPurpose:'',
      incomeCategory:'',
      lengthOfInvestment:'',
      riskTolerance:''
    }
  } 
  public orders !: history[];

  addUserToAppAfterLogin(userEntered : User | undefined){
    this.user=userEntered;
  }

  getUser(){
    return this.user;
  }

  getHistory(){
    return this.orders;
  }

  buy(){

  }


  constructor() { }
}
